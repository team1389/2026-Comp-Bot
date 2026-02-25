package frc.command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.subsystems.IntakeSubsystem;

public class TestIntake extends Command {
  public IntakeSubsystem intakeSubsystem;
  public double voltage;

  public TestIntake(IntakeSubsystem intakeSubsystem, double voltage) {
    this.intakeSubsystem = intakeSubsystem;
    this.voltage = voltage;
  }

  public void initialize() {
    // put things that need to be initialized here (such as a timer). No need to @Override.
  }

  @Override
  public void execute() {
    // This gets called when the command does.
    intakeSubsystem.setRollerVoltage(voltage);
    SmartDashboard.putBoolean("Intake Motion", true);
  }

  @Override
  public void end(boolean interrupted) {
    // this gets called when the input stops being given.
    intakeSubsystem.stopRoller();
    SmartDashboard.putBoolean("Intake Motion", false);
  }

  @Override
  public boolean isFinished() {
    // If true is returned, the command will stop being run. Can be used to check if a encoder is at
    // right place or limit switch is press (for example)
    return false;
  }
}
