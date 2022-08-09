/*
 * Copyright (C) Lundegaard a.s. 2022 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package com.example.hocuspocus;

import com.example.hocuspocus.visitor.CreateUserEvent;
import com.example.hocuspocus.visitor.DeleteUserEvent;
import com.example.hocuspocus.visitor.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class VisitorTest {

    @Test
    public void test() {
        CreateUserEvent createUserEvent = new CreateUserEvent();
        DeleteUserEvent deleteUserEvent = new DeleteUserEvent();

        UserService userService = new UserService();

        var result = userService.transform(createUserEvent);
        log.info("xxx result : {}", result);
        log.info("xxx result 2 : {}", userService.transform(deleteUserEvent));

    }

}
