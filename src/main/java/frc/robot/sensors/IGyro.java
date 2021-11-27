package frc.robot.sensors;

import edu.wpi.first.wpilibj.Sendable;

public interface IGyro {
    public void calibrate();

    public void reset();

    public double getAngleZ();
}
