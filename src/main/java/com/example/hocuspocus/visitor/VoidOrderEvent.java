package com.example.hocuspocus.visitor;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class VoidOrderEvent implements Event {

    @Override
    public Mono<Event> processEvent(String key, EventVisitor visitor) {
        log.warn("Unknown message in stream with key '{}'", key);
        return Mono.empty();
    }

}
