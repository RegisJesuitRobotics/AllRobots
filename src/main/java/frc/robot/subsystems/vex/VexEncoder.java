package frc.robot.subsystems.vex;

import edu.wpi.first.wpilibj.Counter;
import frc.robot.sensors.IEncoder;

public class VexEncoder implements IEncoder {

    private final Counter encoder;

    public VexEncoder(int port, double distancePerPulse) {
        encoder = new Counter(port);

        encoder.setDistancePerPulse(distancePerPulse);
    }

    @Override
    public void reset() {
        encoder.reset();
    }

    @Override
    public double get() {
        return encoder.get();
    }

    @Override
    public double getDistance() {
        return encoder.getDistance();
    }
}
