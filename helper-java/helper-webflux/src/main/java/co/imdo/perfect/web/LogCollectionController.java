package co.imdo.perfect.web;

import co.imdo.perfect.entity.LogCollection;
import co.imdo.perfect.service.LogCollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author liu
 */
@Slf4j
@RestController
@RequestMapping("/log")
@Api(value = "log示例", tags = "log示例")
public class LogCollectionController {

    @Autowired
    private LogCollectionService logCollectionService;


    @PostMapping("/query")
    @ApiOperation(value = "1、query",
            httpMethod = "POST",
            response = LogCollection.class,
            notes = "1、query",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Flux<LogCollection> query() {
        return logCollectionService.query();
    }

    @PostMapping("/findById")
    @ApiOperation(value = "3、findById",
            httpMethod = "POST",
            response = LogCollection.class,
            notes = "3、findById",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE,
            consumes = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<LogCollection> findById(@RequestParam("id") String id) {
        return logCollectionService.findById(id);
    }

}
