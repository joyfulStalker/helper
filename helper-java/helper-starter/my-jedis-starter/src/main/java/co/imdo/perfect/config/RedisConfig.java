package co.imdo.perfect.config;

import co.imdo.perfect.properties.RedisShaKeys;
import co.imdo.perfect.utils.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.util.Assert;
import redis.clients.jedis.*;
import redis.clients.jedis.exceptions.JedisConnectionException;

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


    /**
     * 上传脚本
     * 把所有的redis用到的lua脚本统一上传，得到的sha值，统一放到一个类里面
     *
     * @return
     */
    @Bean
    public RedisShaKeys getRedisShaKeys(JedisPoolAbstract jedisPoolAbstract) {
        List<String> redisKeyList = ReflectUtil.getObjectNames(RedisShaKeys.class);
        Assert.notEmpty(redisKeyList, "please defined redisKeys ...");
        RedisShaKeys redisKeys = new RedisShaKeys();
        try (Jedis jedis = jedisPoolAbstract.getResource()) {
            for (String redisKey : redisKeyList) {
                DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<>();
                redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("redislua/" + redisKey + ".lua")));
                redisScript.setResultType(Boolean.class);
                String sha1 = jedis.scriptLoad(redisScript.getScriptAsString());
                log.info("the sha1's value of " + redisKey + " is: " + sha1);
                ReflectUtil.invoke(redisKeys, redisKey, sha1);
            }
        } catch (Exception e) {
            throw new JedisConnectionException(e.getMessage());
        }
        return redisKeys;
    }
}
