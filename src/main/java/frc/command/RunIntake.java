package frc.command;

import frc.subsystems.IntakeSubsystem;

import static edu.wpi.first.units.Units.Degrees;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj2.command.Command;

public class RunIntake extends Command {
    public IntakeSubsystem IntakeSubsystem;
    //example angle, change to whatever you want the intake to be at when the command is run.
    private double armIntakeTargetAngle;

    public RunIntake(IntakeSubsystem IntakeSubsystem, double armIntakeTargetAngle){ 
        this.IntakeSubsystem = IntakeSubsystem;
        this.armIntakeTargetAngle = armIntakeTargetAngle;
    }

    public void initialize(){
        //put things that need to be initialized here (such as a timer). No need to @Override.
    }

    @Override
    public void execute() {
        //This gets called when the command does. 
        IntakeSubsystem.setSpeed(12);
        IntakeSubsystem.setAngle(Degrees.of(armIntakeTargetAngle));
    }

    @Override
    public void end(boolean interrupted) {
        //this gets called when the input stops being given. 
        IntakeSubsystem.stop();
    }

    @Override
    public boolean isFinished(){
        //If true is returned, the command will stop being run. Can be used to check if a encoder is at right place or limit switch is press (for example)
        return false;
    }
}
