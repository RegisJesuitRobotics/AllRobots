package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;

public interface IShooter extends Subsystem {
    
    public void initialize();

    public void turnOn();

    public void turnOff();
}
