package co.imdo.perfect.service.impl;

import co.imdo.perfect.function.JedisExecutor;
import co.imdo.perfect.service.JedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolAbstract;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * @author liu
 */
@Service
public class JedisServiceImpl implements JedisService {

    @Autowired
    private JedisPoolAbstract jedisPool;

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
    private <T> T excuteByJedis(JedisExecutor<Jedis, T> executor) throws JedisConnectionException {

        try (Jedis jedis = jedisPool.getResource()) {
            return executor.excute(jedis);
        } catch (Exception e) {
            throw new JedisConnectionException(e.getMessage());
        }
    }

    @Override
    public String set(String key, String value) {
        return excuteByJedis(jedis -> jedis.set(key, value));
    }

    @Override
    public String get(String key) {
        return excuteByJedis(jedis -> jedis.get(key));
    }
}
