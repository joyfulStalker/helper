package helper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author liuSongLin
 * @since 2020-07-15
 */
@Data
@TableName("rlt_label")
public class RltLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 笔记主键id
     */
    @TableField(value = "tt_note_id")
    private Integer ttNoteId;

    /**
     * 业务id
     */
    @TableField(value = "business_id")
    private Integer businessId;

    /**
     * 业务表名
     */
    @TableField(value = "business_table")
    private Integer businessTable;


    /**
     * 创建人id
     */
    @TableField(value = "create_by")
    private Integer createBy;

    /**
     * 创建者姓名
     */
    @TableField(value = "create_by_name")
    private String createByName;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新人id
     */
    @TableField(value = "update_by")
    private Integer updateBy;

    /**
     * 更新者姓名
     */
    @TableField(value = "update_by_name")
    private String updateByName;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 0:有效 1:删除
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

}
