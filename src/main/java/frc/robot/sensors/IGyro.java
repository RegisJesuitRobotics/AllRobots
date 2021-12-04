package frc.robot.sensors;

import edu.wpi.first.wpilibj.geometry.Rotation2d;

public interface IGyro {
    public void reset();

    public double getAngleZ();

    public default Rotation2d getRotation2d() {
        return Rotation2d.fromDegrees(-getAngleZ());
    }
}
