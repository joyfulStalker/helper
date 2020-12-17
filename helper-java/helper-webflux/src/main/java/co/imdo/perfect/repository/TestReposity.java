package co.imdo.perfect.repository;

import co.imdo.perfect.vo.TestVo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TestReposity extends ReactiveMongoRepository<TestVo, String> {

    /**
     * 根据名字查
     *
     * @param helper
     * @return
     */
    Flux<TestVo> findAllByName(String helper);
}
