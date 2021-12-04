package frc.robot.subsystems.simulation;

import frc.robot.sensors.AbsWheelEncoders;

public class SimulationWheelEncoders extends AbsWheelEncoders {
    private final SimulationEncoder leftEncoder;
    private final SimulationEncoder rightEncoder;

    public SimulationWheelEncoders(SimulationEncoder leftEncoder, SimulationEncoder rightEncoder) {
        super(leftEncoder, rightEncoder);

        this.leftEncoder = leftEncoder;
        this.rightEncoder = rightEncoder;
    }

    public void updateSimulation(double leftDistance, double leftRate, double rightDistance, double rightRate) {
        leftEncoder.updateSimulation(leftDistance, leftRate);
        rightEncoder.updateSimulation(rightDistance, rightRate);
    }
}
