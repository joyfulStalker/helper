package payment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import payment.entity.PaymentFee;
import payment.vo.PayFlowQueryVo;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author liuSongLin
 * @since 2020-08-18
 */
public interface PaymentFeeMapper extends BaseMapper<PaymentFee> {

    /**
     * 账务流水列表
     *
     * @param page
     * @param queryVo
     * @return
     */
    IPage<PaymentFee> flowList(Page page, @Param("queryVo") PayFlowQueryVo queryVo);
}