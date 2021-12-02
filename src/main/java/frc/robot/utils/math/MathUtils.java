package frc.robot.utils.math;

import frc.robot.purepursuit.PathPoint;

public class MathUtils {
    private MathUtils() {}

    public static double getCurvature(PathPoint curvaturePoint, PathPoint previousPoint, PathPoint nextPoint) {
        Vector2d previousVector = Vector2d.fromPathPoints(curvaturePoint, previousPoint);
        Vector2d nextVector = Vector2d.fromPathPoints(curvaturePoint, nextPoint);

        double angle = vectorAngle(previousVector, nextVector);

        // https://en.wikipedia.org/wiki/Law_of_sines#Relation_to_the_circumcircle
        return 1 / (PathPoint.getDistance(previousPoint, nextPoint) / (2 * Math.sin(angle)));
    }

    /**
     * @param angle1 vector 1
     * @param angle2 vector 2
     * @return The angle from 0 - pi in radians
     */
    public static double vectorAngle(Vector2d angle1, Vector2d angle2) {
        return Math.acos(angle1.getNormalized().dot(angle2.getNormalized()));
    }

    public static double sqr(double base) {
        return base * base;
    }
}
