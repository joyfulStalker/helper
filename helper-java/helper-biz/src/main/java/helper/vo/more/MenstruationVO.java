package helper.vo.more;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author liuSonglin
 */
@Data
@ApiModel("例假数据")
public class MenstruationVO {

    public interface Check {
    }

    @ApiModelProperty(name = "主键id", value = "1", example = "1")
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(groups = Check.class, message = "请选择开始日期")
    @ApiModelProperty(name = "开始日期", value = "2019-12-09 00:00:01", example = "2019-12-09 00:00:01", required = true)
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "结束日期", value = "2019-12-09 00:00:01", example = "2019-12-09 00:00:01")
    private Date endDate;


}
