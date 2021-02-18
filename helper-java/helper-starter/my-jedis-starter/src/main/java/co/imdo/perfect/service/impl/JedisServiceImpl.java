package co.imdo.perfect.service.impl;

import co.imdo.perfect.function.JedisExecutor;
import co.imdo.perfect.service.JedisService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public String set(String key, String value) {

        return executeByJedis(jedis -> jedis.set(key, value));
    }

    @Override
    public String setex(String key, int seconds, String value) {
        return executeByJedis(jedis -> jedis.setex(key, seconds, value));
    }

    @Override
    public String get(String key) {
        return executeByJedis(jedis -> jedis.get(key));
    }

    @Override
    public Long del(String... key) {
        return executeByJedis(jedis -> jedis.del(key));
    }

    @Override
    public Object evalsha(String sha1, int keyCount, String... params) {
        return executeByJedis(jedis -> jedis.evalsha(sha1, keyCount, params));
    }
}
