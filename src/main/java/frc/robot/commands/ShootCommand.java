package frc.robot.commands;

import java.util.Set;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.IShooter;

public class ShootCommand implements Command {

    private final IShooter shooter;
    private long startTime;

    public ShootCommand(IShooter shooter) {
        this.shooter = shooter;
    }

    @Override
    public Set<Subsystem> getRequirements() {
        return Set.of(shooter);
    }

    @Override
    public void initialize() {
        // System.out.println("In ShootCommand initialize");
        shooter.initialize();
        shooter.turnOn();
        startTime = System.currentTimeMillis();
    }

    @Override
    public void execute() {
        // System.out.println("In ShootCommand execute");
    }

    @Override
    public boolean isFinished() {
        return (System.currentTimeMillis() - startTime) >= 2000;
    }

    @Override
    public void end(boolean interrupted) {
        // System.out.println("In ShootCommand end");
        shooter.turnOff();
    }
    
}
