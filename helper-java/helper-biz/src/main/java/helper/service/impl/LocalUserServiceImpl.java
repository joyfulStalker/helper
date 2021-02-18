package helper.service.impl;

import co.imdo.perfect.service.JedisService;
import com.alibaba.fastjson.JSON;
import common.common.base.BizException;
import helper.service.LocalUserService;
import helper.vo.user.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

import static common.common.Constant.TOKEN_PREFIX;
import static common.common.Constant.TOKEN_PREFIX_USER;
import static common.common.enums.TimeEnum.TOKEN_EXPIRE;

@Service
public class LocalUserServiceImpl implements LocalUserService {

    @Autowired
    private JedisService jedisService;

    @Override
    public String userToToken(UserVo userVo) {
        String token = UUID.randomUUID().toString().replace("-", "");
        //上次登录的token
        String lastToken = jedisService.get(TOKEN_PREFIX_USER + userVo.getId());
        if (StringUtils.isNotBlank(lastToken)) {
            jedisService.del(TOKEN_PREFIX + lastToken);
            jedisService.del(TOKEN_PREFIX_USER + userVo.getId());
        }
        jedisService.setex(TOKEN_PREFIX + token, TOKEN_EXPIRE.getTime(), JSON.toJSONString(userVo));
        jedisService.setex(TOKEN_PREFIX_USER + userVo.getId(), TOKEN_EXPIRE.getTime(), token);
        return token;
    }

    @Override
    public UserVo getUserByToken(String token, boolean allowThrowException) {
        String user = jedisService.get(TOKEN_PREFIX+token);
        if (allowThrowException && StringUtils.isEmpty(user)) {
            throw BizException.BIZ_USER_NOT_LOGIN_EXCEPTION;
        }
        return JSON.parseObject(user, UserVo.class);
    }

    @Override
    public UserVo getCurrentUser(boolean allowThrowException) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        UserVo userVo = null;
        if (StringUtils.isNotBlank(token)) {
            userVo = this.getUserByToken(token, allowThrowException);
        }
        return userVo == null ? new UserVo() : userVo;
    }

    @Override
    public UserVo getCurrentUser() {
        return this.getCurrentUser(Boolean.FALSE);
    }

}
