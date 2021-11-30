package frc.robot.subsystems.vex;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.util.Units;
import frc.robot.subsystems.IConstants;

public class VexConstants implements IConstants {

    // Motors
    public static final int LEFT_MOTOR_PORT = 0;
    public static final int RIGHT_MOTOR_PORT = 1;

    // Encoders
    public static final int LEFT_ENCODER_PORT = 9;
    public static final int RIGHT_ENCODER_PORT = 8;

    public static final double WHEEL_DIAMETER_METERS = Units.inchesToMeters(4);
    public static final double COUNTS_PER_REVOLUTION = 175;
    public static final double DISTANCE_PER_PULSE =
            (Math.PI * WHEEL_DIAMETER_METERS) / COUNTS_PER_REVOLUTION;

    public static final SPI.Port GyroPort = SPI.Port.kOnboardCS0;

    private final double driveKp = 0.4;
    private final double driveKi = 0.0;
    private final double driveKd = 0.0;
    private final double autoDriveSpeed = 0.9;

    @Override
    public double getDriveKp() {
        return driveKp;
    }

    @Override
    public double getDriveKi() {
        return driveKi;
    }

    @Override
    public double getDriveKd() {
        return driveKd;
    }

    @Override
    public double getAutoDriveSpeed() {
        return autoDriveSpeed;
    }
}
