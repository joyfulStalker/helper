package helper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 费用流水
 * </p>
 *
 * @author liuSongLin
 * @since 2020-08-18
 */
@Data
@TableName("payment_fee")
public class PaymentFee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 流水号
     */
    @TableField(value = "flow_no")
    private Long flowNo;
    /**
     * 记账类型 1001:收入 1002:支出
     */
    @TableField(value = "fee_type")
    private Integer feeType;
    /**
     * 付款方式(1001:支付宝  1002:微信 1003:现金 1004:其他)
     */
    @TableField(value = "paid_type")
    private Integer paidType;
    /**
     * 总需支付获取收取费用
     */
    @TableField(value = "total_cost")
    private BigDecimal totalCost;
    /**
     * 实际收取或支付金额
     */
    @TableField(value = "actual_paid")
    private BigDecimal actualPaid;
    /**
     * 是否结清(1001:结清 1002:未结清)
     */
    @TableField(value = "is_settled")
    private Integer isSettled;
    /**
     * 付款时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "pay_time")
    private Date payTime;
    /**
     * 备注
     */
    private String remark;
    /**
     * 付款人（包含公司）id
     */
    @TableField(value = "drawee_id")
    private Integer draweeId;
    /**
     * 付款人姓名/公司名称
     */
    private String drawee;
    /**
     * 收款人id/收款公司
     */
    @TableField(value = "payee_id")
    private Integer payeeId;
    /**
     * 收款人/收款公司
     */
    private String payee;
    /**
     * 版本号(从1开始，步长为1，最大的为准)
     */
    private Integer version;
    /**
     * 创建人id
     */
    @TableField(value = "created_by")
    private Long createdBy;
    /**
     * 创建时间
     */
    @TableField(value = "created_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdDate;
    /**
     * 更新人id
     */
    @TableField(value = "updated_by")
    private Long updatedBy;
    /**
     * 更新时间
     */
    @TableField(value = "updated_date")
    private Date updatedDate;
}
