package frc.robot.commands;

import java.util.Set;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.ISubsystems;

public class DriveDistancePidCommand implements Command {

    private final ISubsystems subsystems;

    public DriveDistancePidCommand(ISubsystems subsystems) {
        this.subsystems = subsystems;
    }

    @Override
    public Set<Subsystem> getRequirements() {
        return Set.of(subsystems.getChassis(), subsystems.getGyro(), subsystems.getWheelEncoders());
    }
}
