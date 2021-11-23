// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.sensors.AbsWheelEncoders;
import frc.robot.subsystems.IChassis;

public class DriveDistance extends CommandBase {

    private final double speed;
    private final IChassis chassis;
    private final double distance;
    private final AbsWheelEncoders encoders;

    /** Creates a new DriveDistance. */
    public DriveDistance(
            double speed, double distance, IChassis chassis, AbsWheelEncoders encoders) {
        this.speed = speed;
        this.distance = distance;
        this.chassis = chassis;
        this.encoders = encoders;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(chassis);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        chassis.drive(0, 0);
        encoders.reset();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        chassis.drive(speed, 0);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        chassis.drive(0, 0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return Math.abs(encoders.getAverageDistance()) >= distance;
    }
}
