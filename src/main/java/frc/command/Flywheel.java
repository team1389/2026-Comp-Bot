
package frc.command;

import frc.subsystems.FlywheelSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class Flywheel extends Command {
    public FlywheelSubsystem FlywheelSubsystem;

    public Flywheel(FlywheelSubsystem FlywheelSubsystem) {
        this.FlywheelSubsystem = FlywheelSubsystem;
    }

    public void initialize(){
        //put things that need to be initialized here (such as a timer). No need to @Override.
    }

    @Override
    public void execute() {
        //This gets called when the command does. 
        FlywheelSubsystem.setVelocity(12);
    }

    @Override
    public void end(boolean interrupted) {
        //this gets called when the input stops being given. 
        FlywheelSubsystem.stop();
    }

    @Override
    public boolean isFinished(){
        //If true is returned, the command will stop being run. Can be used to check if a encoder is at right place or limit switch is press (for example)
        return false;
    }
}
