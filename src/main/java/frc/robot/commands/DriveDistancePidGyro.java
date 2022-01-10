// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.sensors.AbsWheelEncoders;
import frc.robot.sensors.IGyro;
import frc.robot.subsystems.IChassis;

public class DriveDistancePidGyro extends CommandBase {

    private final double speed;
    private final IChassis chassis;
    private final double distance;
    private final AbsWheelEncoders encoders;
    private final IGyro gyro;
    private final PIDController pidController;

    /** Creates a new DriveDistance. */
    public DriveDistancePidGyro(
            double speed,
            double distanceMeters,
            IChassis chassis,
            AbsWheelEncoders encoders,
            IGyro gyro,
            PIDController pidController) {
        this.speed = speed;
        this.distance = distanceMeters;
        this.chassis = chassis;
        this.encoders = encoders;
        this.gyro = gyro;
        this.pidController = pidController;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(chassis);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        chassis.drive(0, 0);
        encoders.reset();
        gyro.reset();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        SmartDashboard.putData(gyro);
        chassis.drive(speed, getRotationPidController());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        chassis.drive(0, 0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        double distanceTravelled = Math.abs(encoders.getAverageDistance());

        SmartDashboard.putString("Avg Dist", String.format("%.3f", distanceTravelled));

        return distanceTravelled >= distance;
    }

    private double getRotationPidController() {
        double angle = gyro.getAngleZ();
        double rotation = pidController.calculate(angle);

        // SmartDashboard.putString("PidController", String.format("angle: %.3f rotation: %.3f",
        // angle, rotation));
        SmartDashboard.putString("PidController", String.format("rotation: %.3f", rotation));

        return rotation;
    }
}
