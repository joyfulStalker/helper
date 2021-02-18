package co.imdo.perfect.service;

/**
 * jedis公用方法
 *
 * @author liu
 */
public interface JedisService {
    /**
     * set操作
     *
     * @param key
     * @param value
     * @return
     */
    String set(String key, String value);

    /**
     * set操作
     *
     * @param key
     * @param seconds 过期时间
     * @param value
     * @return
     */
    String setex(String key, int seconds, String value);

    /**
     * get操作
     *
     * @param key
     * @return
     */
    String get(String key);

    /**
     * del操作
     *
     * @param key
     * @return
     */
    Long del(String... key);

    /**
     * lua脚本
     *
     * @param sha1
     * @param keyCount
     * @param params
     * @return
     */
    Object evalsha(String sha1, int keyCount, String... params);

}
