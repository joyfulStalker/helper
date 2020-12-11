package helper.web.wx;

import common.common.HttpMethod;
import common.common.base.R;
import helper.service.IWxService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
@Api(value = "微信小程序功能", tags = "微信小程序功能")
public class WxController {

    @Autowired
    private IWxService wxService;

    //    @Monitor
    @ResponseBody
    @GetMapping("/getOpenId")
    @ApiOperation(value = "1、获取openId",
            httpMethod = HttpMethod.GET,
            response = R.class,
            notes = "1、获取openId",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public R sendCodeToUser(@RequestParam String jsCode) {
        return R.of(wxService.getOpenId(jsCode));
    }
}
