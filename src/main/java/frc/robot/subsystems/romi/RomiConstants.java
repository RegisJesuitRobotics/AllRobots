package frc.robot.subsystems.romi;

public class RomiConstants {

    private RomiConstants() {}

    public static final int LEFT_MOTOR_PORT = 0;
    public static final int RIGHT_MOTOR_PORT = 1;

    public static final int LEFT_ENCODER_PORT1 = 4;
    public static final int LEFT_ENCODER_PORT2 = 5;
    public static final int RIGHT_ENCODER_PORT1 = 6;
    public static final int RIGHT_ENCODER_PORT2 = 7;

    private static final double COUNTS_PER_REVOLUTION = 1440.0;
    private static final double WHEEL_DIAMETER_METERS = 0.07; // 70 mm

    public static final double DISTANCE_PER_PULSE =
            (Math.PI * WHEEL_DIAMETER_METERS) / COUNTS_PER_REVOLUTION;

    public static double kP = 0.1;
    public static double kI = 0.0;
    public static double kD = 0.0;
}
