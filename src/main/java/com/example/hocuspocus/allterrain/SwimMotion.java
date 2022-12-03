/*
 * Copyright (C) Lundegaard a.s. 2022 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package com.example.hocuspocus.allterrain;

public class SwimMotion extends Motion {

    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
