package helper.web;

import common.common.HttpMethod;
import common.common.base.R;
import helper.service.RedisExampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/redisExample")
@Api(value = "redis的常用方法", tags = "redis的常用方法")
public class RedisExampleController {

    @Autowired
    private RedisExampleService redisExampleService;


    @ResponseBody
    @PostMapping("/generateDistributeId")
    @ApiOperation(value = "1、获取分布式ID",
            httpMethod = HttpMethod.POST,
            response = R.class,
            notes = "1、获取分布式ID",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public R generateDistributeId(String type) {
        return R.of(redisExampleService.generateDistributeId(type));
    }

}
