package co.imdo.perfect.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolAbstract;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liusy
 * Redis 配置类
 */
@EnableCaching
@Configuration
public class RedisConfig {

    @Value("${spring.sentinel.enable:false}")
    private boolean sentinelEnable;

    @Value("${spring.redis.host:localhost}")
    private String host;

    @Value("${spring.redis.port:6379}")
    private int port;

    @Value("${spring.redis.password:}")
    private String password;

    @Value("${spring.redis.timeout:0}")
    private int timeout;

    @Value("${spring.redis.jedis.pool.max-idle:8}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.max-wait:10000}")
    private long maxWaitMillis;


    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public JedisPoolAbstract redisPoolFactory() {
        if (!sentinelEnable) {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxIdle(maxIdle);
            jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
            if (StringUtils.isNotBlank(password)) {
                return new JedisPool(jedisPoolConfig, host, port, timeout, password);
            } else {
                return new JedisPool(jedisPoolConfig, host, port, timeout);
            }
        } else {
            List<String> nodes = redisProperties.getSentinel().getNodes();
            Set<String> nodeSets = new HashSet<>();
            for (String node : nodes) {
                nodeSets.add(node);
            }
            JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(
                    redisProperties.getSentinel().getMaster()
                    , nodeSets
                    , getJedisPoolConfig()
                    , StringUtils.isBlank(redisProperties.getSentinel().getPassword()) ? "" : redisProperties.getSentinel().getPassword());
            return jedisSentinelPool;
        }

    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        if (!sentinelEnable) {
            RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
            redisStandaloneConfiguration.setHostName(host);
            redisStandaloneConfiguration.setPort(port);
            redisStandaloneConfiguration.setPassword(RedisPassword.of(password));

            JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
            jedisClientConfiguration.connectTimeout(Duration.ofMillis(timeout));
            jedisClientConfiguration.usePooling();
            return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration.build());
        } else {
            return new JedisConnectionFactory(getRedisSentinelConfiguration(), getJedisPoolConfig());
        }
    }

    //    @Bean
    public RedisSentinelConfiguration getRedisSentinelConfiguration() {
        List<String> nodes = redisProperties.getSentinel().getNodes();
        Set<RedisNode> redisNodes = new HashSet<>(nodes.size());
        for (String node : nodes) {
            String[] split = StringUtils.split(node, ":");
            redisNodes.add(new RedisNode(split[0], Integer.parseInt(split[1])));
        }
        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
        redisSentinelConfiguration.setMaster(redisProperties.getSentinel().getMaster());
        redisSentinelConfiguration.setSentinels(redisNodes);
        redisSentinelConfiguration.setSentinelPassword(StringUtils.isBlank(redisProperties.getSentinel().getPassword()) ? "" : redisProperties.getSentinel().getPassword());
        return redisSentinelConfiguration;
    }

    @Bean
    public JedisPoolConfig getJedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // 是否启用pool的jmx管理功能, 默认true
        jedisPoolConfig.setJmxEnabled(true);
        return jedisPoolConfig;
    }


    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * 缓存管理器
     *
     * @param redisConnectionFactory redis 连接工厂
     * @return CacheManager
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(redisConnectionFactory);
        return builder.build();
    }

    @Bean
    public KeyGenerator wiselyKeyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            Arrays.stream(params).map(Object::toString).forEach(sb::append);
            return sb.toString();
        };
    }

    @Bean
//    @ConditionalOnMissingBean(StringRedisTemplate.class)
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForHash();
    }

    @Bean
    public ValueOperations<String, String> valueOperations(RedisTemplate<String, String> redisTemplate) {
        return redisTemplate.opsForValue();
    }

    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForList();
    }

    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForSet();
    }

    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }
}
