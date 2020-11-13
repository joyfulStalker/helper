package helper.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 短信发送
 * </p>
 *
 * @author liuSongLin
 * @since 2019-11-27
 */
@Data
@TableName("tt_message")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 请求者
     */
    private String requester;
    /**
     * 请求类型
     */
    @TableField(value = "request_type")
    private Integer requestType;
    /**
     * 6位验证码
     */
    @TableField(value = "verification_code")
    private String verificationCode;
    /**
     * 业务类型
     */
    @TableField(value = "business_type")
    private Integer businessType;
    /**
     * 发送时间
     */
    @TableField(value = "send_time")
    private Date sendTime;
    /**
     * 有效时长
     */
    @TableField(value = "effective_duration")
    private Integer effectiveDuration;
    /**
     * 请求者ip
     */
    @TableField(value = "send_ip")
    private String sendIp;
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
