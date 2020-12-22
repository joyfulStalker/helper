package co.imdo.perfect.service.impl;

import co.imdo.perfect.entity.LogCollection;
import co.imdo.perfect.repository.LogCollectionRepository;
import co.imdo.perfect.service.LogCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class LogCollectionServiceImpl implements LogCollectionService {

    @Autowired
    private LogCollectionRepository logCollectionRepository;

    @Override
    public Mono save(LogCollection logCollection) {
        System.out.println("LogCollectionServiceImpl:" + Thread.currentThread().getName());
        return logCollectionRepository.save(logCollection);
    }
}
