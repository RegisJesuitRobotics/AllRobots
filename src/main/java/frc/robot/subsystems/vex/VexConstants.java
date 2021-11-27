package frc.robot.subsystems.vex;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.util.Units;

public class VexConstants {

    private VexConstants() {}

    // Motors
    public static int LEFT_MOTOR_PORT = 0;
    public static int RIGHT_MOTOR_PORT = 1;

    // Encoders
    public static int LEFT_ENCODER_PORT = 9;
    public static int RIGHT_ENCODER_PORT = 8;

    public static double WHEEL_DIAMETER_METERS = Units.inchesToMeters(4);
    public static double COUNTS_PER_REVOLUTION = 325;
    public static double DISTANCE_PER_PULSE =
            (Math.PI * WHEEL_DIAMETER_METERS) / COUNTS_PER_REVOLUTION;

    public static final SPI.Port GyroPort = SPI.Port.kOnboardCS0;

    public static double kP = 0.4;
    public static double kI = 0.0;
    public static double kD = 0.0;
}
