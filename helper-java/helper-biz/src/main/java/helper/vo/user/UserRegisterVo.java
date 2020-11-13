package helper.vo.user;

import common.common.sms.BaseSmsInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@ApiModel("用户注册")
public class UserRegisterVo extends BaseSmsInfoVo {

    @NotBlank(groups = BaseSmsInfoVo.Check.class, message = "请设置登录密码！")
    @ApiModelProperty(name = "密码", example = "p1234", required = true)
    private String loginPassword;

    @NotBlank(groups = Check.class, message = "请填写验证码！")
    @ApiModelProperty(name = "验证码", example = "012329", required = true)
    @Pattern(groups = Check.class, regexp = "^\\d{6}$", message = "请输入六位验证码！")
    private String verificationCode;
}
