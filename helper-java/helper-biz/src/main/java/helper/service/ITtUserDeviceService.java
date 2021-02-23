package helper.service;


import com.baomidou.mybatisplus.extension.service.IService;
import helper.entity.TtUserDevice;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liuSongLin
 * @since 2021-02-17
 */
public interface ITtUserDeviceService extends IService<TtUserDevice> {

    /**
     * 根据用户查询
     *
     * @param userId
     * @return
     */
    TtUserDevice getOneByUserId(Integer userId);
}
