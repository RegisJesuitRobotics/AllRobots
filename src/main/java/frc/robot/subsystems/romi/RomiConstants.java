package frc.robot.subsystems.romi;

import frc.robot.subsystems.IConstants;

public class RomiConstants implements IConstants {

    RomiConstants() {}

    public static final int LEFT_MOTOR_PORT = 0;
    public static final int RIGHT_MOTOR_PORT = 1;

    public static final int LEFT_ENCODER_PORT1 = 4;
    public static final int LEFT_ENCODER_PORT2 = 5;
    public static final int RIGHT_ENCODER_PORT1 = 6;
    public static final int RIGHT_ENCODER_PORT2 = 7;

    private static final double COUNTS_PER_REVOLUTION = 1440.0;
    private static final double WHEEL_DIAMETER_METERS = 0.07; // 70 mm

    public static final double DISTANCE_PER_PULSE = (Math.PI * WHEEL_DIAMETER_METERS) / COUNTS_PER_REVOLUTION;

    private final double driveKp = 0.1;
    private final double driveKi = 0.0;
    private final double driveKd = 0.0;
    private final double autoDriveSpeed = 0.6;

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
