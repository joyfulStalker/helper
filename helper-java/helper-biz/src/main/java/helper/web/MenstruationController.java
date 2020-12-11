package helper.web;

import common.common.HttpMethod;
import common.common.base.R;
import helper.service.IMenstruationService;
import helper.vo.more.MenstruationQueryVO;
import helper.vo.more.MenstruationVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liuSongLin
 * @since 2019-11-19
 */
@RestController
@RequestMapping("/menstruation")
@Api(value = "助手功能", tags = "助手功能")
public class MenstruationController {

    @Autowired
    private IMenstruationService menstruationService;

    @ResponseBody
    @PostMapping("/addOrUpdate")
    @ApiOperation(value = "1、新增数据或修改当前数据",
            httpMethod = HttpMethod.POST,
            response = R.class,
            notes = "1、新增数据或修改当前数据",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R addOrUpdate(@Validated(MenstruationVO.Check.class) @RequestBody MenstruationVO menstruationVo) {
        menstruationService.addOrUpdate(menstruationVo);
        return R.of();
    }


    @ResponseBody
    @PostMapping("/list")
    @ApiOperation(value = "2、列表查询",
            httpMethod = HttpMethod.POST,
            response = R.class,
            notes = "2、列表查询",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R list(@RequestBody MenstruationQueryVO queryVO) {
        return R.of(menstruationService.list(queryVO));
    }


    @ResponseBody
    @GetMapping("/taskMenstruationRemind")
    @ApiOperation(value = "3、定时提醒",
            httpMethod = HttpMethod.GET,
            response = R.class,
            notes = "3、定时提醒",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R taskRemind() {
        menstruationService.taskMenstruationRemind();
        return R.of();
    }
}
