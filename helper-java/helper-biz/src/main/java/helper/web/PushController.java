//package helper.web;
//
//import co.imdo.perfect.getui.api.GeTuiService;
//import common.common.HttpMethod;
//import common.common.base.R;
//import helper.service.IUserService;
//import helper.vo.user.DeviceVo;
//import helper.vo.user.UserLoginVo;
//import helper.vo.user.UserRegisterVo;
//import helper.vo.user.UserVo;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * <p>
// * 用户信息表  以手机号确定用户唯一
// * </p>
// *
// * @author liuSongLin
// * @since 2019-11-19
// */
//@Slf4j
//@RestController
//@RequestMapping("/user")
//@Api(value = "用户功能", tags = "用户功能")
//public class PushController {
//
//    @Autowired
//    private PushService pushService;
//
//
//    @ResponseBody
//    @PostMapping("/register")
//    @ApiOperation(value = "1、用户手机号或邮箱注册",
//            httpMethod = HttpMethod.POST,
//            response = R.class,
//            notes = "1、用户手机号或邮箱注册",
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
//            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//
//    public R register(@Validated(UserRegisterVo.Check.class) @RequestBody UserRegisterVo userRegisterVo) throws Exception {
//        pushService.push(userRegisterVo);
//        return R.of();
//    }
//
//
//}
