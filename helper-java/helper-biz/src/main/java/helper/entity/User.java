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
@TableName("tt_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 姓名
     */
    @TableField(value = "user_name")
    private String userName;
    /**
     * 昵称
     */
    @TableField(value = "user_nick")
    private String userNick;
    /**
     * 1:男 2:女 3:未知
     */
    @TableField(value = "user_sex")
    private Integer userSex;
    /**
     * 住址
     */
    private String address;
    /**
     * 身份证
     */
    @TableField(value = "id_card")
    private String idCard;
    /**
     * 手机号
     */
    @TableField(value = "mobile_number")
    private String mobileNumber;
    /**
     * qq
     */
    private String qq;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 登录密码
     */
    @TableField(value = "login_password")
    private String loginPassword;
    /**
     * 生日
     */
    @TableField(value = "user_birthday")
    private String userBirthday;
    /**
     * 用户类型1:注册用户 2:访客用户 3:后台开通
     */
    @TableField(value = "user_type")
    private Integer userType;
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
