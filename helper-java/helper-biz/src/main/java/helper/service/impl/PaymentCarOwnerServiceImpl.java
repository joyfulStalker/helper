package helper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import helper.entity.PaymentCarOwner;
import helper.mapper.PaymentCarOwnerMapper;
import helper.service.IPaymentCarOwnerService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车主信息表  服务实现类
 * </p>
 *
 * @author liuSongLin
 * @since 2020-08-18
 */
@Service
public class PaymentCarOwnerServiceImpl extends ServiceImpl<PaymentCarOwnerMapper, PaymentCarOwner> implements IPaymentCarOwnerService {

}
