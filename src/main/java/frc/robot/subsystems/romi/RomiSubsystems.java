package frc.robot.subsystems.romi;

import edu.wpi.first.wpilibj.controller.PIDController;
import frc.robot.sensors.AbsWheelEncoders;
import frc.robot.sensors.IGyro;
import frc.robot.subsystems.IChassis;
import frc.robot.subsystems.IDriver;
import frc.robot.subsystems.ISubsystems;
import frc.robot.subsystems.driver.DriverXbox360;

public class RomiSubsystems implements ISubsystems {

    private final RomiChassis chassis = new RomiChassis();

    private final DriverXbox360 driver = new DriverXbox360();

    private final RomiWheelEncoders encoders =
            new RomiWheelEncoders(
                    new RomiEncoder(
                            RomiConstants.LEFT_ENCODER_PORT1,
                            RomiConstants.LEFT_ENCODER_PORT2,
                            RomiConstants.DISTANCE_PER_PULSE),
                    new RomiEncoder(
                            RomiConstants.RIGHT_ENCODER_PORT1,
                            RomiConstants.RIGHT_ENCODER_PORT2,
                            RomiConstants.DISTANCE_PER_PULSE));

    private final RomiGyro gyro = new RomiGyro();

    private final PIDController pidDriveWithGyro =
            new PIDController(RomiConstants.kP, RomiConstants.kI, RomiConstants.kD);

    @Override
    public void initialize() {
    }
        
    @Override
    public IChassis getChassis() {
        return chassis;
    }

    @Override
    public IDriver getDriver() {
        return driver;
    }

    @Override
    public AbsWheelEncoders getWheelEncoders() {
        return encoders;
    }

    @Override
    public IGyro getGyro() {
        return gyro;
    }

    @Override
    public PIDController getPidDriveWithGyro() {
        return pidDriveWithGyro;
    }
}
