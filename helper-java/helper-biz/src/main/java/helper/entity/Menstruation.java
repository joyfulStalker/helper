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
 * 用户信息表
 * </p>
 *
 * @author liuSongLin
 * @since 2020-01-22
 */
@Data
@TableName("tt_menstruation")
public class Menstruation implements Serializable {

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
     * 开始日期
     */
    @TableField(value = "start_date")
    private Date startDate;
    /**
     * 结束日期
     */
    @TableField(value = "end_date")
    private Date endDate;
    /**
     * 是否疼痛(1:是0:否)
     */
    @TableField(value = "is_ache")
    private Integer isAche;
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
