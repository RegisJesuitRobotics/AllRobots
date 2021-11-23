package frc.robot.sensors;

public interface IEncoder {
    public void reset();

    public double get();

    public double getDistance();
}
