package co.imdo.perfect.service.impl;

import co.imdo.perfect.repository.TestReposity;
import co.imdo.perfect.service.MongoTestService;
import co.imdo.perfect.vo.TestVo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import javax.annotation.Resource;

@Service
public class MongoTestServiceImpl implements MongoTestService {

    @Resource
    private TestReposity testReposity;


    @Override
    public Flux<TestVo> firstTestMongo() {
        Flux<TestVo> all = testReposity.findAll();
        return all;
    }
}
