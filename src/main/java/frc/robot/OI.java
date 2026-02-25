package frc.robot;

import static edu.wpi.first.units.Units.Degrees;

import static edu.wpi.first.units.Units.Degrees;


import com.pathplanner.lib.commands.PathPlannerAuto;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.command.RunFlywheel;
import frc.command.RunIntake;
import frc.command.RunTurret;
import frc.command.TestHood;
import frc.command.TestIntake;
import frc.command.TestIntakeArm;
import frc.command.TestShooter;
import frc.command.TestTurret;
import frc.subsystems.FlywheelSubsystem;
import frc.subsystems.HoodSubsystem;
import frc.subsystems.IntakeSubsystem;
import frc.subsystems.TurretSubsystem;
import frc.subsystems.SerializerSubsystem;
import frc.command.TestSerializer;


public class OI {
  // Define controller ports | DO NOT TOUCH |
  final CommandXboxController manipController = new CommandXboxController(1);
  final CommandXboxController driveController = new CommandXboxController(0);

    //Define all subsystems using "IntakeSubsystem IntakeSubsystem = new IntakeSubsystem();"
    SerializerSubsystem serializerSubsystem = new SerializerSubsystem();

  // YAGSL Swerve Data Stream

  /*
  private final SwerveSubsystem drivebase  = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(),"swerve"));
  private final TargetingSystem targetingSystem = new TargetingSystem();


  //Converts driver input into a field-relative ChassisSpeeds that is controlled by angular velocity.


    SwerveInputStream driveAngularVelocity = SwerveInputStream.of(drivebase.getSwerveDrive(),
                                                                    () -> driveController.getLeftY() * -1,
                                                                    () -> driveController.getLeftX() * -1) 
                                                                    //Raw axis of rightTriggerAxis is 3 for some reason
                                                                .withControllerRotationAxis(() -> driveController.getRightTriggerAxis() * -1)
                                                                .deadband(OperatorConstants.DEADBAND)
                                                                .scaleTranslation(0.8)
                                                                .allianceRelativeControl(true);
    
    
    //Clone's the angular velocity input stream and converts it to a fieldRelative input stream.
    
    
    SwerveInputStream driveDirectAngle = driveAngularVelocity.copy().withControllerHeadingAxis(driveController::getRightX,
                                                                                                driveController::getRightY)
                                                            .headingWhile(true);
    
    //Clone's the angular velocity input stream and converts it to a robotRelative input stream.
    
    SwerveInputStream driveRobotOriented = driveAngularVelocity.copy().robotRelative(true)
                                                                .allianceRelativeControl(false);
    */
  
    //Creates Bindings for controllers
    public OI() {
        configureBindings();
        
    }


  private void configureBindings() {

    TurretSubsystem turretSubsystem = new TurretSubsystem();
    double targetAngle = 45; // Set target angle for the turret
    FlywheelSubsystem flywheelSubsystem = new FlywheelSubsystem();
    IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    HoodSubsystem hoodSubsystem = new HoodSubsystem();
    double armIntakeTargetAngle = 46;
    double intakeTargetAngle = 90;
    double outtakeTargetAngle = 0;

    if (DriverStation.isTest()) {
      // Testing subsytem commands
      // Turret
      turretSubsystem.setDefaultCommand(
          new TestTurret(turretSubsystem, manipController.getLeftY()));
      // Flywheel
      manipController.rightTrigger().whileTrue(new TestShooter(flywheelSubsystem, -60));
      manipController.rightBumper().whileTrue(new TestShooter(flywheelSubsystem, 60));
      // Intake
      manipController.a().whileTrue(new TestIntake(intakeSubsystem, 1));
      manipController.b().whileTrue(new TestIntake(intakeSubsystem, -1));
      // Hood
      manipController.x().whileTrue(new TestHood(hoodSubsystem, 1));
      manipController.y().whileTrue(new TestHood(hoodSubsystem, -1));
      // IntakeArm
      manipController.leftBumper().whileTrue(new TestIntakeArm(intakeSubsystem, 1));
      manipController.leftTrigger().whileTrue(new TestIntakeArm(intakeSubsystem, -1));

      manipController.start().whileTrue(new TestSerializer(serializerSubsystem, 0.1));
      manipController.back().whileTrue(new TestSerializer(serializerSubsystem, -0.1));



    } else {
      // Comp commands should be put here
      manipController.a().whileTrue(new RunIntake(intakeSubsystem, armIntakeTargetAngle));
      manipController.b().whileTrue(intakeSubsystem.intake(Degrees.of(intakeTargetAngle)));
      manipController.y().whileTrue(intakeSubsystem.outtake(Degrees.of(outtakeTargetAngle)));
      

      manipController.x().whileTrue(new RunTurret(turretSubsystem, targetAngle));

      manipController.rightBumper().whileTrue(new RunFlywheel(flywheelSubsystem));
    }
  }

  public Command getAutonomousCommand() {
    // AUTOS not PATHS in path planner should be called here
    return new PathPlannerAuto("AutoName");
  }
}
