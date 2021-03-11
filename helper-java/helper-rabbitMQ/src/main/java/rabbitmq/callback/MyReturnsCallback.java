//package rabbitmq.callback;
//
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.ReturnedMessage;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//
//@Slf4j
//public class MyReturnsCallback implements RabbitTemplate.ReturnsCallback {
//    @Override
//    public void returnedMessage(ReturnedMessage returnedMessage) {
//        log.info("======return============");
//        log.info(JSON.toJSONString(returnedMessage));
//        log.info(new String(returnedMessage.getMessage().getBody()));
//        log.info("========return==========");
//    }
//}
