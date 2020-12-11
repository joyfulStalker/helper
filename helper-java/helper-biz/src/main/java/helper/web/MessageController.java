package helper.web;

import common.common.HttpMethod;
import common.common.base.R;
import common.common.sms.BaseSmsInfoVo;
import helper.service.IMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 短信发送  前端控制器
 * </p>
 *
 * @author liuSongLin
 * @since 2019-11-19
 */
@Slf4j
@RestController
@RequestMapping("/message")
@Api(value = "信息功能", tags = "信息功能")
public class MessageController {

    @Autowired
    private IMessageService messageService;


    @ResponseBody
    @PostMapping("/sendCodeToUser")
    @ApiOperation(value = "1、获取验证码",
            httpMethod = HttpMethod.POST,
            response = R.class,
            notes = "1、获取验证码",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R sendCodeToUser(@Validated(BaseSmsInfoVo.Check.class) @RequestBody BaseSmsInfoVo baseSmsInfoVo, HttpServletRequest request) {
        messageService.sendCode(baseSmsInfoVo.getRequestEnum(), baseSmsInfoVo.getRequester(), baseSmsInfoVo.getSmsEnum(), request);
        return R.of();
    }
}
