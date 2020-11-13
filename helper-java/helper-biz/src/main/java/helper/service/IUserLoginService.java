package helper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import helper.entity.UserLogin;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liuSongLin
 * @since 2019-11-19
 */
public interface IUserLoginService extends IService<UserLogin> {

    /**
     * 用户登录记录
     *
     * @param request
     * @param userId
     */
    void recordLogin(HttpServletRequest request, Integer userId);
}
