package helper.service;

import helper.vo.user.UserVo;

public interface RedisService {

    /**
     * 用户信息存放到redis，并获取token
     *
     * @param userVo
     * @return
     */
    String userToToken(UserVo userVo);

    /**
     * token换用户信息
     *
     * @param token
     * @return
     * @allowNull 获取用户失败是否抛异常
     */
    UserVo getUserByToken(String token, boolean allowThrowException);

    /**
     * token换用户信息
     *
     * @return
     * @allowNull 获取用户失败是否抛异常
     */
    UserVo getCurrentUser(boolean allowThrowException);

    /**
     * token换用户信息
     *
     * @return
     */
    UserVo getCurrentUser();

}
