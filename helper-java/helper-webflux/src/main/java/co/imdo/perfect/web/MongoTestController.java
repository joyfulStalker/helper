package co.imdo.perfect.web;

import co.imdo.perfect.service.MongoTestService;
import co.imdo.perfect.vo.TestVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class MongoTestController {

    @Autowired
    private MongoTestService mongoTestService;


    @PostMapping("/firstTestMongo")
    @ApiOperation(value = "1、firstTestMongo",
            httpMethod = "POST",
            response = TestVo.class,
            notes = "1、firstTestMongo",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE,
            consumes = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<TestVo> firstTestMongo() {
        return mongoTestService.firstTestMongo();
    }


}
