package co.imdo.perfect.service;

import co.imdo.perfect.entity.FirstMongo;
import co.imdo.perfect.vo.FirstMongoVo;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FirstMongoService {
    /**
     * 查询
     *
     * @param query
     * @return
     */
    Flux<FirstMongo> query(FirstMongoVo query);

    Mono firstTestMongoInsertOne(FirstMongoVo insert);

    Mono<FirstMongo> firstTestMongoById(String id);
}
