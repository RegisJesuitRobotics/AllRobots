package frc.robot.subsystems.romi;

import edu.wpi.first.wpilibj.Servo;
import frc.robot.subsystems.IShooter;

public class RomiShooter implements IShooter {

    private final Servo servo = new Servo(RomiConstants.SERVO_SHOOTER_PORT);

    @Override
    public void initialize() {
        // System.out.println("In servo initialize");
        servo.set(0.0);
    }

    @Override
    public void turnOn() {
        // System.out.println("In servo turnOn");
        servo.set(1.0);
    }

    @Override
    public void turnOff() {
        // System.out.println("In servo turnOff");
        servo.set(0.0);
    }
    
}
