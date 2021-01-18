package rabbitmq.web;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public void sendDlx() {
        Order order = new Order();
        order.setItemId(1);
        order.setStatus(1);
        rabbitTemplate.convertAndSend(orderExchange, orderRoutingKey,
                JSON.toJSONString(order), message -> {
                    message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                    message.getMessageProperties().setExpiration("10000");
                    return message;
                });
    }
}
