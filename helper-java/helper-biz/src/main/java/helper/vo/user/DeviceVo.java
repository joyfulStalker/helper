package helper.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("设备信息")
public class DeviceVo {
    public interface Check {
    }

    @NotBlank(groups = Check.class, message = "设备参数不能为空！")
    @ApiModelProperty(name = "cid", example = "p1234", required = true)
    private String cid;
}
