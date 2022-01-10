package frc.robot.subsystems.driver;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.IDriver;

public class DriverXbox360 implements IDriver {

    private final XboxController joy = new XboxController(0);

    @Override
    public double getX() {
        return joy.getLeftX();
    }

    @Override
    public double getY() {
        return -joy.getLeftY();
    }
}
