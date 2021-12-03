package frc.robot.subsystems.romi;

import frc.robot.sensors.AbsWheelEncoders;
import frc.robot.sensors.IGyro;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.IDriver;
import frc.robot.subsystems.ISubsystems;
import frc.robot.subsystems.driver.DriverXbox360;

public class RomiSubsystems implements ISubsystems {

    private final DriverXbox360 driver = new DriverXbox360();

    private final RomiWheelEncoders encoders = new RomiWheelEncoders(
            new RomiEncoder(RomiConstants.LEFT_ENCODER_PORT1, RomiConstants.LEFT_ENCODER_PORT2,
                    RomiConstants.DISTANCE_PER_PULSE),
            new RomiEncoder(RomiConstants.RIGHT_ENCODER_PORT1, RomiConstants.RIGHT_ENCODER_PORT2,
                    RomiConstants.DISTANCE_PER_PULSE));

    private final RomiGyro gyro = new RomiGyro();

    private final RomiChassis chassis = new RomiChassis(gyro, encoders);

    @Override
    public Chassis getChassis() {
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
}
