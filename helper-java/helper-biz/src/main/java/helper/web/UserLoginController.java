package helper.web;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户登录信息记录  前端控制器
 * </p>
 *
 * @author liuSongLin
 * @since 2019-11-19
 */
@RestController
@RequestMapping("/userLogin")
@Api(value = "用户登录信息", tags = "用户登录信息")
public class UserLoginController {

}
