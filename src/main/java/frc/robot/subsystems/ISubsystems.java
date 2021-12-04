package frc.robot.subsystems;

import frc.robot.sensors.AbsWheelEncoders;
import frc.robot.sensors.IGyro;

public interface ISubsystems {
    public Chassis getChassis();

    public IDriver getDriver();

    public AbsWheelEncoders getWheelEncoders();

    public IGyro getGyro();
}
