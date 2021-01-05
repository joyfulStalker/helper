package common.service.impl;

import common.common.properties.RedisKeys;
import common.function.JedisExecutor;
import common.service.JedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolAbstract;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * @author liu
 */
public class JedisServiceImpl implements JedisService {

    @Autowired
    private JedisPoolAbstract jedisPoolAbstract;

    /**
     * jedis执行器
     * <p>
     * 带资源的try语句（try-with-resource）的最简形式为：
     * try(Resource res = xxx)  //可指定多个资源
     * {
     * work with res
     * }
     * try块退出时，会自动调用res.close()方法，关闭资源。
     *
     * @param executor
     * @param <T>
     * @return
     * @throws JedisConnectionException
     */
    private <T> T executeByJedis(JedisExecutor<Jedis, T> executor) throws JedisConnectionException {

        try (Jedis jedis = jedisPoolAbstract.getResource()) {
            return executor.excute(jedis);
        } catch (Exception e) {
            throw new JedisConnectionException(e.getMessage());
        }
    }

    /**
     * 上传脚本
     * 把所有的redis用到的lua脚本统一上传，得到的sha值，统一放到一个类里面
     *
     * @return
     */
    @Bean
    public RedisKeys getRedisKeys() {

        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("redislua/distributedId.lua")));
        redisScript.setResultType(Boolean.class);

        RedisKeys redisKeys = new RedisKeys();
        executeByJedis(jedis -> {
            String distributeIdShaKey = jedis.scriptLoad(redisScript.getScriptAsString());
            System.out.println("distributeIdShaKey:" + distributeIdShaKey);
            redisKeys.setDistributeIdShaKey(distributeIdShaKey);
            return jedis;
        });
        return redisKeys;
    }

    @Override
    public String set(String key, String value) {
        return executeByJedis(jedis -> jedis.set(key, value));
    }

    @Override
    public String get(String key) {
        return executeByJedis(jedis -> jedis.get(key));
    }

    @Override
    public Object evalsha(String sha1, int keyCount, String... params) {
        return executeByJedis(jedis -> jedis.evalsha(sha1, keyCount, params));
    }

}
