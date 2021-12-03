package frc.robot.subsystems.vex;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.sensors.AbsWheelEncoders;
import frc.robot.sensors.IGyro;
import frc.robot.subsystems.Chassis;

public class VexChassis extends Chassis {
    private final Spark leftMotor;
    private final Spark rightMotor;
    private final DifferentialDrive drive;

    public VexChassis(IGyro gyro, AbsWheelEncoders encoders) {
        super(gyro, encoders);
        leftMotor = new Spark(VexConstants.LEFT_MOTOR_PORT);
        rightMotor = new Spark(VexConstants.RIGHT_MOTOR_PORT);

        drive = new DifferentialDrive(leftMotor, rightMotor);

        drive.setSafetyEnabled(false);
        drive.setExpiration(0.5);
    }

    @Override
    public void drive(double speed, double rot) {
        drive.arcadeDrive(speed, -rot);
    }

    @Override
    public void tankDrive(double leftSpeed, double rightSpeed) {
        drive.tankDrive(leftSpeed, rightSpeed);
    }
}
