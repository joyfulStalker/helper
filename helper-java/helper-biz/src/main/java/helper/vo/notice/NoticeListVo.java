package helper.vo.notice;

import co.imdo.perfect.getui.enums.PushBusinessType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("通知列表")
public class NoticeListVo {
    @ApiModelProperty(value = "通知标题")
    private String title;
    @ApiModelProperty(value = "通知内容")
    private String content;
    @ApiModelProperty(value = "接收人")
    private Integer toUserId;
    @ApiModelProperty(value = "消息类型")
    private PushBusinessType pushBusinessType;
}
