package co.imdo.perfect.service.impl;

import co.imdo.perfect.entity.FirstMongo;
import co.imdo.perfect.repository.FirstMongoRepository;
import co.imdo.perfect.service.FirstMongoService;
import co.imdo.perfect.vo.FirstMongoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Slf4j
@Service
public class FirstMongoServiceImpl implements FirstMongoService {

    @Autowired
    private FirstMongoRepository firstMongoRepository;

    @Override
    public Flux<FirstMongo> firstTestMongo(FirstMongoVo query) {
        FirstMongo firstMongo = new FirstMongo();
        BeanUtils.copyProperties(query, firstMongo);
        return firstMongoRepository.findAll(Example.of(firstMongo));
    }

    @Override
    public Mono firstTestMongoInsert(Flux<FirstMongoVo> insert) {
        Flux<FirstMongo> flux = Flux.just(insert).cast(FirstMongo.class);
        Flux<FirstMongo> insert1 = firstMongoRepository.insert(flux);
        log.info(insert1.toString());
        return null;
    }

    @Override
    public Mono firstTestMongoInsertOne(Mono<FirstMongoVo> insert) {

        Mono<FirstMongo> cast = insert.cast(FirstMongo.class);

        Flux<FirstMongo> insert1 = firstMongoRepository.insert(insert.cast(FirstMongo.class));

        return null;
    }

    @Override
    public Mono<FirstMongo> firstTestMongoById(String id) {
        Mono<FirstMongo> byId = firstMongoRepository.findById(id);

//        log.info(byId.blockOptional().get().toString());
        return byId;
    }
}
