package co.imdo.perfect.web;

import co.imdo.perfect.entity.FirstMongo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author liu
 */
@Slf4j
@RestController
@RequestMapping("/redis")
@Api(value = "redis示例", tags = "redis示例")
public class ReactiveRedisController {

    @Autowired
    private ReactiveStringRedisTemplate reactiveStringRedisTemplate;

    @GetMapping("/query")
    @ApiOperation(value = "1、query",
            httpMethod = "GET",
            response = FirstMongo.class,
            notes = "1、query",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> query() {
        reactiveStringRedisTemplate.opsForValue().set("key", "hello").subscribe();
        return reactiveStringRedisTemplate.opsForValue().get("key");
    }

}
