package com.example.hocuspocus.userevent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VoidOrderEvent implements Event {

    @Override
    public String processEvent(EventVisitor visitor) {
        log.warn("Unknown message in stream with key '{}'", "asda");
        return null;
    }

}
