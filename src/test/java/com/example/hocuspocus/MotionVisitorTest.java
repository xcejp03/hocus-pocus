/*
 * Copyright (C) Lundegaard a.s. 2022 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package com.example.hocuspocus;

import com.example.hocuspocus.allterrain.Car;
import com.example.hocuspocus.allterrain.Driver;
import com.example.hocuspocus.allterrain.RallyLicence;
import org.junit.jupiter.api.Test;

public class MotionVisitorTest {

    @Test
    public void visit() {

        Driver driver = new Driver("Stig", new RallyLicence());
        Car car = new Car("red");

        //     car.move(driver.getDriversLicence(), driver.getMotions().get(0));

        driver.getMotions().forEach(motion -> car.move(driver.getDriversLicence(), motion));
    }

}
