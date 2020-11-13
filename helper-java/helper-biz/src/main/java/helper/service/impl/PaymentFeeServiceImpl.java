package helper.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import common.common.Constant;
import common.common.base.BizException;
import common.utils.AutoFillBaseDataUtil;
import common.utils.PageUtil;
import common.utils.SnowFlakeShortUrl;
import helper.entity.PaymentFee;
import helper.mapper.PaymentFeeMapper;
import helper.service.IPaymentFeeService;
import helper.vo.payment.FeeRecordVo;
import helper.vo.payment.PayFlowQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 费用流水  服务实现类
 * </p>
 *
 * @author liuSongLin
 * @since 2020-08-18
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class PaymentFeeServiceImpl extends ServiceImpl<PaymentFeeMapper, PaymentFee> implements IPaymentFeeService {

    @Override
    public void record(FeeRecordVo recordVo) {

        PaymentFee paymentFee = new PaymentFee();
        BeanUtil.copyProperties(recordVo, paymentFee);
        AutoFillBaseDataUtil.fillCreatedData(paymentFee);

        if (paymentFee.getActualPaid().compareTo(paymentFee.getTotalCost()) == -1) {
            paymentFee.setIsSettled(1001);
        } else if (paymentFee.getActualPaid().compareTo(paymentFee.getTotalCost()) == 1) {
            throw BizException.BIZ_ACTUAL_MONEY_GREATER_TOTAL_MONEY_EXCEPTION;
        } else {
            paymentFee.setIsSettled(1002);
        }

        //获取版本号
        if (paymentFee.getId() != null) {
            PaymentFee temp = baseMapper.selectById(paymentFee.getId());
            paymentFee.setVersion(temp.getVersion() + 1);
            paymentFee.setFlowNo(temp.getFlowNo());
            paymentFee.setId(null);
        } else {
            SnowFlakeShortUrl snowFlakeShortUrl = new SnowFlakeShortUrl(Constant.DATA_CENTER_ID_RECORD_PAYMENT, Constant.MACHINE_ID_PAYMENT);
            paymentFee.setFlowNo(snowFlakeShortUrl.nextId());
            log.info("默认值1");
            paymentFee.setVersion(+1);
        }
        try {
            int effectRows = baseMapper.insert(paymentFee);
            if (effectRows != 1) {
                throw BizException.BIZ_RECORD_FAIL_EXCEPTION;
            }
        } catch (Exception e) {
            throw BizException.BIZ_RECORD_FAIL_EXCEPTION;
        }


    }

    @Override
    public IPage<PaymentFee> flowList(PayFlowQueryVo queryVo) {
        Page page = PageUtil.getPage(queryVo);
        return baseMapper.flowList(page, queryVo);
    }

    @Override
    public List<PaymentFee> detail(Long flowNo) {
        LambdaQueryWrapper<PaymentFee> queryWrapper = new LambdaQueryWrapper<>();
        //匹配
        queryWrapper.eq(PaymentFee::getFlowNo, flowNo);
        //排序
        queryWrapper.orderByDesc(PaymentFee::getId);
        return baseMapper.selectList(queryWrapper);
    }
}
