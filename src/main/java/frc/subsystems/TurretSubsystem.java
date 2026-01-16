package frc.subsystems;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class TurretSubsystem extends SubsystemBase{
    private TalonFX TurretMotor = new TalonFX(RobotMap.TurretCanID);
     public TurretSubsystem() {
        TurretMotor = new TalonFX(RobotMap.TurretPort);
        
    }
    public void run(){
        TurretMotor.setControl(new VoltageOut(RobotMap.MaxTurretSpeed*16));
    }
    public void stop(){
        TurretMotor.setControl(new VoltageOut(0));
    }
    public void setSpeed(double i) {
        TurretMotor.setControl(new VoltageOut(i));
    }
}