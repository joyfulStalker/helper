package helper.vo.more;

import com.fasterxml.jackson.annotation.JsonFormat;
import common.common.base.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author liuSonglin
 */
@Data
@ApiModel("例假查询条件")
public class MenstruationQueryVO extends BaseQuery {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "开始日期", value = "2019-12-09 00:00:01", example = "2019-12-09 00:00:01")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "结束日期", value = "2019-12-09 00:00:01", example = "2019-12-09 00:00:01")
    private Date endDate;
}
