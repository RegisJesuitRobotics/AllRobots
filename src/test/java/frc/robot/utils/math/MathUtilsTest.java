package frc.robot.utils.math;

import static org.junit.jupiter.api.Assertions.*;

import frc.robot.purepursuit.PathPoint;
import org.junit.jupiter.api.Test;

class MathUtilsTest {
    @Test
    void curvature_ReturnsCorrect() {
        PathPoint curr = new PathPoint(2, 4);
        PathPoint prev = PathPoint.origin();
        PathPoint next = new PathPoint(5, 5);

        assertEquals(0.2, MathUtils.getCurvature(curr, prev, next));
    }

    @Test
    void vectorAngle_ReturnsCorrect() {
        assertEquals(0.5 * Math.PI, MathUtils.vectorAngle(new Vector2d(0, 1), new Vector2d(1, 0)));
        assertEquals(0.0555, MathUtils.vectorAngle(new Vector2d(3, 4), new Vector2d(2, 3)), 0.001);
        assertEquals(1.7895, MathUtils.vectorAngle(new Vector2d(2, -6), new Vector2d(5, 3)), 0.001);
    }
}
