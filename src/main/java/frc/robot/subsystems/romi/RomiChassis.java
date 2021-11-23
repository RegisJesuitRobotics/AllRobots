package frc.robot.subsystems.romi;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.IChassis;

public class RomiChassis extends SubsystemBase implements IChassis {

    // The Romi has the left and right motors set to
    // PWM channels 0 and 1 respectively
    private final Spark leftMotor = new Spark(RomiConstants.LEFT_MOTOR_PORT);
    private final Spark rightMotor = new Spark(RomiConstants.RIGHT_MOTOR_PORT);

    // Set up the differential drive controller
    private final DifferentialDrive diffDrive = new DifferentialDrive(leftMotor, rightMotor);

    @Override
    public void initialize() {
        // diffDrive.setSafetyEnabled(false);
        // diffDrive.setExpiration(0.5);
    }

    @Override
    public void drive(double speed, double rot) {
        diffDrive.arcadeDrive(speed, rot);
    }
}
