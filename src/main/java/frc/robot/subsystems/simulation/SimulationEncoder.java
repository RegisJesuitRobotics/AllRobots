package frc.robot.subsystems.simulation;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import frc.robot.sensors.IEncoder;

public class SimulationEncoder implements IEncoder {
    private final Encoder encoder;
    private final EncoderSim encoderSim;

    public SimulationEncoder(int[] ports) {
        encoder = new Encoder(ports[0], ports[1]);
        encoderSim = new EncoderSim(encoder);

        encoder.setDistancePerPulse(SimulationConstants.DISTANCE_PER_PULSE);
    }

    @Override
    public void reset() {

    }

    @Override
    public double get() {
        return encoder.get();
    }

    @Override
    public double getDistance() {
        return encoder.getDistance();
    }

    public void updateSimulation(double distance, double rate) {
        encoderSim.setDistance(distance);
        encoderSim.setRate(rate);
    }

    @Override
    public double getRate() {
        return encoder.getRate();
    }
}
