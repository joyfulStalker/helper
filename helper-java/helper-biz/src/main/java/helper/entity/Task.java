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
 * 定时任务
 * </p>
 *
 * @author liuSongLin
 * @since 2020-01-22
 */
@Data
@TableName("tt_task")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 任务名
     */
    @TableField(value = "job_name")
    private String jobName;
    /**
     * 任务描述
     */
    private String description;
    /**
     * cron表达式
     */
    @TableField(value = "cron_expression")
    private String cronExpression;
    /**
     * 任务执行时调用哪个类的方法 包名+类名
     */
    @TableField(value = "bean_class")
    private String beanClass;
    /**
     * 任务状态
     */
    @TableField(value = "job_status")
    private String jobStatus;
    /**
     * 任务分组
     */
    @TableField(value = "job_group")
    private String jobGroup;
    /**
     * 被调用的url
     */
    @TableField(value = "invoked_url")
    private String invokedUrl;
    /**
     * 1:是 0:否
     */
    @TableField(value = "is_delete")
    private Boolean isDelete;
    /**
     *
     */
    @TableField(value = "create_by")
    private String createBy;
    /**
     *
     */
    @TableField(value = "create_time")
    private Date createTime;
    /**
     *
     */
    @TableField(value = "update_by")
    private String updateBy;
    /**
     *
     */
    @TableField(value = "update_time")
    private Date updateTime;
}
