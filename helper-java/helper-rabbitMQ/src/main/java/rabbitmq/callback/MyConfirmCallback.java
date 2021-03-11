//package rabbitmq.callback;
//
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.connection.CorrelationData;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//
//
//@Slf4j
//public class MyConfirmCallback implements RabbitTemplate.ConfirmCallback {
//    @Override
//    public void confirm(CorrelationData correlationData, boolean b, String s) {
//        log.info("==================");
//        log.info(JSON.toJSONString(correlationData));
//        log.info(JSON.toJSONString(b));
//        log.info(JSON.toJSONString(s));
//        log.info(new String(correlationData.getReturnedMessage().getBody()));
//        log.info("==================");
//    }
//
//
//}
