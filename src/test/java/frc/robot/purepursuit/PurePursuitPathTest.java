package frc.robot.purepursuit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PurePursuitPathTest {

    PurePursuitPath path;

    @BeforeEach
    void setUp() {
        path = new PurePursuitPath();
    }

    @Test
    void initialize_EmptyPath() {
        assertEquals(0, path.getSize());
    }

    @Test
    void addPoint_SizeIncreased() {
        path.addPoint(0, 0);
        assertEquals(1, path.getSize());

        path.addPoint(0, 1);

        assertEquals(2, path.getSize());
    }

    @Test
    void getPoints_ReturnsCopyOfList() {
        path.addPoint(0, 0);

        List<PathPoint> points = path.getPoints();
        points.clear(); // If it wasn't a copy the points list would be affected

        assertEquals(1, path.getSize());
    }

    @Test
    void injectPoints_TwoPointsSpaceOne_AllPointsThere() {
        // Linear system of y = x
        path.addPoint(0, 0);
        path.addPoint(5, 5);

        path.injectPoints(1);

        List<PathPoint> points = path.getPoints();
        for (int i = 0; i < points.size() - 2; i++) {
            assertEquals(1, PathPoint.getDistance(points.get(i), points.get(i + 1)), 0.01);
        }
    }

    @Test
    void injectPoints_DefaultSpacing_AllPointsThere() {
        // Linear system of y = x
        path.addPoint(0, 0);
        path.addPoint(5, 5);

        path.injectPoints();

        List<PathPoint> points = path.getPoints();
        // 2 cause last point will be closer (or very *maybe* equal) than spacing
        for (int i = 0; i < points.size() - 2; i++) {
            assertEquals(0.15, PathPoint.getDistance(points.get(i), points.get(i + 1)), 0.01);
        }
    }
}
