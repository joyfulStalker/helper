package common.function;

import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * @author liu
 */
@FunctionalInterface
public interface JedisExecutor<T, R> {

    /**
     * jedis执行器
     *
     * @param t
     * @return
     * @throws JedisConnectionException
     */
    R excute(T t) throws JedisConnectionException;
}