package co.imdo.perfect.getui.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PushBusinessType {

    DEFAULT("default", "默认"),
    CHAT("chat", "聊天"),


    ;

    private String type;
    private String desc;
}
