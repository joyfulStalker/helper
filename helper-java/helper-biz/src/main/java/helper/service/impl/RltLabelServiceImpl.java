package helper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import common.common.enums.LabelEnum;
import helper.entity.RltLabel;
import helper.mapper.RltNoteLabelMapper;
import helper.service.IRltLabelService;
import helper.vo.note.LabelVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liuSongLin
 * @since 2020-07-15
 */
@Service
public class RltLabelServiceImpl extends ServiceImpl<RltNoteLabelMapper, RltLabel> implements IRltLabelService {

    @Override
    public List<LabelVo> getLabelList(Integer businessId, LabelEnum labelEnum) {
        return baseMapper.getLabelList(businessId, labelEnum);
    }
}
