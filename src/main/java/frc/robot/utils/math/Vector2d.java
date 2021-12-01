package frc.robot.utils.math;

import frc.robot.purepursuit.PathPoint;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vector2d {
    private double x;
    private double y;

    public static Vector2d fromPathPoints(PathPoint point1, PathPoint point2) {
        return new Vector2d(point2.getX() - point1.getX(), point2.getY() - point1.getY());
    }

    public Vector2d(Vector2d clone) {
        this(clone.getX(), clone.getY());
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public void normalize() {
        divide(magnitude());
    }

    public Vector2d getNormalized() {
        Vector2d copy = new Vector2d(this);
        copy.normalize();
        return copy;
    }

    public void multiply(double multiplier) {
        x *= multiplier;
        y *= multiplier;
    }

    public void divide(double divider) {
        x /= divider;
        y /= divider;
    }
}
