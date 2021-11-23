package frc.robot.subsystems.driver;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.subsystems.IDriver;

public class DriverXbox360 implements IDriver {

    private final Joystick joy = new Joystick(0);

    @Override
    public double getX() {
        return joy.getX(Hand.kLeft);
    }

    @Override
    public double getY() {
        return joy.getY(Hand.kLeft);
    }
    
}
