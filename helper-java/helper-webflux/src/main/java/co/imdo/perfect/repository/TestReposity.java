package co.imdo.perfect.repository;

import co.imdo.perfect.vo.TestVo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestReposity extends ReactiveMongoRepository<TestVo, String> {
}
