package helper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import common.common.enums.RequestEnum;
import helper.entity.User;
import helper.vo.user.UserLoginVo;
import helper.vo.user.UserRegisterVo;
import helper.vo.user.UserVo;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liuSongLin
 * @since 2019-11-19
 */
public interface IUserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userRegisterVo
     */
    void register(UserRegisterVo userRegisterVo);


    /**
     * 根据手机号或邮箱查询一个用户
     *
     * @param requestEnum 请求类型
     * @param requester   手机号或邮箱号
     * @return
     */
    User getOneUserByMobileNumber(RequestEnum requestEnum, String requester);

    /**
     * 手机号或邮箱登录
     *
     * @param loginVo
     * @param request
     * @return
     */
    UserVo login(UserLoginVo loginVo, HttpServletRequest request);
}
