package co.imdo.perfect.callback;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;


@Slf4j
public class MyMqConfirmCallback implements RabbitTemplate.ConfirmCallback {

    /**
     * Confirmation callback.
     *
     * @param correlationData - correlation data for the callback.
     * @param ack             – true for ack, false for nack
     * @param cause           – An optional cause, for nack, when available, otherwise null.
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("========这里接收消息确认信息==========");
        log.info(JSON.toJSONString(correlationData));
        log.info(JSON.toJSONString(ack));
        log.info(JSON.toJSONString(cause));
        log.info(new String(correlationData.getReturnedMessage().getBody()));
        log.info("========这里接收消息确认信息==========");
    }
}
