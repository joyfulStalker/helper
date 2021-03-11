package co.imdo.perfect.config;

import co.imdo.perfect.callback.MyMqConfirmCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Slf4j
public class MyMqConfig {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MyMqConfirmCallback myMqConfirmCallback;

    @PostConstruct
    public void initRabbitMq() {
        rabbitTemplate.setConfirmCallback(myMqConfirmCallback);
    }
}
