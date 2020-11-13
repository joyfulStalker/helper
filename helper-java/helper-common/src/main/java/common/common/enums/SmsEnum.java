package common.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author liuSongLin
 */

@Getter
@AllArgsConstructor
public enum SmsEnum {

    /**
     * 用户注册
     */
    USER_REGISTER("用户注册", 1),
    /**
     * 销户
     */
    WRITE_OFF("销户", 2),
    /**
     * 用户登录
     */
    USER_LOGIN("用户登录", 3),
    /**
     * 密码找回
     */
    PASSWORD_BACK("密码找回", 4),
    /**
     * 解绑手机号
     */
    UNBOUND_MOBILE("解绑手机号", 5),
    /**
     * 更换手机号
     */
    CHANGE_MOBILE("更换手机号", 6),
    ;

    private String desc;
    private Integer businessType;
}
