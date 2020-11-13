package helper.vo.payment;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: 费用流水记录vo
 * @author: lsl
 * @create: 2020-08-18 16:58
 **/
@Data
@ApiModel("费用流水记录")
public class FeeRecordVo {

    public interface Check {
    }

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 记账类型 1001:收入 1002:支出
     */
    @ApiModelProperty(value = "记账类型", example = "1001", required = true)
    @NotNull(groups = Check.class, message = "记账类型不能为空！")
    @Min(value = 1001, groups = Check.class, message = "记账类型有误！")
    @Max(value = 1002, groups = Check.class, message = "记账类型有误！")
    private Integer feeType;
    /**
     * 付款方式(1001:支付宝  1002:微信 1003:现金 1004:其他)
     */
    @ApiModelProperty(value = "付款方式", example = "1002", required = true)
    @NotNull(groups = Check.class, message = "付款方式不能为空！")
    @Min(value = 1001, groups = Check.class, message = "付款方式有误！")
    @Max(value = 1004, groups = Check.class, message = "付款方式有误！")
    private Integer paidType;
    /**
     * 总需支付或收取费用
     */
    @ApiModelProperty(value = "总金额", example = "100", required = true)
    @NotNull(groups = Check.class, message = "总金额不能为空！")
    private BigDecimal totalCost;
    /**
     * 实际收取或支付金额
     */
    @ApiModelProperty(value = "实际金额", example = "100", required = true)
    @NotNull(groups = Check.class, message = "实际金额不能为空！")
    private BigDecimal actualPaid;

    /**
     * 付款时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "付款时间", example = "2020-08-18 08:08:08", required = true)
    @NotNull(groups = Check.class, message = "付款时间不能为空！")
    private Date payTime;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", example = "这是备注")
    private String remark;

    /**
     * 付款人姓名/公司名称
     */
    @ApiModelProperty(value = "付款人姓名", example = "付款人", required = true)
    @NotNull(groups = Check.class, message = "付款人姓名不能为空！")
    private String drawee;

    /**
     * 收款人/收款公司
     */
    @ApiModelProperty(value = "收款人", example = "收款人", required = true)
    @NotNull(groups = Check.class, message = "收款人姓名不能为空！")
    private String payee;


}
