package com.example.hocuspocus.visitor;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = VoidOrderEvent.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreateUserEvent.class),
        @JsonSubTypes.Type(value = UpdateUserEvent.class),
        @JsonSubTypes.Type(value = DeleteUserEvent.class)

})
public interface Event {

    String processEvent(EventVisitor visitor);

    interface EventVisitor {

        String handle(CreateUserEvent event);

        String handle(UpdateUserEvent event);

        String handle(DeleteUserEvent event);
    }

}
