// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.purepursuit;

import lombok.Data;

/**
 * Class used to keep data on specific point in PurePursuit path
 */
@Data
public class PathPoint {
    private double x;
    private double y;
    private double velocity;
    private double curvature;

    /**
     * Creates a path point
     *
     * @param x the x coordinate (meters)
     * @param y the y coordinate (meters)
     */
    public PathPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public PathPoint(double x, double y, double velocity, double curvature) {
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        this.curvature = curvature;
    }

    public PathPoint(PathPoint pathPoint) {
        this.x = pathPoint.getX();
        this.y = pathPoint.getY();
        this.velocity = pathPoint.getVelocity();
        this.curvature = pathPoint.getCurvature();
    }

    public static PathPoint origin() {
        return new PathPoint(0, 0);
    }

    public double getDistance(PathPoint point) {
        return Math.sqrt(Math.pow(this.getX() - point.getX(), 2) + Math.pow(this.getY() - point.getY(), 2));
    }
}
