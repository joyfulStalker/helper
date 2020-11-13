package common.common.properties;

import lombok.Data;

@Data
public class RedisKeys {
    /**
     * 分布式id的sha1 值
     */
    private String distributeIdShaKey;
}
