package helper.vo.user;

import common.common.sms.BaseSmsInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("用户登录")
public class UserLoginVo extends BaseSmsInfoVo {

    @NotBlank(groups = BaseSmsInfoVo.Check.class, message = "请设置登录密码！")
    @ApiModelProperty(name = "密码", example = "p1234", required = true)
    private String loginPassword;

}
