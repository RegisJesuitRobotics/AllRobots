package frc.robot.subsystems.vex;

public class VexConstants {

    private VexConstants() {}

    // Motors
    public static int LEFT_MOTOR_PORT = 0;
    public static int RIGHT_MOTOR_PORT = 1;

    // Encoders
    public static int LEFT_ENCODER_PORT = 9;
    public static int RIGHT_ENCODER_PORT = 8;

    public static double WHEEL_DIAMETER = 4;
    public static double COUNTS_PER_REVOLUTION = 200;
    public static double DISTANCE_PER_PULSE = (Math.PI * WHEEL_DIAMETER) / COUNTS_PER_REVOLUTION;
}
