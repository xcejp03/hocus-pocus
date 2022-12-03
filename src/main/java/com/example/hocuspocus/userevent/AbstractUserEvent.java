package com.example.hocuspocus.userevent;

import java.util.Map;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractUserEvent {

    private Map<UUID, Long> items;

    private UUID customerId;

    private String description;

}
