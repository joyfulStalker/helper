package co.imdo.perfect.service;

import co.imdo.perfect.vo.TestVo;
import reactor.core.publisher.Flux;

public interface MongoTestService {
    Flux<TestVo> firstTestMongo();
}
