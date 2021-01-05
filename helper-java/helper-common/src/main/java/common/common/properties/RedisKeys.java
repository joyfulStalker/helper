package common.common.properties;

import lombok.Data;

/**
 * 在getRedisKeys方法中统一上传脚本，RedisKeys定义脚本名称
 */
@Data
public class RedisKeys {
    /**
     * 分布式id的sha1 值
     */
    private String distributeIdShaKey;
}
