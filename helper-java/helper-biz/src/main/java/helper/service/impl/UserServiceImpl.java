package helper.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import common.common.base.BizException;
import common.common.enums.RequestEnum;
import common.utils.AutoFillBaseDataUtil;
import common.utils.PasswordUtil;
import helper.entity.TtUserDevice;
import helper.entity.User;
import helper.mapper.UserMapper;
import helper.service.*;
import helper.vo.user.DeviceVo;
import helper.vo.user.UserLoginVo;
import helper.vo.user.UserRegisterVo;
import helper.vo.user.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户信息表  服务实现类
 * </p>
 *
 * @author liuSongLin
 * @since 2019-11-19
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    /**
     * 验证码service
     */
    @Autowired
    private IMessageService messageService;

    @Autowired
    private IUserLoginService loginService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private ITtUserDeviceService deviceService;


    @Override
    public void register(UserRegisterVo userRegisterVo) {
        //校验验证码
        messageService.checkCode(userRegisterVo.getRequestEnum(), userRegisterVo.getRequester(), userRegisterVo.getSmsEnum());

        //校验用户是否存在
        User user = getOneUserByMobileNumber(userRegisterVo.getRequestEnum(), userRegisterVo.getRequester());
        if (user != null) {
            throw BizException.BIZ_USER_RE_REGISTER_EXCEPTION;
        }
        //用户不存在保存 验证通过保存
        user = new User();
        BeanUtil.copyProperties(userRegisterVo, user);
        AutoFillBaseDataUtil.fillCreatedData(user);

        if (userRegisterVo.getRequestEnum().equals(RequestEnum.MOBILE_PHONE)) {
            user.setMobileNumber(userRegisterVo.getRequester());
        } else if (userRegisterVo.getRequestEnum().equals(RequestEnum.MAIL)) {
            user.setMail(userRegisterVo.getRequester());
        }
        //注册用户
        user.setUserType(1);
        //登录密码加密
        user.setLoginPassword(PasswordUtil.encrypt(user.getUserName(), userRegisterVo.getLoginPassword()));
        baseMapper.insert(user);
    }

    @Override
    public User getOneUserByMobileNumber(RequestEnum requestEnum, String requester) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();

        if (requestEnum.equals(RequestEnum.MOBILE_PHONE)) {
            log.info("根据手机号获取用户！");
            queryWrapper.eq(User::getMobileNumber, requester);
        } else if (requestEnum.equals(RequestEnum.MAIL)) {
            log.info("根据邮箱号获取用户！");
            queryWrapper.eq(User::getMail, requester);
        } else {
            log.info("暂未开通！");
            throw BizException.BIZ_MSG_NOT_YET_OPEN_EXCEPTION;
        }
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public UserVo login(UserLoginVo loginVo, HttpServletRequest request) {
        User user = this.getOneUserByMobileNumber(loginVo.getRequestEnum(), loginVo.getRequester());
        if (user == null) {
            log.info("没有查到该用户");
            throw BizException.BIZ_USER_ERR_LOGIN_EXCEPTION;
        }
        //传来的密码加密后对比
        String encryptPass = PasswordUtil.encrypt(user.getUserName(), loginVo.getLoginPassword());
        if (!user.getLoginPassword().equals(encryptPass)) {
            log.info("密码匹配不上");
            throw BizException.BIZ_USER_ERR_LOGIN_EXCEPTION;
        }
        //校验成功 记录
        loginService.recordLogin(request, user.getId());

        UserVo userVo = new UserVo();
        BeanUtil.copyProperties(user, userVo);

        //用户信息存放到redis
        String token = redisService.userToToken(userVo);
        userVo.setToken(token);
        return userVo;
    }

    @Override
    public void cidRegister(DeviceVo deviceVo) {
        UserVo currentUser = redisService.getCurrentUser();
        TtUserDevice device = new TtUserDevice();
        device.setCid(deviceVo.getCid());
        device.setUserid(currentUser.getId());
        deviceService.save(device);
    }


}
