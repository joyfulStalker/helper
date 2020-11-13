package helper.vo.payment;

import com.fasterxml.jackson.annotation.JsonFormat;
import common.common.base.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @description: 记账流水查询
 * @author: lsl
 * @create: 2020-08-19 10:12
 **/
@Data
@ApiModel("记账流水查询")
public class PayFlowQueryVo extends BaseQuery {

    public interface Check {
    }

    @ApiModelProperty(value = "流水号", example = "493228375813529600")
    private Long flowNo;

    @NotNull(groups = Check.class, message = "记账类型不能为空！")
    @Min(groups = Check.class, value = 1001, message = "记账类型不能为空！")
    @Max(groups = Check.class, value = 1002, message = "记账类型不能为空！")
    @ApiModelProperty(value = "记账类型 1001:收入 1002:支出", example = "1001")
    private Integer feeType;

    @ApiModelProperty(value = "付款方式(1001:支付宝  1002:微信 1003:现金 1004:其他)", example = "1002")
    private Integer paidType;

    @ApiModelProperty(value = "是否结清(1001:已结清  1002:未结清)", example = "1002")
    private Integer isSettled;

    @ApiModelProperty(value = "付款时间--开始", example = "2020-08-18 08:08:08")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startPayTime;

    @ApiModelProperty(value = "付款时间--结束", example = "2020-08-18 08:08:08")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endPayTime;

    @ApiModelProperty(value = "付款人姓名", example = "付款人")
    private String drawee;

    @ApiModelProperty(value = "收款人", example = "收款人")
    private String payee;
}
