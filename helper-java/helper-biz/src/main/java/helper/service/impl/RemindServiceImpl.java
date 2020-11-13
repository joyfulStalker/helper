package helper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import helper.entity.Remind;
import helper.mapper.RemindMapper;
import helper.service.IRemindService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 时间提醒  服务实现类
 * </p>
 *
 * @author liuSongLin
 * @since 2019-12-13
 */
@Service
public class RemindServiceImpl extends ServiceImpl<RemindMapper, Remind> implements IRemindService {
	
}
