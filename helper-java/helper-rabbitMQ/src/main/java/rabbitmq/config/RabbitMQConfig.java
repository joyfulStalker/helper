package rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 参考文档 https://www.cnblogs.com/hsz-csy/p/11332418.html
 */
@Configuration
public class RabbitMQConfig {

    @Value("${sunspring.order.exchange:order_exchange}")
    private String orderExchange;

    @Value("${sunspring.order.queue:order_queue}")
    private String orderQueue;

    @Value("${sunspring.order.routingKey:order_routingKey}")
    private String orderRoutingKey;

//    @Value("${sunspring.dlx.exchange:dlx_exchange}")
//    private String dlxExchange;
//
//    @Value("${sunspring.dlx.queue:dlx_queue}")
//    private String dlxQueue;
//
//    @Value("${sunspring.dlx.routingKey:dlx}")
//    private String dlxRoutingKey;

    /**
     * 声明死信队列
     * @return DirectExchange
     */
//    @Bean
//    public DirectExchange dlxExchange() {
//        return new DirectExchange(dlxExchange);
//    }
//
//    /**
//     * 声明死信队列
//     * @return Queue
//     */
//    @Bean
//    public Queue dlxQueue() {
//        return new Queue(dlxQueue);
//    }
//
//    /**
//     * 绑定死信队列到死信交换机
//     * @return Binding
//     */
//    @Bean
//    public Binding binding() {
//        return BindingBuilder.bind(dlxQueue())
//                .to(dlxExchange())
//                .with(dlxRoutingKey);
//    }

    /**
     * 声明订单业务交换机
     *
     * @return DirectExchange
     */
    @Bean
    public CustomExchange orderExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(orderExchange, "x-delayed-message", true, false, args);
    }

    /**
     * 声明订单业务队列
     *
     * @return Queue
     */
    @Bean
    public Queue orderQueue() {
        Map<String, Object> arguments = new HashMap<>(2);
        // 绑定该队列到私信交换机
//        arguments.put("x-dead-letter-exchange",dlxExchange);
//        arguments.put("x-dead-letter-routing-key",dlxRoutingKey);
        return new Queue(orderQueue, true);
    }

    /**
     * 绑定订单队列到订单交换机
     *
     * @return Binding
     */
    @Bean
    public Binding orderBinding() {
        return BindingBuilder.bind(orderQueue())
                .to(orderExchange())
                .with(orderRoutingKey).noargs();
    }
}
