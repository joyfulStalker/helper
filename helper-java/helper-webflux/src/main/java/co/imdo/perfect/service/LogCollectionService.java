package co.imdo.perfect.service;

import co.imdo.perfect.entity.LogCollection;
import reactor.core.publisher.Mono;

public interface LogCollectionService {
    Mono save(LogCollection logCollection);
}
