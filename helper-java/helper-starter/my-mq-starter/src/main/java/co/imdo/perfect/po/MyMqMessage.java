package co.imdo.perfect.po;

import co.imdo.perfect.enums.MyMqBizEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyMqMessage<T> {
    /**
     * 业务相关定义
     */
    private MyMqBizEnum myMqBizEnum;
    /**
     * 一些参数设置
     */
    private MessagePostProcessor messagePostProcessor;
    /**
     * 不传则使用默认的
     */
    @Builder.Default
    private CorrelationData correlationData = new CorrelationData();
    /**
     * 要发送的数据
     */
    private T data;
}
