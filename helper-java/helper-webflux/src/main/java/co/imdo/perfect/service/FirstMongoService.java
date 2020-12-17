package co.imdo.perfect.service;

import co.imdo.perfect.entity.FirstMongo;
import co.imdo.perfect.vo.FirstMongoVo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FirstMongoService {
    /**
     * 查询
     *
     * @param query
     * @return
     */
    Flux<FirstMongo> firstTestMongo(FirstMongoVo query);

    /**
     * 保存
     *
     * @param insert
     * @return
     */
    Mono firstTestMongoInsert(Flux<FirstMongoVo> insert);


    Mono firstTestMongoInsertOne(Mono<FirstMongoVo> insert);

    Mono<FirstMongo> firstTestMongoById(String id);
}
