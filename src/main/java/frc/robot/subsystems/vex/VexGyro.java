package frc.robot.subsystems.vex;

import edu.wpi.first.wpilibj.AnalogGyro;
import frc.robot.sensors.IGyro;

public class VexGyro implements IGyro {

    private final AnalogGyro gyro;

    public VexGyro() {
        gyro = new AnalogGyro(VexConstants.GyroPort);
    }

    @Override
    public void reset() {
        gyro.reset();
    }

    @Override
    public double getAngleZ() {
        return gyro.getAngle();
    }
    
}
