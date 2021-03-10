package rabbitmq.web;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rabbitmq.callback.MyConfirmCallback;
import rabbitmq.callback.MyReturnsCallback;
import rabbitmq.vo.Order;

/**
 * rabbitMQ测试
 */
@RestController
@RequestMapping("/carOwner")
public class RabbitMqController {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${sunspring.order.exchange:order_exchange}")
    private String orderExchange;

    @Value("${sunspring.order.routingKey:order_routingKey}")
    private String orderRoutingKey;

    @GetMapping("/sendDlx")
    public void sendDlx(@RequestParam Integer time) {
        Order order = new Order();
        order.setItemId(time);
        order.setStatus(1);
        rabbitTemplate.setConfirmCallback(new MyConfirmCallback());
//        rabbitTemplate.setReturnsCallback(new MyReturnsCallback());
//        rabbitTemplate.setRecoveryCallback();
        CorrelationData cd1 = new CorrelationData();
        rabbitTemplate.convertAndSend(orderExchange, orderRoutingKey,
                JSON.toJSONString(order), message -> {
                    message.getMessageProperties().setHeader("x-delay", (time * 1000));
                    return message;
                }, cd1
        );

    }
}
