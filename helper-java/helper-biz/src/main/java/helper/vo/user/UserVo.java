package helper.vo.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户信息")
public class UserVo {

    @JsonIgnore
    @ApiModelProperty("用户唯一id")
    private Integer id;

    @ApiModelProperty("用户姓名")
    private String userName;

    @ApiModelProperty("用户昵称")
    private String userNick;

    @ApiModelProperty("1:男 2:女 3:未知")
    private Integer userSex;

    @ApiModelProperty("住址")
    private String address;

    @ApiModelProperty("手机号")
    private String mobileNumber;

    @ApiModelProperty("qq")
    private String qq;

    @ApiModelProperty("邮箱")
    private String mail;

    @ApiModelProperty("生日")
    private String userBirthday;

    @ApiModelProperty("用户类型1:注册用户 2:访客用户 3:后台开通")
    private Integer userType;

    @ApiModelProperty("用户唯一标识")
    private String token;

}
