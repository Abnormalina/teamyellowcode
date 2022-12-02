package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase{

    VictorSP armVictor; 
    
    public Arm(){

        armVictor = new VictorSP(3);

    }

    public void moveArm(double speed){
        armVictor.set(speed); 
    }

    public void stop(){
        armVictor.set(0);
    }
}

