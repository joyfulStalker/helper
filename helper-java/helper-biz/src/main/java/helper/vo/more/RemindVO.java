package helper.vo.more;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 时间提醒
 * </p>
 *
 * @author liuSongLin
 * @since 2019-12-13
 */
@Data
@ApiModel("提醒")
public class RemindVO implements Serializable {


    public interface Check {
    }

    /**
     * 接收者手机号
     */
    @ApiModelProperty(name = "手机号", value = "mobileNumber", example = "15201888888")
    private String mobileNumber;
    /**
     * 接收者邮箱
     */
    @ApiModelProperty(name = "手机号", value = "mobileNumber", example = "15201888888")
    private String mail;
    /**
     * 提醒日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(groups = Check.class, message = "请选择提醒日期")
    @ApiModelProperty(name = "提醒日期", value = "remindDate", example = "2019-12-09 00:00:00", required = true)
    private Date remindDate;

    /**
     * 提醒主题
     */
    @ApiModelProperty(name = "提醒主题", value = "subject", example = "生日提醒")
    private String subject;
    /**
     * 提醒内容
     */
    @NotBlank(groups = Check.class, message = "请填写提醒内容")
    @ApiModelProperty(name = "提醒内容", value = "content", example = "提醒内容")
    private String content;
    /**
     * 是否匿名
     */
    @NotNull(groups = Check.class, message = "请选择是否匿名")
    @Min(value = 0, groups = Check.class, message = "isAnonymous参数有误")
    @Max(value = 1, groups = Check.class, message = "isAnonymous参数有误")
    @ApiModelProperty(name = "是否匿名", value = "isAnonymous", example = "1")
    private Integer isAnonymous;

}
