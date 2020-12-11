package payment.web;

import common.common.HttpMethod;
import common.common.base.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import payment.entity.PaymentFee;
import payment.service.IPaymentFeeService;
import payment.vo.FeeRecordVo;
import payment.vo.PayFlowQueryVo;

/**
 * <p>
 * 费用流水  前端控制器
 * </p>
 *
 * @author liuSongLin
 * @since 2020-08-18
 */
@RestController
@ApiSort(value = 1)
@RequestMapping("/paymentFee")
@Api(value = "记账功能", tags = "记账功能")
public class PaymentFeeController {

    @Autowired
    private IPaymentFeeService paymentFeeService;

    @ResponseBody
    @PostMapping("/record")
    @ApiOperation(value = "1、账务流水记录",
            httpMethod = HttpMethod.POST,
            response = R.class,
            notes = "1、账务流水记录",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public R record(@Validated(FeeRecordVo.Check.class) @RequestBody FeeRecordVo recordVo) {
        paymentFeeService.record(recordVo);
        return R.of();
    }


    @ResponseBody
    @PostMapping("/list")
    @ApiOperation(value = "2、账务流水列表",
            httpMethod = HttpMethod.POST,
            response = PaymentFee.class,
            notes = "2、账务流水列表",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public R list(@Validated(PayFlowQueryVo.Check.class) @RequestBody PayFlowQueryVo queryVo) {
        return R.of(paymentFeeService.flowList(queryVo));
    }

    @ResponseBody
    @PostMapping("/detail")
    @ApiOperation(value = "3、账务流水详细",
            httpMethod = HttpMethod.POST,
            response = PaymentFee.class,
            notes = "3、账务流水详细",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public R detail(@RequestParam(value = "flowNo") @ApiParam(name = "flowNo", example = "493228364094644224") Long flowNo) {
        return R.of(paymentFeeService.detail(flowNo));
    }
}
