/*
 * Copyright (C) Lundegaard a.s. 2022 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package com.example.hocuspocus.allterrain;

import java.util.List;
import lombok.Value;

@Value
public class Driver {

    String name;

    Visitor driversLicence;

    List<Motion> motions = List.of(new FlyMotion(), new DriveMotion(), new SwimMotion());

}
