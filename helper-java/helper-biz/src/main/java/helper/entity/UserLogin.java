package helper.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author liuSongLin
 * @since 2019-11-27
 */
@Data
@TableName("tt_user_login")
public class UserLogin implements Serializable {

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
     * 登录时间
     */
    @TableField(value = "login_date")
    private Date loginDate;
    /**
     * 登录IP
     */
    @TableField(value = "login_ip")
    private String loginIp;
    /**
     * 设备号
     */
    @TableField(value = "device_num")
    private String deviceNum;
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
    @TableLogic
    @TableField(value = "is_delete")
    private Integer isDelete;
}
