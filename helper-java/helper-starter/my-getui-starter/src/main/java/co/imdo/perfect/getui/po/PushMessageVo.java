package co.imdo.perfect.getui.po;

import co.imdo.perfect.getui.enums.PushBusinessType;
import lombok.Data;

@Data
public class PushMessageVo {
    private String cid;
    private String title;
    private String message;
    private PushBusinessType type = PushBusinessType.DEFAULT;
}
