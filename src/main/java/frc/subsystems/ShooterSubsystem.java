package frc.subsystems;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class ShooterSubsystem extends SubsystemBase{
    private TalonFX UpperShooterMotor = new TalonFX(RobotMap.ShooterCanID1);
    private TalonFX LowerShooterMotor = new TalonFX(RobotMap.ShooterCanID2);
     public ShooterSubsystem() {
        UpperShooterMotor = new TalonFX(RobotMap.ShooterPort1);
        LowerShooterMotor = new TalonFX(RobotMap.ShooterPort2);
        
    }

    public void run(){
        UpperShooterMotor.setControl(new VoltageOut(RobotMap.MaxShooterSpeed));
        LowerShooterMotor.setControl(new VoltageOut(-RobotMap.MaxShooterSpeed));
    }
    public void stop(){
        UpperShooterMotor.setControl(new VoltageOut(0));
        LowerShooterMotor.setControl(new VoltageOut(0));
    }

    public void setSpeed(double i) {
        UpperShooterMotor.setControl(new VoltageOut(i));
        LowerShooterMotor.setControl(new VoltageOut(i));
    }
}