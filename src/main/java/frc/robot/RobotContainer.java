// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.commands.DriveDistancePidCommand;
// import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ISubsystems;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    enum Robots {
        VEX,
        ROMI
    }

    private final SendableChooser<Robots> robotChooser = new SendableChooser<>();

    // Subsystems
    ISubsystems subsystems = new frc.robot.subsystems.romi.RomiSubsystems();
    // ISubsystems subsystems = new frc.robot.subsystems.vex.VexSubsystems();

    // Commands

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {

        // Configure the button bindings
        configureButtonBindings();

        robotChooser.addOption("Vex", Robots.VEX);
        robotChooser.addOption("Romi", Robots.ROMI);
        SmartDashboard.putData(robotChooser);

        // if (robotChooser.getSelected() == Robots.VEX) {
        // subsystems = new frc.robot.subsystems.vex.VexSubsystems();
        // } else {
        // subsystems = new frc.robot.subsystems.romi.RomiSubsystems();
        // }

        subsystems.initialize();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
     * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {}

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        // return m_autoCommand;
        // return null;
        // return new DriveTime(0.8, 5, subsystems.getChassis());
        // return new DriveDistance(0.8, 1, subsystems.getChassis(),
        // subsystems.getWheelEncoders());
        return new DriveDistancePidCommand(1, subsystems);
    }

    public Command getDriveCommand() {
        return new RunCommand(
                () -> subsystems.getChassis().drive(subsystems.getDriver().getY(), subsystems.getDriver().getX()),
                subsystems.getChassis());
    }
    // Default operator drive command
    // subsystems.getChassis().setDefaultCommand(
    // new RunCommand(() -> subsystems.getChassis().drive(
    // subsystems.getDriver().getY(),
    // subsystems.getDriver().getX()),
    // subsystems.getChassis()));
}
