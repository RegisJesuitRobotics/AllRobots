package frc.robot.subsystems.romi;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.sensors.AbsWheelEncoders;
import frc.robot.sensors.IGyro;
import frc.robot.subsystems.Chassis;

public class RomiChassis extends Chassis {

    // The Romi has the left and right motors set to
    // PWM channels 0 and 1 respectively
    private final Spark leftMotor = new Spark(RomiConstants.LEFT_MOTOR_PORT);
    private final Spark rightMotor = new Spark(RomiConstants.RIGHT_MOTOR_PORT);

    // Set up the differential drive controller
    private final DifferentialDrive diffDrive = new DifferentialDrive(leftMotor, rightMotor);

    protected RomiChassis(IGyro gyro, AbsWheelEncoders encoders) {
        super(gyro, encoders);
    }

    @Override
    public void drive(double speed, double rot) {
        diffDrive.arcadeDrive(speed, rot);
    }

    @Override
    public void tankDrive(double leftSpeed, double rightSpeed) {
        diffDrive.tankDrive(leftSpeed, rightSpeed);
    }
}
