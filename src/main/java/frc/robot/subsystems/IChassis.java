package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;

public interface IChassis extends Subsystem {
    public void initialize();

    public void drive(double speed, double rot);
}
