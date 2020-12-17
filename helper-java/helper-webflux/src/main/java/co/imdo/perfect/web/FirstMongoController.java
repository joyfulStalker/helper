package co.imdo.perfect.web;

import co.imdo.perfect.entity.FirstMongo;
import co.imdo.perfect.service.FirstMongoService;
import co.imdo.perfect.vo.FirstMongoVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FirstMongoController {

    @Autowired
    private FirstMongoService mongoTestService;


    @PostMapping("/firstTestMongo")
    @ApiOperation(value = "1、firstTestMongo",
            httpMethod = "POST",
            response = FirstMongo.class,
            notes = "1、firstTestMongo",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE,
            consumes = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<FirstMongo> firstTestMongo(@RequestBody FirstMongoVo query) {
        return mongoTestService.firstTestMongo(query);
    }

    @PostMapping("/firstTestMongoInsert")
    @ApiOperation(value = "2、firstTestMongoInsert",
            httpMethod = "POST",
            response = FirstMongo.class,
            notes = "2、firstTestMongoInsert",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono firstTestMongoInsert(@RequestBody Flux<FirstMongoVo> insert) {
        return mongoTestService.firstTestMongoInsert(insert);
    }

    @PostMapping("/firstTestMongoInsertOne")
    @ApiOperation(value = "2、firstTestMongoInsertOne",
            httpMethod = "POST",
            response = FirstMongo.class,
            notes = "2、firstTestMongoInsertOne",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono firstTestMongoInsertOne(@RequestBody Mono<FirstMongoVo> insert) {
        return mongoTestService.firstTestMongoInsertOne(insert);
    }


    @PostMapping("/firstTestMongoById")
    @ApiOperation(value = "1、firstTestMongoById",
            httpMethod = "POST",
            response = FirstMongo.class,
            notes = "1、firstTestMongoById",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE,
            consumes = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<FirstMongo> firstTestMongoById(@RequestParam("id") String id) {
        return mongoTestService.firstTestMongoById(id);
    }
}
