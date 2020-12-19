package co.imdo.perfect.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolAbstract;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liu
 * Redis 配置类
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public JedisPoolAbstract jedisPool() {
        if (redisProperties.getSentinel() != null) {
            List<String> nodes = redisProperties.getSentinel().getNodes();
            Set<String> nodeSets = new HashSet<>();
            for (String node : nodes) {
                nodeSets.add(node);
            }
            JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(
                    redisProperties.getSentinel().getMaster()
                    , nodeSets
                    , redisProperties.getPassword()
                    , redisProperties.getSentinel().getPassword()
            );
            return jedisSentinelPool;
        } else {
            return new JedisPool(getJedisPoolConfig(), redisProperties.getHost(), redisProperties.getPort(),
                    (int) redisProperties.getTimeout().toMillis(), redisProperties.getPassword());
        }
    }


    /**
     * jedisPoolConfig
     *
     * @return
     */
    private JedisPoolConfig getJedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        RedisProperties.Pool pool = redisProperties.getJedis().getPool();
        if (pool != null) {
            jedisPoolConfig.setMaxIdle(pool.getMaxIdle());
            jedisPoolConfig.setMaxWaitMillis(pool.getMaxWait().toMillis());
            //其他配置根据需要配置
        }
        return jedisPoolConfig;
    }
}
