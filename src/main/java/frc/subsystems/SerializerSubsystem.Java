package frc.subsystems;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class SerializerSubsystem extends SubsystemBase{
     public SerializerSubsystem() {
        IndexerMotor = new TalonFX(RobotMap.IndexerPort);
        KickerTopMotor = new TalonFX(RobotMap.KickerTopPort);
        KickerBottomMotor = new TalonFX(RobotMap.KickerBottomPort);

        
    }

    public void setSpeed(double intakeSpeed){
        IndexerMotor.setControl(new VoltageOut(intakeSpeed));
        KickerTopMotor.setControl(new VoltageOut(intakeSpeed));
        KickerBottomMotor.setControl(new VoltageOut(-intakeSpeed));

    }
    public void stop(){
        IndexerMotor.setControl(new VoltageOut(0));
        KickerTopMotor.setControl(new VoltageOut(0));
        KickerBottomMotor.setControl(new VoltageOut(0));
    }
}


