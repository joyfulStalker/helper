package helper.strategy;

import common.common.enums.RequestEnum;

/**
 * 发送验证码策略接口
 *
 * @author liuSonglin
 */
public interface SendStrategy {

    /**
     * 发送验证码
     *
     * @param requester  接收者
     * @param randomCode 验证码
     */
    void send(String requester, String randomCode);

    /**
     * 获取发送类型
     *
     * @return
     */
    RequestEnum getSendType();
}
