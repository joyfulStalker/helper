package helper.vo.note;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 笔记vo
 * </p>
 *
 * @author liuSongLin
 * @since 2020-07-15
 */
@Data
@ApiModel("新增、修改笔记实体")
public class NoteVo {

    public interface CheckInsert {

    }

    public interface CheckUpdate {

    }

    @NotNull(groups = CheckUpdate.class, message = "请选择要修改的笔记！")
    @ApiModelProperty(name = "唯一ID", example = "1", required = true)
    private Integer id;

    @NotNull(groups = {CheckInsert.class, CheckUpdate.class}, message = "请登录！")
    @ApiModelProperty(name = "用户ID", example = "1", required = true)
    private Integer ttUserId;

    /**
     * 笔记名称
     */
    @NotBlank(groups = {CheckInsert.class, CheckUpdate.class}, message = "请填写笔记名称！")
    @ApiModelProperty(name = "用户ID", example = "1", required = true)
    private String noteTitle;

    /**
     * 笔记分类(java-base,java-spring,java-mybatis,mom-rmq,mom-kfk,mom-red,datebase-mysql,date-orac)
     */
    @NotBlank(groups = {CheckInsert.class, CheckUpdate.class}, message = "请选择分类！")
    @ApiModelProperty(name = "笔记分类", example = "java-base", required = true)
    private String noteCategory;

    /**
     * 笔记内容
     */
    @NotBlank(groups = {CheckInsert.class, CheckUpdate.class}, message = "请填写笔记内容！")
    @ApiModelProperty(name = "笔记内容", example = "笔记内容", required = true)
    private String noteContent;

    /**
     * 标签
     */
    @ApiModelProperty(name = "标签", example = "java后端", required = true)
    List<LabelVo> labelList = Lists.newArrayList();

}
