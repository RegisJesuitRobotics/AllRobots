package frc.robot.commands;

import com.regisjesuit.purepursuit.PurePursuit;
import com.regisjesuit.purepursuit.path.PathPoint;
import com.regisjesuit.purepursuit.path.PurePursuitPath;
import edu.wpi.first.wpilibj.SlewRateLimiter;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Units;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.sensors.AbsWheelEncoders;
import frc.robot.subsystems.Chassis;


public class PurePursuitCommand extends CommandBase {

    private final Chassis chassis;
    private final AbsWheelEncoders encoders;
    private final PurePursuit purePursuit;
    private final SlewRateLimiter leftRateLimiter;
    private final SlewRateLimiter rightRateLimiter;

    private final double KV = 0.355;
    private final double KA = 0.002;
    private final double KP = 0.01;

    private final double MAX_VELOCITY = 2;

    public PurePursuitCommand(Chassis chassis, AbsWheelEncoders encoders) {
        this.chassis = chassis;
        this.encoders = encoders;
        // each subsystem used by the command must be passed into the addRequirements()
        // method (which takes a vararg of Subsystem)
        addRequirements(chassis);
        PurePursuitPath path = new PurePursuitPath(MAX_VELOCITY);
        path.addPoint(0, 0);
        path.addPoint(1, 0.1);
        path.addPoint(2.5, 0.5);
        path.addPoint(4, 4);
        path.addPoint(5.5, 6.2);
        path.addPoint(7.5, 4.5);
        path.addPoint(9, 1);
        path.addPoint(11.4, 0.2);
        path.addPoint(15.9766, 7.8994);
//        path.addPoint(10, 0);

        path.injectPoints();
        path.smoothPoints(0.3, 0.7, 0.001);

        path.calculateCurvatures();
        path.calculateMaxVelocities(5);
        path.calculateVelocities(MAX_VELOCITY);

        for (PathPoint point : path.getPoints()) {
            System.out.println(point);
        }

        purePursuit = new PurePursuit(path, 1, Units.inchesToMeters(26));
        SmartDashboard.putData("Pure Pursuit", purePursuit);
        leftRateLimiter = new SlewRateLimiter(MAX_VELOCITY);
        rightRateLimiter = new SlewRateLimiter(MAX_VELOCITY);

    }

    /**
     * The initial subroutine of a command. Called once when the command is
     * initially scheduled.
     */
    @Override
    public void initialize() {

    }

    /**
     * The main body of a command. Called repeatedly while the command is scheduled.
     * (That is, it is called repeatedly until {@link #isFinished()}) returns true.)
     */
    @Override
    public void execute() {
        DifferentialDriveWheelSpeeds speeds = purePursuit.calculate(chassis.getPosition());

        speeds.leftMetersPerSecond = leftRateLimiter.calculate(speeds.leftMetersPerSecond);
        speeds.rightMetersPerSecond = rightRateLimiter.calculate(speeds.rightMetersPerSecond);

        SmartDashboard.putNumber("Target Left", speeds.leftMetersPerSecond);
        SmartDashboard.putNumber("Target right", speeds.rightMetersPerSecond);
        SmartDashboard.putNumber("Actual Left", encoders.getLeftRate());
        SmartDashboard.putNumber("Actual Right", encoders.getRightRate());

        double leftFeedback = KP * (speeds.leftMetersPerSecond - encoders.getLeftRate());
        double rightFeedback = KP * (speeds.rightMetersPerSecond - encoders.getRightRate());

        double leftFeedforward = KV * speeds.leftMetersPerSecond
                + KA * getAccel(speeds.leftMetersPerSecond, encoders.getLeftRate());
        double rightFeedforward = KV * speeds.rightMetersPerSecond
                + KA * getAccel(speeds.rightMetersPerSecond, encoders.getRightRate());

        chassis.tankDrive(leftFeedforward + leftFeedback, rightFeedforward + rightFeedback);
    }

    private double getAccel(double targetVel, double actualVel) {
        return MathUtil.clamp((targetVel - actualVel) / 0.02, -0.625, 0.625);
    }

    /**
     * <p>
     * Returns whether this command has finished. Once a command finishes --
     * indicated by this method returning true -- the scheduler will call its
     * {@link #end(boolean)} method.
     * </p>
     * <p>
     * Returning false will result in the command never ending automatically. It may
     * still be cancelled manually or interrupted by another command. Hard coding
     * this command to always return true will result in the command executing once
     * and finishing immediately. It is recommended to use *
     * {@link edu.wpi.first.wpilibj2.command.InstantCommand InstantCommand} for such
     * an operation.
     * </p>
     *
     * @return whether this command has finished.
     */
    @Override
    public boolean isFinished() {
        return purePursuit.isDone();
    }

    /**
     * The action to take when the command ends. Called when either the command
     * finishes normally -- that is it is called when {@link #isFinished()} returns
     * true -- or when it is interrupted/canceled. This is where you may want to
     * wrap up loose ends, like shutting off a motor that was being used in the
     * command.
     *
     * @param interrupted whether the command was interrupted/canceled
     */
    @Override
    public void end(boolean interrupted) {
        chassis.tankDrive(0, 0);
    }
}
