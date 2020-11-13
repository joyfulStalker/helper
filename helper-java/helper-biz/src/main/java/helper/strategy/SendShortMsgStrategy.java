package helper.strategy;

import common.common.enums.RequestEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * 发送短信验证码策略
 *
 * @author liuSonglin
 */
@Slf4j
public class SendShortMsgStrategy implements SendStrategy {

    @Override
    public void send(String requester, String randomCode) {
        log.info("发送到手机：" + requester + "的验证码是" + randomCode + "！");
    }

    @Override
    public RequestEnum getSendType() {
        return RequestEnum.MOBILE_PHONE;
    }
}
