package helper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import helper.entity.TtLabel;
import helper.mapper.TtLabelMapper;
import helper.service.ITtLabelService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签  服务实现类
 * </p>
 *
 * @author liuSongLin
 * @since 2020-07-15
 */
@Service
public class TtLabelServiceImpl extends ServiceImpl<TtLabelMapper, TtLabel> implements ITtLabelService {

}
