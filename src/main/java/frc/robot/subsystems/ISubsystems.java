package frc.robot.subsystems;

import edu.wpi.first.wpilibj.controller.PIDController;
import frc.robot.sensors.AbsWheelEncoders;
import frc.robot.sensors.IGyro;

public interface ISubsystems {

    // For any systems like gyros that need to be initialized.
    public void initialize();

    public IChassis getChassis();

    public IDriver getDriver();

    public AbsWheelEncoders getWheelEncoders();

    public IGyro getGyro();

    public PIDController getPidDriveWithGyro();
}
