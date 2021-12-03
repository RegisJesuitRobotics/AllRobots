package frc.robot.subsystems.simulation;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.simulation.ADXRS450_GyroSim;
import frc.robot.sensors.IGyro;

public class SimulationGyro implements IGyro {

    private final ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    private final ADXRS450_GyroSim gyroSim = new ADXRS450_GyroSim(gyro);

    @Override
    public void reset() {
        gyro.reset();
    }

    @Override
    public double getAngleZ() {
        return gyro.getAngle();
    }

    public void updateSimulation(double angle) {
        gyroSim.setAngle(angle);
    }
}
