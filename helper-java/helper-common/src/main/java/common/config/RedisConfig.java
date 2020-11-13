package common.config;

import common.common.properties.RedisKeys;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Desc redis的配置
 * @Author liuSongLin
 * @Date 2020/7/11 17:18
 * @Version 1.0v
 **/
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.pool.min-idle}")
    private int minIdle;

    @Value("${spring.redis.pool.max-wait}")
    private long maxWaitMillis;

    @Value("${spring.redis.pool.max-active}")
    private int maxWaitActive;

    /**
     * 把所有的redis用到的lua脚本统一上传，得到的sha值，统一放到一个类里面
     *
     * @param jedisPool
     * @return
     */
    @Bean
    public RedisKeys getRedisKeys(JedisPool jedisPool) {
        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("redislua/distributedId.lua")));
        redisScript.setResultType(Boolean.class);

        Jedis jedis = jedisPool.getResource();
        String distributeIdShaKey = jedis.scriptLoad(redisScript.getScriptAsString());
        System.out.println("distributeIdShaKey:" + distributeIdShaKey);
        //使用完，一定要记得还回去，否则会资源不足 Could not get a resource from the pool
        jedis.close();

        RedisKeys redisKeys = new RedisKeys();
        redisKeys.setDistributeIdShaKey(distributeIdShaKey);
        return redisKeys;
    }

    @Bean
    public JedisPool getJedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxTotal(maxWaitActive);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, StringUtils.isBlank(password) ? null : password);
        return jedisPool;
    }

}
