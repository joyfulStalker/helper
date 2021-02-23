package helper.vo.notice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("发送消息")
public class SendNoticeVo {
    public interface Check {
    }

    @ApiModelProperty(value = "通知标题", required = true)
    @NotBlank(groups = Check.class, message = "请填通知标题")
    private String title;
    @ApiModelProperty(value = "通知内容", required = true)
    @NotBlank(groups = Check.class, message = "请输入消息")
    private String content;
    @ApiModelProperty(value = "接收人", required = true)
    @NotNull(groups = Check.class, message = "接收人")
    private Integer toUserId;
}
