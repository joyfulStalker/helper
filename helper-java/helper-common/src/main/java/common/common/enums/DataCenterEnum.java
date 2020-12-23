package common.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataCenterEnum {

    /**
     * 短信
     */
    SMS_PUSH(1L),
    /**
     * 账务应用payment,账务流水
     */
    RECORD_PAYMENT(2L);


    private Long value;
}
