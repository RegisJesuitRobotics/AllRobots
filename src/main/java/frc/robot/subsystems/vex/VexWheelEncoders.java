package frc.robot.subsystems.vex;

import frc.robot.sensors.AbsWheelEncoders;
import frc.robot.sensors.IEncoder;

public class VexWheelEncoders extends AbsWheelEncoders {
    public VexWheelEncoders(IEncoder leftEncoder, IEncoder rightEncoder) {
        super(leftEncoder, rightEncoder);
    }
}
