package frc.robot.sensors;

import edu.wpi.first.wpilibj2.command.Subsystem;

public abstract class AbsWheelEncoders implements Subsystem {
    private final IEncoder leftEncoder;
    private final IEncoder rightEncoder;

    public AbsWheelEncoders(IEncoder leftEncoder, IEncoder rightEncoder) {
        this.leftEncoder = leftEncoder;
        this.rightEncoder = rightEncoder;
    }

    public void reset() {
        leftEncoder.reset();
        rightEncoder.reset();
    }

    public double getLeftCount() {
        return leftEncoder.get();
    }

    public double getRightCount() {
        return rightEncoder.get();
    }

    public double getAverageCount() {
        return Math.abs((leftEncoder.get() + rightEncoder.get()) / 2);
    }

    public double getAverageDistance() {
        return Math.abs((leftEncoder.getDistance() + rightEncoder.getDistance()) / 2);
    }
}
