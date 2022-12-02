package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class AutoDrive extends CommandBase{
    Drivetrain drivetrain;
    double leftSpeed;
    double rightSpeed;
    
    public AutoDrive(Drivetrain dt, double ls, double rs) {
        drivetrain = dt;
        leftSpeed = ls;
        rightSpeed = rs;
        addRequirements(dt);
    }

    public void initialize(){
        drivetrain.stop();
    }

    public void execute() {
        drivetrain.drive(leftSpeed, rightSpeed);

    }

    public boolean isFinished(){
        return false;
    }

    public void end(boolean stop) {
        drivetrain.stop();
    }
}
