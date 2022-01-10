// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.IChassis;
import java.util.Set;

public class DriveTime implements Command {
    private final double duration;
    private final double speed;
    private final IChassis drive;
    private long startTime;

    /**
     * Creates a new DriveTime. This command will drive your robot for a desired
     * speed and time.
     *
     * @param speed The speed which the robot will drive. Negative is in reverse.
     * @param time  How much time to drive in seconds
     * @param drive The drivetrain subsystem on which this command will run
     */
    public DriveTime(double speed, double time, IChassis drive) {
        this.speed = speed;
        duration = time * 1000;
        this.drive = drive;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        startTime = System.currentTimeMillis();
        drive.drive(0, 0);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        drive.drive(speed, 0);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        drive.drive(0, 0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return (System.currentTimeMillis() - startTime) >= duration;
    }

    @Override
    public Set<Subsystem> getRequirements() {
        return Set.of(drive);
    }
}
