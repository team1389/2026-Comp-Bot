package frc.subsystems;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class IndexerSubsystem extends SubsystemBase{
    private TalonFX IndexerMotor = new TalonFX(RobotMap.IndexerCanID);
     public IndexerSubsystem() {
        IndexerMotor = new TalonFX(RobotMap.IndexerPort);
        
    }
    public void run(){
        IndexerMotor.setControl(new VoltageOut(RobotMap.MaxIndexerSpeed));
    }
    public void stop(){
        IndexerMotor.setControl(new VoltageOut(0));
    }
    public void setSpeed(double i) {
        IndexerMotor.setControl(new VoltageOut(i));
    }
}


