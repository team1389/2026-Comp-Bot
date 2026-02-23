package frc.command;

import frc.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class RunSerializer extends Command {
    public SerializerSubsystem serializerSubsystem;

    public RunSerializer(SerializerSubsystem serializerSubsystem) {
        this.serializerSubsystem = serializerSubsystem;
    }
  



  

  public void initialize(){
        //put things that need to be initialized here (such as a timer). No need to @Override.
    }

    @Override
    public void execute() {
        SerializerSubsystem.setSpeed(SerializerSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        SerializerSubsystem.stop();
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}