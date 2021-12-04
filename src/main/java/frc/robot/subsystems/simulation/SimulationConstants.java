package frc.robot.subsystems.simulation;

import edu.wpi.first.wpilibj.util.Units;

public class SimulationConstants {
    private SimulationConstants() {}

    public static int LEFT_MOTOR_PORT = 1;
    public static int RIGHT_MOTOR_PORT = 2;
    public static int[] LEFT_ENCODER_PORTS = new int[]{ 6, 7 };
    public static int[] RIGHT_ENCODER_PORTS = new int[]{ 8, 9 };

    public static double TRACK_WIDTH = Units.inchesToMeters(26);

    public static double GEARING = 10.71;
    public static double WHEEL_DIAMETER_METERS = Units.inchesToMeters(6);

    public static final double DISTANCE_PER_PULSE = (Math.PI * WHEEL_DIAMETER_METERS) / GEARING;
}
