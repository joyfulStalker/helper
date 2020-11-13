package payment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import payment.entity.PaymentCarOwner;
import payment.mapper.PaymentCarOwnerMapper;
import payment.service.IPaymentCarOwnerService;

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
