// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.utils;

import org.junit.Test;

import frc.robot.purepursuit.PathPoint;

/** Add your docs here. */
public class MathUtilsTest {
    @Test
    public void distanceFormula_PathPoint34_Returns5() {
        PathPoint point1 = new PathPoint(0, 0, 0, 0, 0);
        PathPoint point1 = new PathPoint(3, 4, 0, 0, 0);
        MathUtils.distanceFormula(3, 4);
    }
}
