package co.imdo.perfect.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MyMqBizEnum {

    /**
     * 我的测试 定义交换机、队列、路由、以及业务码
     */
    MY_TEST(1001, "my.test.exchange", "my.test.queue", "my.test.routingKey", "测试");

    /**
     * 业务码
     */
    private Integer bizCode;
    /**
     * 交换机
     */
    private String exchange;
    /**
     * 队列
     */
    private String queue;
    /**
     * 路由键
     */
    private String routingKey;
    /**
     * 描述
     */
    private String desc;
}
