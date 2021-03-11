package co.imdo.perfect.service;

import co.imdo.perfect.po.MyMqMessage;

public interface MyMqService {
    /**
     * 发送消息到MQ
     *
     * @param myMqMessage
     */
    void send(MyMqMessage myMqMessage);
}
