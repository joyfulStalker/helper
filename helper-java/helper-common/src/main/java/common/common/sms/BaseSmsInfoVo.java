package common.common.sms;

import common.common.enums.RequestEnum;
import common.common.enums.SmsEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 短信属性
 *
 * @author liuSonglin
 */
@Data
@ApiModel("短信请求")
public class BaseSmsInfoVo {

    public interface Check {
    }

    @NotNull(groups = Check.class, message = "请求型不能为空！")
    @ApiModelProperty(name = "请求类型", example = "MOBILE_PHONE", required = true)
    private RequestEnum requestEnum;

    @NotBlank(groups = Check.class, message = "手机号或邮箱不能为空！")
    @Pattern(groups = Check.class, regexp = "(([1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$)|(^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$))", message = "请填写正确的手机号或邮箱号！")
    @ApiModelProperty(name = "手机号或邮箱", example = "15205205200／2030333@qq.com", required = true)
    private String requester;

    @NotNull(groups = Check.class, message = "业务类型不能为空！")
    @ApiModelProperty(name = "业务类型", example = "USER_REGISTER", required = true)
    private SmsEnum smsEnum;
}
