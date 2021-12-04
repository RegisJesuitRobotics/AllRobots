package frc.robot.subsystems.simulation;

import frc.robot.sensors.AbsWheelEncoders;
import frc.robot.sensors.IGyro;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.IDriver;
import frc.robot.subsystems.ISubsystems;
import frc.robot.subsystems.driver.DriverXbox360;

public class SimulationSubsystems implements ISubsystems {

    private final SimulationWheelEncoders encoders = new SimulationWheelEncoders(
            new SimulationEncoder(SimulationConstants.LEFT_ENCODER_PORTS),
            new SimulationEncoder(SimulationConstants.RIGHT_ENCODER_PORTS));
    private final SimulationGyro gyro = new SimulationGyro();
    private final SimulationChassis chassis = new SimulationChassis(encoders, gyro);
    private final DriverXbox360 driverXbox360 = new DriverXbox360();

    @Override
    public Chassis getChassis() {
        return chassis;
    }

    @Override
    public IDriver getDriver() {
        return driverXbox360;
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
