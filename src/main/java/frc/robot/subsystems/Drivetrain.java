package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

    private VictorSP lSP;
    private VictorSP rSP;
    public Drivetrain(){

        lSP = new VictorSP(0);
        rSP = new VictorSP(1);

        lSP.setInverted(true);
        rSP.setInverted(false);
    }
    public void drive(double lSpeed, double rSpeed){
        lSP.set(lSpeed);
        rSP.set(rSpeed);
    }

    public void stop(){
        lSP.set(0);
        rSP.set(0);
    }
}
