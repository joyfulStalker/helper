package co.imdo.perfect.repository;

import co.imdo.perfect.entity.FirstMongo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface FirstMongoRepository extends ReactiveMongoRepository<FirstMongo, String> {

    /**
     * 根据名字查
     *
     * @param name
     * @return
     */
    Flux<FirstMongo> findAllByName(String name);
}
