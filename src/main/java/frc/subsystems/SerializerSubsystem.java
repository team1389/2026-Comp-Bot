
package frc.subsystems;

import com.ctre.phoenix6.controls.DutyCycleOut;

//import static edu.wpi.first.units.Units.Volts;

//import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.units.measure.LinearVelocity;
//import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import yams.motorcontrollers.SmartMotorController;
import yams.motorcontrollers.SmartMotorControllerConfig;
import yams.motorcontrollers.SmartMotorControllerConfig.MotorMode;
//import yams.motorcontrollers.remote.TalonFXSWrapper;
import yams.motorcontrollers.remote.TalonFXWrapper;

public class SerializerSubsystem extends SubsystemBase {

    private final TalonFX IndexerMotor = new TalonFX(RobotMap.IndexerCanID);
    

    private final TalonFX KickerTopMotor = new TalonFX(RobotMap.KickerTopCanID);
    private final SmartMotorControllerConfig KickerTopMotorConfig = new SmartMotorControllerConfig(this)
                        // Configure Motor and Mechanism properties
                        .withIdleMode(MotorMode.BRAKE)
                        .withMotorInverted(false);
    @SuppressWarnings("unused")
    private final SmartMotorController KickerTopSMC = new TalonFXWrapper(KickerTopMotor,
                        DCMotor.getKrakenX44Foc(1),
                        KickerTopMotorConfig);

    private final TalonFX KickerBottomMotor = new TalonFX(RobotMap.KickerBottomCanID);
    private final SmartMotorControllerConfig KickerBottomMotorConfig = new SmartMotorControllerConfig(this)
                        // Configure Motor and Mechanism properties
                        .withIdleMode(MotorMode.BRAKE)
                        .withMotorInverted(true);
    @SuppressWarnings("unused")
    private final SmartMotorController KickerBottomSMC = new TalonFXWrapper(KickerBottomMotor,
                        DCMotor.getKrakenX44Foc(1),
                        KickerBottomMotorConfig);


  

  public SerializerSubsystem() {
    //Check motor allignment
    KickerTopMotor.setControl(new Follower(RobotMap.IndexerCanID, MotorAlignmentValue.Aligned));
    KickerBottomMotor.setControl(new Follower(RobotMap.IndexerCanID, MotorAlignmentValue.Opposed));
  }

  public void setSpeed(double SerializerSpeed){
      IndexerMotor.setControl(new DutyCycleOut(SerializerSpeed));
  }
  public void stop(){
      IndexerMotor.setControl(new VoltageOut(0));
  }

    @Override
  public void periodic() {}

    public void setRPMDirect(LinearVelocity ofBaseUnits) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRPMDirect'");
    }
}

