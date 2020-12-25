package co.imdo.perfect.service;

import co.imdo.perfect.entity.LogCollection;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LogCollectionService {

    Flux<LogCollection> query();

    Mono<LogCollection> findById(String id);
}
