package helper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import common.utils.AutoFillBaseDataUtil;
import common.utils.ClientIpUtils;
import helper.entity.UserLogin;
import helper.mapper.UserLoginMapper;
import helper.service.IUserLoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 * 用户登录信息记录  服务实现类
 * </p>
 *
 * @author liuSongLin
 * @since 2019-11-19
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper, UserLogin> implements IUserLoginService {

    @Override
    public void recordLogin(HttpServletRequest request, Integer userId) {
        UserLogin userLogin = new UserLogin();
        AutoFillBaseDataUtil.fillCreatedData(userLogin);
        userLogin.setLoginIp(ClientIpUtils.getClientIp(request));
        userLogin.setLoginDate(new Date());
        userLogin.setUserId(userId);
        this.save(userLogin);
    }
}
