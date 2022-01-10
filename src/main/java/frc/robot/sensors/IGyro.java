package frc.robot.sensors;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj2.command.Subsystem;

public interface IGyro extends Sendable, Subsystem {
    public void calibrate();

    public void reset();

    public double getAngleZ();
}
