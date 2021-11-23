package frc.robot.subsystems.romi;

public class RomiConstants {

    private RomiConstants() {}

    public static final int LEFT_MOTOR_PORT = 0;
    public static final int RIGHT_MOTOR_PORT = 1;

    public static final int LEFT_ENCODER_PORT1 = 4;
    public static final int LEFT_ENCODER_PORT2 = 5;
    public static final int RIGHT_ENCODER_PORT1 = 6;
    public static final int RIGHT_ENCODER_PORT2 = 7;

    private static final double kCountsPerRevolution = 1440.0;
    private static final double kWheelDiameterInch = 2.75591; // 70 mm

    public static final double DISTANCE_PER_PULSE =
            (Math.PI * kWheelDiameterInch) / kCountsPerRevolution;
}
