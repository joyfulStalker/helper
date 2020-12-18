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
    Flux<FirstMongo> query(FirstMongoVo query);

    /**
     * 保存
     *
     * @param insert
     * @return
     */
    Mono save(FirstMongoVo insert);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    Mono<FirstMongo> findById(String id);
}
