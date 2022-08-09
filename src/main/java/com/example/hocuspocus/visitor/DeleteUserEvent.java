package com.example.hocuspocus.visitor;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@SuperBuilder
@Jacksonized
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonTypeName(DeleteUserEvent.CREATE_TYPE)
public class DeleteUserEvent extends AbstractUserEvent implements Event {

    public static final java.lang.String CREATE_TYPE = "CREATE";

    @Override
    public String processEvent(EventVisitor visitor) {
        return visitor.handle(this);
    }
}
