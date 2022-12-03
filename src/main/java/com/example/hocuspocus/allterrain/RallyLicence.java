/*
 * Copyright (C) Lundegaard a.s. 2022 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package com.example.hocuspocus.allterrain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RallyLicence implements Visitor {

    @Override
    public void visit(final FlyMotion flyMotion) {
        log.info("xxx flying ...");
    }

    @Override
    public void visit(final DriveMotion driveMotion) {
        log.info("xxx driving ...");
    }

    @Override
    public void visit(final SwimMotion swimMotion) {
        log.info("xxx swimming ...");
    }
}
