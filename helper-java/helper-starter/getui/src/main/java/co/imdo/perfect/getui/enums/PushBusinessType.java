package co.imdo.perfect.getui.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PushBusinessType {

    DEFAULT("default", "默认");

    private String type;
    private String desc;
}
