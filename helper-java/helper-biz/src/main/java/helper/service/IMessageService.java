package helper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import common.common.enums.RequestEnum;
import common.common.enums.SmsEnum;
import helper.entity.Message;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liuSongLin
 * @since 2019-11-19
 */
public interface IMessageService extends IService<Message> {

    /**
     * 产生验证码，记录验证码，发送验证码到用户
     *
     * @param requestEnum 请求类型
     * @param requester   手机号或邮箱号
     * @param smsEnum     业务类型
     */
    void sendCode(@NotNull RequestEnum requestEnum, @NotBlank String requester, @NotNull SmsEnum smsEnum, HttpServletRequest request);

    /**
     * 校验验证码
     *
     * @param requestEnum 请求类型
     * @param requester   手机号或邮箱号
     * @param smsEnum     业务类型
     */
    void checkCode(@NotNull RequestEnum requestEnum, @NotBlank String requester, @NotNull SmsEnum smsEnum);


    /**
     * 删除验证码
     *
     * @param message
     */
    void deleteCode(Message message);
}
