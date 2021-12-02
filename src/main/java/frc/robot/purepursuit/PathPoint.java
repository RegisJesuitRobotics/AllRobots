// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.purepursuit;

import frc.robot.utils.math.Vector2d;
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

    public Vector2d getVector() {
        return new Vector2d(x, y);
    }

    public static PathPoint origin() {
        return new PathPoint(0, 0);
    }

    public static double getDistance(PathPoint point1, PathPoint point2) {
        return Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
    }
}
