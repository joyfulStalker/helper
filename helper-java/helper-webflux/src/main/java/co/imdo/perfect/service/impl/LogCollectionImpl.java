package co.imdo.perfect.service.impl;

import co.imdo.perfect.entity.LogCollection;
import co.imdo.perfect.repository.LogCollectionRepository;
import co.imdo.perfect.service.LogCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LogCollectionImpl implements LogCollectionService {

    @Autowired
    private LogCollectionRepository logCollectionRepository;

    @Override
    public Flux<LogCollection> query() {
        return logCollectionRepository.findAll();
    }

    @Override
    public Mono<LogCollection> findById(String id) {
        return logCollectionRepository.findById(id);
    }
}
