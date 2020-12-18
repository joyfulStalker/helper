package co.imdo.perfect.web;

import co.imdo.perfect.entity.FirstMongo;
import co.imdo.perfect.service.FirstMongoService;
import co.imdo.perfect.vo.FirstMongoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author liu
 */
@Slf4j
@RestController
@RequestMapping("/mongo")
@Api(value = "mongo示例", tags = "mongo示例")
public class FirstMongoController {

    @Autowired
    private FirstMongoService mongoTestService;


    @PostMapping("/query")
    @ApiOperation(value = "1、query",
            httpMethod = "POST",
            response = FirstMongo.class,
            notes = "1、query",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Flux<FirstMongo> query(@RequestBody FirstMongoVo query) {
        return mongoTestService.query(query);
    }

    @PostMapping("/save")
    @ApiOperation(value = "2、save",
            httpMethod = "POST",
            response = FirstMongo.class,
            notes = "2、save",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono firstTestMongoInsertOne(@RequestBody FirstMongoVo insert) {
        return mongoTestService.save(insert);
    }

    @PostMapping("/findById")
    @ApiOperation(value = "3、findById",
            httpMethod = "POST",
            response = FirstMongo.class,
            notes = "3、findById",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE,
            consumes = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<FirstMongo> findById(@RequestParam("id") String id) {
        return mongoTestService.findById(id);
    }
}
