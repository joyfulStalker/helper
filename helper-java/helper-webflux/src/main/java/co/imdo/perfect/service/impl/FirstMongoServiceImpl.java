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

@Slf4j
@Service
public class FirstMongoServiceImpl implements FirstMongoService {

    @Autowired
    private FirstMongoRepository firstMongoRepository;

    @Override
    public Flux<FirstMongo> query(FirstMongoVo query) {
        System.out.println("FirstMongoServiceImpl:" + Thread.currentThread().getName());
        FirstMongo firstMongo = new FirstMongo();
        BeanUtils.copyProperties(query, firstMongo);
        return firstMongoRepository.findAll(Example.of(firstMongo));
    }

    @Override
    public Mono save(FirstMongoVo insert) {
        FirstMongo firstMongo = new FirstMongo();
        BeanUtils.copyProperties(insert, firstMongo);
        return firstMongoRepository.save(firstMongo);
    }

    @Override
    public Mono<FirstMongo> findById(String id) {
        return firstMongoRepository.findById(id);
    }
}
