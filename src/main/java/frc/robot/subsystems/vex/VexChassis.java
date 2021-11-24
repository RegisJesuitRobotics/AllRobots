package frc.robot.subsystems.vex;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.IChassis;

public class VexChassis extends SubsystemBase implements IChassis {
    private final Spark leftMotor;
    private final Spark rightMotor;
    private final DifferentialDrive drive;

    public VexChassis() {
        leftMotor = new Spark(VexConstants.LEFT_MOTOR_PORT);
        rightMotor = new Spark(VexConstants.RIGHT_MOTOR_PORT);

        drive = new DifferentialDrive(leftMotor, rightMotor);
    }
    
    @Override
    public void initialize() {
        drive.setSafetyEnabled(false);
        drive.setExpiration(0.5);
    }

    @Override
    public void drive(double speed, double rot) {
        drive.arcadeDrive(speed, -rot);
    }
}
