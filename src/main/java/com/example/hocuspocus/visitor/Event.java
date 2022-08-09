package com.example.hocuspocus.visitor;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import reactor.core.publisher.Mono;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = VoidOrderEvent.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreateUserEvent.class),
        @JsonSubTypes.Type(value = UpdateUserEvent.class),
        @JsonSubTypes.Type(value = DeleteUserEvent.class)

})
public interface Event {

    Mono<Event> processEvent(String key, EventVisitor visitor);

    interface EventVisitor {

        Mono<Event> handle(String key, CreateUserEvent event);

        Mono<Event> handle(String key, UpdateUserEvent event);

        Mono<Event> handle(String key, DeleteUserEvent event);
    }

}
