package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {
    private Drivetrain drivetrain;
    private Joystick lJoystick, rJoystick;
    public Drive (Drivetrain drivetrain, Joystick lJoystick, Joystick rJoystick){
        this.drivetrain = drivetrain;
        this.lJoystick = lJoystick;
        this.rJoystick = rJoystick;

        addRequirements(this.drivetrain);
    }

    @Override
    public void execute() {
        drivetrain.drive(lJoystick.getY(), rJoystick.getY());
    }
}
