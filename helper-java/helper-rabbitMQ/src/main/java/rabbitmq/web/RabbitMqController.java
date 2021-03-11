package rabbitmq.web;

import co.imdo.perfect.enums.MyMqBizEnum;
import co.imdo.perfect.po.MyMqMessage;
import co.imdo.perfect.service.MyMqService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private MyMqService myMqService;

    @Value("${sunspring.order.exchange:order_exchange}")
    private String orderExchange;

    @Value("${sunspring.order.routingKey:order_routingKey}")
    private String orderRoutingKey;

    @GetMapping("/sendDlx")
    public void sendDlx(@RequestParam Integer time) {
        Order order = new Order();
        order.setItemId(time);
        order.setStatus(1);
//        rabbitTemplate.setConfirmCallback(new MyConfirmCallback());
////        rabbitTemplate.setReturnsCallback(new MyReturnsCallback());
////        rabbitTemplate.setRecoveryCallback();
//        CorrelationData cd1 = new CorrelationData();
//        rabbitTemplate.convertAndSend(orderExchange, orderRoutingKey,
//                JSON.toJSONString(order), message -> {
//                    message.getMessageProperties().setHeader("x-delay", (time * 1000));
//                    return message;
//                }, cd1
//        );

//        MyMqMessage message = new MyMqMessage<Order>();
//        message.setMyMqBizEnum(MyMqBizEnum.MY_TEST);
//        message.setData(order);
//        message.setMessagePostProcessor(m -> {
//            m.getMessageProperties().setHeader("x-delay", (time * 1000));
//            return m;
//        });

        MyMqMessage<Object> message = MyMqMessage.builder().data(order).messagePostProcessor(m -> {
            m.getMessageProperties().setHeader("x-delay", (time * 1000));
            return m;
        }).myMqBizEnum(MyMqBizEnum.MY_TEST).build();

        myMqService.send(message);

    }
}
