/*
 * Copyright (C) Lundegaard a.s. 2022 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package com.example.hocuspocus.allterrain;

import lombok.Value;

@Value
public class Car {

    String color;

    public void move(Visitor v, Motion motion) {
        motion.accept(v);
    }
}
