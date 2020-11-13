package common.common.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Desc 分页查询
 * @Author liuSongLin
 * @Date 2019/6/2 11:03
 * @Version 1.0v
 **/
@Data
@ApiModel("分页查询")
public class BaseQuery {

    @ApiModelProperty(value = "当前页", example = "1")
    private long current = 1L;

    @ApiModelProperty(value = "每页条数", example = "10")
    private long size = 10L;

    @ApiModelProperty(value = "按字段正序")
    private List<String> ascs;

    @ApiModelProperty(value = "按字段倒叙")
    private List<String> descs;
}
