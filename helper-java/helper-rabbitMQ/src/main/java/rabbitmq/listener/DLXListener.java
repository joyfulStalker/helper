package rabbitmq.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

import static co.imdo.perfect.enums.MyMqBizEnum.MY_TEST;

@Configuration
public class DLXListener {

    @RabbitListener(queues = "my.test.queue")
    public void dlxListener(Message message, Channel channel) throws IOException {
        System.out.println(new String(message.getBody()));
        System.out.println(System.currentTimeMillis());
        //对消息进行业务处理....
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
