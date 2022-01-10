package frc.robot.subsystems.vex;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.sensors.IGyro;

public class VexGyro implements IGyro {

    private final ADXRS450_Gyro gyro;

    public VexGyro() {
        gyro = new ADXRS450_Gyro(VexConstants.GyroPort);
    }

    @Override
    public void calibrate() {
        gyro.calibrate();
    }

    @Override
    public void reset() {
        gyro.reset();
    }

    @Override
    public double getAngleZ() {
        double angle = gyro.getAngle();
        SmartDashboard.putString("Gyro", String.format("%.3f", angle));
        return angle;
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        // builder.setSmartDashboardType("Gyro");
        // builder.addDoubleProperty("Value", gyro::getAngle, null);
    }
}
