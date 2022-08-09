/*
 * Copyright (C) Lundegaard a.s. 2022 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package com.example.hocuspocus.visitor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserService implements Event.EventVisitor {

    public String transform(Event event) {
        var result = event.processEvent(this);
        return result;
    }

    @Override
    public String handle(final CreateUserEvent event) {
        log.info("xxx CreateUserEvent");
        return "handled CreateUserEvent";
    }

    @Override
    public String handle(final UpdateUserEvent event) {
        log.info("xxx UpdateUserEvent");
        return "handled UpdateUserEvent";
    }

    @Override
    public String handle(final DeleteUserEvent event) {
        log.info("xxx DeleteUserEvent");
        return "handled DeleteUserEvent";
    }
}
