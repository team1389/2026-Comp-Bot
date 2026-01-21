package frc.subsystems;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class HoodSubsystem extends SubsystemBase{
    private TalonFX HoodMotor = new TalonFX(RobotMap.HoodCanID);
     public HoodSubsystem() {
        HoodMotor = new TalonFX(RobotMap.HoodPort);
        
    }
    public void run(){
        HoodMotor.setControl(new VoltageOut(RobotMap.MaxHoodSpeed));
    }
    public void stop(){
        HoodMotor.setControl(new VoltageOut(0));
    }
    public void setSpeed(double i) {
        HoodMotor.setControl(new VoltageOut(i));
    }
}