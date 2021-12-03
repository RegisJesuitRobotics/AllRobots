package frc.robot.purepursuit;

import static frc.robot.utils.math.MathUtils.sqr;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.utils.math.MathUtils;
import frc.robot.utils.math.Point2d;
import java.util.List;

public class PurePursuit {

    private final PurePursuitPath path;
    private final double lookaheadDistance;
    private final double trackWidthMeters;
    private Pose2d currentPosition;
    private int closestPointIndex = 0;
    private double lookaheadFractionalIndex = 0;
    private final Point2d lookaheadPoint = new Point2d(0, 0);
    private double lookaheadCurvature = 0;

    /**
     * @param path              The path to follow
     * @param lookaheadDistance the lookahead distance (m)
     * @param trackWidthMeters  trackWidth of the robot in meters
     */
    public PurePursuit(PurePursuitPath path, double lookaheadDistance, double trackWidthMeters) {
        this.path = path;
        this.lookaheadDistance = lookaheadDistance;
        this.trackWidthMeters = trackWidthMeters;
    }

    private void updateClosestPointIndex() {
        List<PathPoint> points = path.getPoints();
        double closestDistance = Double.POSITIVE_INFINITY;
        for (int i = closestPointIndex; i < points.size(); i++) {
            double distance = PathPoint.distancePose2d(points.get(i), currentPosition);
            if (distance <= closestDistance) {
                closestDistance = distance;
                closestPointIndex = i;
            }
        }
        SmartDashboard.putNumber("Closest point", closestPointIndex);
    }

    private void updateLookaheadIndex() {
        List<PathPoint> points = path.getPoints();
        Point2d currentPositionPoint = new Point2d(currentPosition.getX(), currentPosition.getY());
        for (int i = (int) lookaheadFractionalIndex; i < points.size() - 1; i++) {
            PathPoint currentPoint = points.get(i);
            PathPoint nextPoint = points.get(i + 1);
            double intersection = MathUtils.circleIntersectionWithLine(currentPoint.getPoint(), nextPoint.getPoint(),
                    currentPositionPoint, lookaheadDistance);

            if (intersection >= 0) {
                // We don't want to go backwards
                if (i + intersection < lookaheadFractionalIndex) {
                    continue;
                }
                lookaheadFractionalIndex = i + intersection;
                double xDistance = nextPoint.getX() - currentPoint.getX();
                double yDistance = nextPoint.getY() - currentPoint.getY();

                lookaheadPoint.x = currentPoint.getX() + xDistance * intersection;
                lookaheadPoint.y = currentPoint.getY() + yDistance * intersection;
                break;
            }
        }

        SmartDashboard.putNumber("Lookahead Index", lookaheadFractionalIndex);
    }

    private void updateLookaheadCurvature() {
        double a = -currentPosition.getRotation().getTan();
        double c = currentPosition.getRotation().getTan() * currentPosition.getX() - currentPosition.getY();

        lookaheadCurvature = 2 * ((a * lookaheadPoint.x + lookaheadPoint.y + c) / MathUtils.distanceFormula(a, 1))
                / sqr(Point2d.distance(new Point2d(currentPosition), lookaheadPoint));

        lookaheadCurvature *= Math
                .signum(currentPosition.getRotation().getSin() * (lookaheadPoint.x - currentPosition.getX())
                        - currentPosition.getRotation().getCos() * (lookaheadPoint.y - currentPosition.getY()));

        SmartDashboard.putNumber("Lookahead curvature", lookaheadCurvature);
    }

    public DifferentialDriveWheelSpeeds calculate(Pose2d currentPosition) {
        this.currentPosition = currentPosition;

        updateClosestPointIndex();
        updateLookaheadIndex();
        updateLookaheadCurvature();

        double pointTargetVelocity = path.getPoints().get(closestPointIndex).getVelocity();
        SmartDashboard.putNumber("Point Target Velocity", pointTargetVelocity);

        double leftSpeed = pointTargetVelocity * (2 - lookaheadCurvature * trackWidthMeters) / 2;
        double rightSpeed = pointTargetVelocity * (2 + lookaheadCurvature * trackWidthMeters) / 2;

        return new DifferentialDriveWheelSpeeds(leftSpeed, rightSpeed);
    }


    public boolean isDone() {
        return closestPointIndex == path.getSize() - 1;
    }

}
