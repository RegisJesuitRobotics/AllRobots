package frc.robot.subsystems.vex;

import edu.wpi.first.wpilibj.controller.PIDController;
import frc.robot.sensors.AbsWheelEncoders;
import frc.robot.sensors.IGyro;
import frc.robot.subsystems.IChassis;
import frc.robot.subsystems.IDriver;
import frc.robot.subsystems.ISubsystems;
import frc.robot.subsystems.driver.DriverXbox360;

public class VexSubsystems implements ISubsystems {

    private final VexChassis chassis = new VexChassis();

    private final DriverXbox360 driver = new DriverXbox360();

    private final VexWheelEncoders wheelEncoders =
            new VexWheelEncoders(
                    new VexEncoder(VexConstants.LEFT_ENCODER_PORT, VexConstants.DISTANCE_PER_PULSE),
                    new VexEncoder(
                            VexConstants.RIGHT_ENCODER_PORT, VexConstants.DISTANCE_PER_PULSE));

    private final PIDController pidDriveWithGyro =
            new PIDController(VexConstants.kP, VexConstants.kI, VexConstants.kD);

    private final VexGyro gyro = new VexGyro();

    @Override
    public void initialize() {
        gyro.calibrate();
    }

    @Override
    public IChassis getChassis() {
        return chassis;
    }

    @Override
    public IDriver getDriver() {
        return driver;
    }

    @Override
    public AbsWheelEncoders getWheelEncoders() {
        return wheelEncoders;
    }

    @Override
    public IGyro getGyro() {
        return gyro;
    }

    @Override
    public PIDController getPidDriveWithGyro() {
        return pidDriveWithGyro;
    }
}
