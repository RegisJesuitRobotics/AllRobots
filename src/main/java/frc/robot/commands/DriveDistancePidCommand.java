package frc.robot.commands;

import java.util.Set;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.sensors.AbsWheelEncoders;
import frc.robot.sensors.IGyro;
import frc.robot.subsystems.IChassis;
import frc.robot.subsystems.IConstants;
import frc.robot.subsystems.ISubsystems;

public class DriveDistancePidCommand implements Command {

    private final double speed;
    private final double distanceMeters;
    private final AbsWheelEncoders encoders;
    private final IGyro gyro;
    private final PIDController pidController;
    private final IConstants constants;
    private final IChassis chassis;

    public DriveDistancePidCommand(double distanceMeters, ISubsystems subsystems) {

        this.distanceMeters = distanceMeters;
        this.encoders = subsystems.getWheelEncoders();
        this.gyro = subsystems.getGyro();
        this.constants = subsystems.getConstants();
        this.chassis = subsystems.getChassis();
        this.speed = constants.getAutoDriveSpeed();

        pidController = new PIDController(constants.getDriveKp(), constants.getDriveKi(), constants.getDriveKd());
    }

    @Override
    public Set<Subsystem> getRequirements() {
        return Set.of(chassis, gyro, encoders);
    }

    @Override
    public void initialize() {
        chassis.drive(0, 0);
        encoders.reset();
        gyro.reset();
    }

    @Override
    public void execute() {
        SmartDashboard.putData(gyro);
        chassis.drive(speed, getRotationPidController());
    }

    @Override
    public boolean isFinished() {
        double distanceTravelled = Math.abs(encoders.getAverageDistance());

        SmartDashboard.putString("Avg Dist", String.format("%.3f", distanceTravelled));

        return distanceTravelled >= distanceMeters;
    }

    @Override
    public void end(boolean interrupted) {
        chassis.drive(0, 0);
    }

    private double getRotationPidController() {
        double angle = gyro.getAngleZ();
        double rotation = pidController.calculate(angle);

        // SmartDashboard.putString("PidController", String.format("angle: %.3f
        // rotation: %.3f",
        // angle, rotation));
        SmartDashboard.putString("PidController", String.format("rotation: %.3f", rotation));

        return rotation;
    }
}
