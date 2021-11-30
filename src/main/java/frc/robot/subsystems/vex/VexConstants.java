package frc.robot.subsystems.vex;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.util.Units;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VexConstants {

    // Motors
    public final int LEFT_MOTOR_PORT = 0;
    public final int RIGHT_MOTOR_PORT = 1;

    // Encoders
    public final int LEFT_ENCODER_PORT = 9;
    public final int RIGHT_ENCODER_PORT = 8;

    public final double WHEEL_DIAMETER_METERS = Units.inchesToMeters(4);
    public final double COUNTS_PER_REVOLUTION = 325;
    public final double DISTANCE_PER_PULSE =
            (Math.PI * WHEEL_DIAMETER_METERS) / COUNTS_PER_REVOLUTION;

    public final SPI.Port GyroPort = SPI.Port.kOnboardCS0;

    public final double kP = 0.4;
    public final double kI = 0.0;
    public final double kD = 0.0;
}
