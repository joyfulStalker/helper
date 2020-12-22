package co.imdo.perfect.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author liu
 */
@Slf4j
@RestController
@RequestMapping("/test")
@Api(value = "test示例", tags = "test示例")
public class TestController {

    @PostMapping("/testLogErr")
    @ApiOperation(value = "1、testLogErr",
            httpMethod = "POST",
            response = Mono.class,
            notes = "1、testLogErr",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono testLogErr() {
        System.out.println(1 / 0);
        return null;
    }
}
