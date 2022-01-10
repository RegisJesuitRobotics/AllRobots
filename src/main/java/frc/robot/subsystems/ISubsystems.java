package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.sensors.AbsWheelEncoders;
import frc.robot.sensors.IGyro;

public interface ISubsystems extends Subsystem {

    // For any systems like gyros that need to be initialized.
    public void initialize();

    public IChassis getChassis();

    public IDriver getDriver();

    public AbsWheelEncoders getWheelEncoders();

    public IGyro getGyro();

    public IConstants getConstants();
}
