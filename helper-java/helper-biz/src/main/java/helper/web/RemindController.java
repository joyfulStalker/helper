package helper.web;

import common.common.HttpMethod;
import common.common.base.R;
import helper.service.IRemindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 时间提醒  前端控制器
 * </p>
 *
 * @author liuSongLin
 * @since 2019-12-13
 */
@RestController
@ApiSort(value = 4)
@RequestMapping("/remind")
@Api(value = "提醒功能", tags = "提醒功能")
public class RemindController {

    @Autowired
    private IRemindService remindService;


    @ResponseBody
    @PostMapping("/addRemind")
    @ApiOperation(value = "1、新增提醒",
            httpMethod = HttpMethod.POST,
            response = R.class,
            notes = "1、新增提醒",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperationSupport(order = 1)
    public R addRemind() {
        return R.of();
    }

}
