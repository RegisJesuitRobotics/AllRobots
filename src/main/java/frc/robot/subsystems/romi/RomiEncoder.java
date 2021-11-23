// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.romi;

import edu.wpi.first.wpilibj.Encoder;
import frc.robot.sensors.IEncoder;

public class RomiEncoder implements IEncoder {

    private final Encoder encoder;
    
    public RomiEncoder(int port1, int port2, double distancePerPulse) {
        encoder = new Encoder(port1, port2);
        
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
