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
@TableName("tt_note")
public class TtNote implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    @TableField(value = "tt_user_id")
    private Integer ttUserId;

    /**
     * 笔记名称
     */
    @TableField(value = "note_title")
    private String noteTitle;

    /**
     * 笔记分类(java-base,java-spring,java-mybatis,mom-rmq,mom-kfk,mom-red,datebase-mysql,date-orac)
     */
    @TableField(value = "note_category")
    private String noteCategory;

    /**
     * 笔记内容
     */
    @TableField(value = "note_content")
    private String noteContent;

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
