package common.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author liuSonglin
 */

@Getter
@AllArgsConstructor
public enum RequestEnum {

    /**
     * 手机号
     */
    MOBILE_PHONE("手机号", 0),
    /**
     * 邮箱
     */
    MAIL("邮箱", 1),
    ;

    private String desc;
    private Integer value;
}
