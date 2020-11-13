package helper.vo.note;

import common.common.base.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("笔记列表查询条件")
public class NoteQueryVo extends BaseQuery {
    public interface Check {

    }

    /**
     * 笔记分类(java-base,java-spring,java-mybatis,mom-rmq,mom-kfk,mom-red,datebase-mysql,date-orac)
     */
//    @NotBlank(groups = Check.class, message = "请选择分类！")
    @ApiModelProperty(name = "笔记分类", example = "java-base", required = true)
    private String noteCategory;
}
