package com.example.hocuspocus.visitor;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import reactor.core.publisher.Mono;

@SuperBuilder
@Jacksonized
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonTypeName(DeleteUserEvent.CREATE_TYPE)
public class DeleteUserEvent extends AbstractUserEvent implements Event {

    public static final String CREATE_TYPE = "CREATE";

    @Override
    public Mono<Event> processEvent(String key, EventVisitor visitor) {
        return visitor.handle(key, this);
    }
}
