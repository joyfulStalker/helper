package helper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import helper.entity.TtUserDevice;
import helper.mapper.TtUserDeviceMapper;
import helper.service.ITtUserDeviceService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户设备表  服务实现类
 * </p>
 *
 * @author liuSongLin
 * @since 2021-02-17
 */
@Service
public class TtUserDeviceServiceImpl extends ServiceImpl<TtUserDeviceMapper, TtUserDevice> implements ITtUserDeviceService {

}
