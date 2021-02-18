package common.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 时间常量设置
 *
 * @author liu
 */
@Getter
@AllArgsConstructor
public enum TimeEnum {

    /**
     * token过期时间设置
     */
    TOKEN_EXPIRE(24 * 60 * 60, "token过期时间，单位:秒");


    /**
     * 时长定义
     */
    private int time;

    private String desc;
}
