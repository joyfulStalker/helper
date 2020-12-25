package co.imdo.perfect.repository;

import co.imdo.perfect.entity.LogCollection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogCollectionRepository extends ReactiveMongoRepository<LogCollection, String> {

}
