package co.imdo.perfect.properties;

import lombok.Data;

/**
 * 在getRedisKeys方法中统一上传脚本，RedisKeys定义脚本名称(脚本名字与属性名字保持一致)
 */
@Data
public class RedisShaKeys {
    /**
     * 分布式id的sha1 值
     */
    private String distributedId;
}