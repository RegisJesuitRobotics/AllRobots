package frc.robot.subsystems;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.sensors.AbsWheelEncoders;
import frc.robot.sensors.IGyro;

public abstract class Chassis extends SubsystemBase {
    protected DifferentialDriveOdometry odometry;
    protected Field2d field2d;
    protected IGyro gyro;
    protected AbsWheelEncoders encoders;

    protected Chassis(IGyro gyro, AbsWheelEncoders encoders) {
        this.gyro = gyro;
        this.encoders = encoders;
        field2d = new Field2d();

        SmartDashboard.putData(field2d);
        initializeOdometry();
    }

    protected void initializeOdometry() {
        odometry = new DifferentialDriveOdometry(gyro.getRotation2d());
    }

    public abstract void drive(double speed, double rot);

    public abstract void tankDrive(double leftSpeed, double rightSpeed);

    @Override
    public void periodic() {
        odometry.update(gyro.getRotation2d(), encoders.getLeftDistance(), encoders.getRightDistance());

        field2d.setRobotPose(odometry.getPoseMeters());
    }

    public Pose2d getPosition() {
        return odometry.getPoseMeters();
    }
}
