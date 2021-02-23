package helper.web;

import common.common.HttpMethod;
import common.common.base.BaseQuery;
import common.common.base.R;
import helper.service.ITtNoticeService;
import helper.vo.notice.SendNoticeVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 消息通知  前端控制器
 * </p>
 *
 * @author liuSongLin
 * @since 2021-02-23
 */
@Controller
@RequestMapping("/notice")
public class TtNoticeController {

    @Autowired
    private ITtNoticeService noticeService;

    @ResponseBody
    @PostMapping("/send")
    @ApiOperation(value = "1、发送消息",
            httpMethod = HttpMethod.POST,
            response = R.class,
            notes = "1、发送消息",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public R list(@Validated(SendNoticeVo.Check.class) @RequestBody SendNoticeVo queryVo) {
        noticeService.send(queryVo);
        return R.of();
    }

    @ResponseBody
    @PostMapping("/list")
    @ApiOperation(value = "2、消息列表",
            httpMethod = HttpMethod.POST,
            response = R.class,
            notes = "2、消息列表",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public R noticeList(@RequestBody BaseQuery queryVo) {
        return R.of(noticeService.noticeList(queryVo));
//        return R.of();
    }
}
