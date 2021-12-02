package frc.robot.purepursuit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PathPointTest {
    @Test
    void distanceTo_ThreeFourTriangleFromOrigin_ReturnsCorrect() {
        PathPoint origin = PathPoint.origin();
        PathPoint point = new PathPoint(3, 4);

        assertEquals(5, PathPoint.getDistance(origin, point), 0);
        assertEquals(5, PathPoint.getDistance(point, origin), 0);
    }

    @Test
    void distanceTo_NotNiceTriangleFromOrigin_ReturnsCorrect() {
        PathPoint origin = PathPoint.origin();
        PathPoint point = new PathPoint(3, 1);

        assertEquals(3.162, PathPoint.getDistance(origin, point), 0.001);
        assertEquals(3.162, PathPoint.getDistance(point, origin), 0.001);
    }

    @Test
    void distanceTo_ThreeFourTriangleNotOrigin_ReturnsCorrect() {
        PathPoint origin = new PathPoint(1, 2);
        PathPoint point = new PathPoint(4, 6);

        assertEquals(5, PathPoint.getDistance(origin, point), 0);
        assertEquals(5, PathPoint.getDistance(point, origin), 0);
    }

    @Test
    void distanceTo_ThreeFourTriangleFullyNegative_ReturnsCorrect() {
        PathPoint origin = new PathPoint(-1, -2);
        PathPoint point = new PathPoint(-4, -6);

        assertEquals(5, PathPoint.getDistance(origin, point), 0);
        assertEquals(5, PathPoint.getDistance(point, origin), 0);
    }

    @Test
    void distanceTo_ThreeFourTriangleHalfNegative_ReturnsCorrect() {
        PathPoint origin = new PathPoint(-1, -2);
        PathPoint point = new PathPoint(2, 2);

        assertEquals(5, PathPoint.getDistance(origin, point), 0);
        assertEquals(5, PathPoint.getDistance(point, origin), 0);
    }

}
