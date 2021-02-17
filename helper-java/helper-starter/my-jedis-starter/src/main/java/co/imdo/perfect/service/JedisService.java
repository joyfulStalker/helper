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
     * get操作
     *
     * @param key
     * @return
     */
    String get(String key);

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
