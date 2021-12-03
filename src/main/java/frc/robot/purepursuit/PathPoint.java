// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.purepursuit;


import edu.wpi.first.wpilibj.geometry.Pose2d;
import frc.robot.utils.math.Point2d;
import lombok.Data;

/**
 * Class used to keep data on specific point in PurePursuit path
 */
@Data
public class PathPoint {
    private double x;
    private double y;
    private double maxVelocity = 0;
    private double velocity = 0;
    private double curvature = 0;

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
        this.maxVelocity = pathPoint.getMaxVelocity();
        this.velocity = pathPoint.getVelocity();
        this.curvature = pathPoint.getCurvature();
    }

    public Point2d getPoint() {
        return new Point2d(x, y);
    }

    public static PathPoint origin() {
        return new PathPoint(0, 0);
    }

    public static double distance(PathPoint point1, PathPoint point2) {
        return Point2d.distance(point1.getPoint(), point2.getPoint());
    }

    public static double distancePose2d(PathPoint point, Pose2d pose) {
        return Point2d.distance(point.getPoint(), new Point2d(pose));
    }
}
