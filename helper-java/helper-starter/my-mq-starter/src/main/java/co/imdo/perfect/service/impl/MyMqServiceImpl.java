package co.imdo.perfect.service.impl;

import co.imdo.perfect.enums.MyMqBizEnum;
import co.imdo.perfect.po.MyMqMessage;
import co.imdo.perfect.service.MyMqService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class MyMqServiceImpl implements MyMqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(MyMqMessage myMqMessage) {
        log.info("接收到的参数==>{}", JSON.toJSONString(myMqMessage));
        //TODO 这里先做入库操作 防止发送成功 入库失败情况
        MyMqBizEnum myMqBizEnum = myMqMessage.getMyMqBizEnum();
        rabbitTemplate.convertAndSend(myMqBizEnum.getExchange(), myMqBizEnum.getRoutingKey(),
                JSON.toJSONString(myMqMessage.getData()), myMqMessage.getMessagePostProcessor(),
                myMqMessage.getCorrelationData());
    }
}
