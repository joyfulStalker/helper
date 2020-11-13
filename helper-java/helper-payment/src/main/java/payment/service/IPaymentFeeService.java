package payment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import payment.entity.PaymentFee;
import payment.vo.FeeRecordVo;
import payment.vo.PayFlowQueryVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liuSongLin
 * @since 2020-08-18
 */
public interface IPaymentFeeService extends IService<PaymentFee> {

    /**
     * 账务流水记录
     *
     * @param recordVo
     */
    void record(FeeRecordVo recordVo);

    /**
     * 账务流水列表
     *
     * @param queryVo
     * @return
     */
    IPage<PaymentFee> flowList(PayFlowQueryVo queryVo);

    /**
     * 账务流水明细
     *
     * @param flowNo
     * @return
     */
    List<PaymentFee> detail(Long flowNo);
}
