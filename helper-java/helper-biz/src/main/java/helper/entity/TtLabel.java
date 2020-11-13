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
 * 标签
 * </p>
 *
 * @author liuSongLin
 * @since 2020-07-15
 */
@Data
@TableName("tt_label")
public class TtLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 标签名称
     */
    @TableField(value = "label_name")
    private String labelName;

    /**
     * 业务类型(1. 消息提醒 2.任务性质 3.笔记标签)
     */
    @TableField(value = "business_type")
    private Integer businessType;

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
