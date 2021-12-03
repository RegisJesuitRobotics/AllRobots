package frc.robot.subsystems.simulation;

import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;
import frc.robot.subsystems.Chassis;

public class SimulationChassis extends Chassis {

    private final SimulationWheelEncoders encoders;
    private final SimulationGyro gyro;
    private final DifferentialDrivetrainSim driveSim;
    private final DifferentialDrive diffDrive;
    private final PWMSparkMax leftMotor;
    private final PWMSparkMax rightMotor;

    public SimulationChassis(SimulationWheelEncoders encoders, SimulationGyro gyro) {
        super(gyro, encoders);
        this.gyro = gyro;
        this.encoders = encoders;
        // Using this because it's easy
        driveSim = DifferentialDrivetrainSim.createKitbotSim(KitbotMotor.kDualCIMPerSide, KitbotGearing.k10p71,
                KitbotWheelSize.SixInch, null);
        leftMotor = new PWMSparkMax(SimulationConstants.LEFT_MOTOR_PORT);
        rightMotor = new PWMSparkMax(SimulationConstants.RIGHT_MOTOR_PORT);
        odometry = new DifferentialDriveOdometry(gyro.getRotation2d(), new Pose2d(0, 0, new Rotation2d()));

        diffDrive = new DifferentialDrive(leftMotor, rightMotor);
        diffDrive.setRightSideInverted(false);
    }

    @Override
    public void drive(double speed, double rot) {
        diffDrive.arcadeDrive(speed, rot);
    }

    @Override
    public void tankDrive(double leftSpeed, double rightSpeed) {
        diffDrive.tankDrive(leftSpeed, rightSpeed);
    }

    @Override
    public void simulationPeriodic() {
        driveSim.setInputs(leftMotor.get() * RobotController.getInputVoltage(),
                rightMotor.get() * RobotController.getInputVoltage());
        driveSim.update(0.02);

        encoders.updateSimulation(driveSim.getLeftPositionMeters(), driveSim.getLeftVelocityMetersPerSecond(),
                driveSim.getRightPositionMeters(), driveSim.getRightVelocityMetersPerSecond());
        gyro.updateSimulation(-driveSim.getHeading().getDegrees());
    }
}
