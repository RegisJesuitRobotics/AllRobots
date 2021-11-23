package frc.robot.subsystems.romi;

import frc.robot.sensors.AbsWheelEncoders;
import frc.robot.sensors.IEncoder;

public class RomiWheelEncoders extends AbsWheelEncoders {

    public RomiWheelEncoders(IEncoder leftEncoder, IEncoder rightEncoder) {
        super(leftEncoder, rightEncoder);
    }
    
}
