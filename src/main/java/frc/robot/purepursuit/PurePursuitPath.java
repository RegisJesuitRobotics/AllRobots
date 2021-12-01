// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.purepursuit;

import frc.robot.utils.math.Vector2d;
import java.util.ArrayList;
import java.util.List;

import lombok.Setter;

/** Add your docs here. */
public class PurePursuitPath {
    @Setter
    private double spacing; // meters

    private List<PathPoint> points = new ArrayList<>();

    /**
     * @param spacing spacing between points for when points are injected (meters)
     */
    public PurePursuitPath(double spacing) {
        this.spacing = spacing;
    }

    /**
     * Creates with default spacing of 0.15 meters
     */
    public PurePursuitPath() {
        this(0.15);
    }

    public void addPoint(double x, double y) {
        points.add(new PathPoint(x, y));
    }

    public int getSize() {
        return points.size();
    }

    /**
     * @return a COPY of the list of points
     */
    public List<PathPoint> getPoints() {
        return new ArrayList<>(points);
    }

    public void injectPoints() {
        List<PathPoint> newPoints = new ArrayList<>();

        for (int i = 0; i < points.size() - 1; i++) {
            PathPoint startPoint = points.get(i);
            PathPoint endPoint = points.get(i + 1);

            Vector2d vector2d = Vector2d.fromPathPoints(startPoint, endPoint);

            double amountOfPointsToAdd = Math.ceil(vector2d.magnitude() / spacing);
            vector2d.normalize();
            double xAdditive = vector2d.getX() * spacing;
            double yAdditive = vector2d.getY() * spacing;

            for (int j = 0; j < amountOfPointsToAdd; j++) {
                // As we get farther from the original point add more of the additive
                newPoints.add(new PathPoint(startPoint.getX() + (xAdditive * j), startPoint.getY() + (yAdditive * j)));
            }
        }
        newPoints.add(points.get(points.size() - 1)); // Add the last point

        points = newPoints;
    }

}
