package helper.web;

import common.common.HttpMethod;
import common.common.base.R;
import helper.service.ITestBatchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liuSongLin
 * @since 2020-03-08
 */
@RestController
@RequestMapping("/test")
@Api(value = "测试功能", tags = "测试功能")
public class TestBatchController {
    @Autowired
    private ITestBatchService testBatchService;


    @ResponseBody
    @GetMapping("/testInsertBatch")
    @ApiOperation(value = "1、测试批量插入返回id",
            httpMethod = HttpMethod.GET,
            response = R.class,
            notes = "结论：mybatisPlus的批量保存可以返回id",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public R testInsertBatch() {
        testBatchService.testInsertBatch();
        return R.of();
    }


    @ResponseBody
    @GetMapping("/testUpdateBatch")
    @ApiOperation(value = "2、测试批量更新非数据库字段保存后不丢失",
            httpMethod = HttpMethod.GET,
            response = R.class,
            notes = "结论：mybatisPlus的批量更新非数据库字段保存后不丢失",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public R testBatch() {
        testBatchService.testUpdateBatch();
        return R.of();
    }
}
