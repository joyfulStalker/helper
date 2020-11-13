package helper.service.impl;

import com.alibaba.fastjson.JSON;
import common.common.base.BizException;
import helper.service.RedisService;
import helper.vo.user.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private JedisPool jedisPool;

    @Override
    public String userToToken(UserVo userVo) {
        String token = UUID.randomUUID().toString().replace("-", "");
        Jedis jedis = jedisPool.getResource();
        jedisPool.getResource().set(token, JSON.toJSONString(userVo));
        jedis.close();
        return token;
    }

    @Override
    public UserVo getUserByToken(String token, boolean allowThrowException) {
        Jedis jedis = jedisPool.getResource();
        String user = jedis.get(token);
        jedis.close();
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
