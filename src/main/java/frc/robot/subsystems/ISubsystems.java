package frc.robot.subsystems;

import frc.robot.sensors.AbsWheelEncoders;

public interface ISubsystems {
    public IChassis getChassis();

    public IDriver getDriver();

    public AbsWheelEncoders getWheelEncoders();
}
