package co.imdo.perfect.web;

import co.imdo.perfect.entity.FirstMongo;
import co.imdo.perfect.service.FirstMongoService;
import co.imdo.perfect.vo.FirstMongoVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
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

    @PostMapping("/firstTestMongoInsertOne")
    @ApiOperation(value = "2、firstTestMongoInsertOne",
            httpMethod = "POST",
            response = FirstMongo.class,
            notes = "2、firstTestMongoInsertOne",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono firstTestMongoInsertOne(@RequestBody FirstMongoVo insert) {
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
