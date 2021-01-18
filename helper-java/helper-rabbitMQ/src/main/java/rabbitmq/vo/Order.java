package rabbitmq.vo;

import lombok.Data;

@Data
public class Order {
    private Integer itemId;
    private Integer status;
}
