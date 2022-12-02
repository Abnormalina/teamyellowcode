// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Drive;
import frc.robot.commands.MoveArm;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoDrive;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  Joystick leftJoystick = new Joystick(0);
  Joystick rightJoystick = new Joystick(1);

  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_Drivetrain = new Drivetrain();

  private final Arm m_Arm = new Arm();
  JoystickButton raiseArmBtn = new JoystickButton(leftJoystick, 3);
  JoystickButton lowerArmBtn = new JoystickButton(rightJoystick, 3);



  private final Drive m_Drive = new Drive(m_Drivetrain, leftJoystick, rightJoystick);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    raiseArmBtn.whenHeld(new MoveArm(m_Arm, 0.5));
    lowerArmBtn.whenHeld(new MoveArm(m_Arm, -0.5));

    m_Drivetrain.setDefaultCommand(m_Drive);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new SequentialCommandGroup (
      new AutoDrive(m_Drivetrain, -0.5, -0.5).withTimeout(2),
      new AutoDrive(m_Drivetrain, 0, 0)
    );
  
  }
}
