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
 * 时间提醒
 * </p>
 *
 * @author liuSongLin
 * @since 2019-12-13
 */
@Data
@TableName("tt_remind")
public class Remind implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 接收者手机号
     */
    @TableField(value = "mobile_number")
    private String mobileNumber;
    /**
     * 接收者邮箱
     */
    private String mail;
    /**
     * 提醒日期
     */
    @TableField(value = "remind_date")
    private Date remindDate;
    /**
     * 提醒主题
     */
    private String subject;
    /**
     * 提醒内容
     */
    private String content;
    /**
     * 是否匿名
     */
    @TableField(value = "is_anonymous")
    private Integer isAnonymous;
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
