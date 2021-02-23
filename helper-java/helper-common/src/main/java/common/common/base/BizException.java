package common.common.base;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Desc 业务异常
 * @Author liuSongLin
 * @Date 2019/6/9 21:14
 * @Version 1.0v
 **/
@Data
@AllArgsConstructor
public class BizException extends RuntimeException {

    private Integer code;
    private String msg;

    /**
     * 系统相关异常 1002开头
     */
    public static final BizException BIZ_SYSTEM_EXCEPTION = new BizException(10011001, "系统异常！");
    public static final BizException BIZ_TEST_EXCEPTION = new BizException(10011002, "测试异常！");


    /**
     * 信息相关异常 1002开头
     */
    public static final BizException BIZ_MSG_RESEND_EXCEPTION = new BizException(10021001, "验证码5分钟内有效，请不要重复获取！");
    public static final BizException BIZ_MSG_CODE_FALSE_EXCEPTION = new BizException(10021002, "验证码有误！");
    public static final BizException BIZ_MSG_NOT_YET_OPEN_EXCEPTION = new BizException(10021003, "相关功能暂未开通！");
    public static final BizException BIZ_MSG_CODE_OUT_TIME_EXCEPTION = new BizException(10021004, "验证码已过期！");


    /**
     * 用户相关异常 1003开头
     */
    public static final BizException BIZ_USER_RE_REGISTER_EXCEPTION = new BizException(10031001, "您已注册过了，请直接登录！");
    public static final BizException BIZ_USER_ERR_LOGIN_EXCEPTION = new BizException(10031002, "用户名或密码输入有误！");
    public static final BizException BIZ_USER_NOT_LOGIN_EXCEPTION = new BizException(10031003, "请登录！");

    /**
     * 例假相关异常 1004开头
     */
    public static final BizException BIZ_MENSTRUATION_DATE_ERR_EXCEPTION = new BizException(10041001, "结束日期需大于开始日期！");
    public static final BizException BIZ_MENSTRUATION_NOT_EXIST_EXCEPTION = new BizException(10041002, "要修改的数据不存在！");


    /**
     * 账务相关异常 1005开头
     */
    public static final BizException BIZ_ACTUAL_MONEY_GREATER_TOTAL_MONEY_EXCEPTION = new BizException(10051001, "总账不能小于实际金额！");
    public static final BizException BIZ_RECORD_FAIL_EXCEPTION = new BizException(10051002, "账务记录失败，请刷新重试！");

    /**
     * 通知相关异常 1006开头
     */
    public static final BizException BIZ_NOTICE_NO_SUCH_USER = new BizException(10061001, "消息目标不存在！");


}



