// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.purepursuit;

import frc.robot.utils.math.Vector2d;
import java.util.ArrayList;
import java.util.List;


/** Add your docs here. */
public class PurePursuitPath {
    private List<PathPoint> points = new ArrayList<>();

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
        this.injectPoints(0.15);
    }

    public void injectPoints(double spacing) {
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

    /**
     * Team 2168's smoothing algorithm
     *
     * @param a         weight data (around 1 - b)
     * @param b         weight smooth: increase to get smoother path (between 0.75 -
     *                  0.98)
     * @param tolerance (around 0.001)
     */
    public void smoothPoints(double a, double b, double tolerance) {
        List<PathPoint> newPoints = new ArrayList<>(points);

        double change = tolerance;
        while (change >= tolerance) {
            change = 0.0;
            for (int i = 1; i < newPoints.size() - 1; i++) {
                PathPoint currentPoint = newPoints.get(i);
                PathPoint previousPoint = newPoints.get(i - 1);
                PathPoint nextPoint = newPoints.get(i + 1);

                double storedX = currentPoint.getX();
                double storedY = currentPoint.getY();

                currentPoint.setX(currentPoint.getX() + (a * (points.get(i).getX() - currentPoint.getX())
                        + b * (previousPoint.getX() + nextPoint.getX() - 2 * currentPoint.getX())));
                currentPoint.setY(currentPoint.getY() + (a * (points.get(i).getY() - currentPoint.getY())
                        + b * (previousPoint.getY() + nextPoint.getY() - 2 * currentPoint.getY())));

                change += Math.abs(storedX - currentPoint.getX());
                change += Math.abs(storedY - currentPoint.getY());
            }
        }

        points = newPoints;
    }

}
