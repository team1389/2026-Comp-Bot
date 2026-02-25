package frc.robot;

import com.pathplanner.lib.commands.PathPlannerAuto;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.command.TestHood;
import frc.command.TestIntake;
import frc.command.TestIntakeArm;
import frc.command.TestSerializer;
import frc.command.TestShooter;
import frc.command.TestTurret;
import frc.subsystems.FlywheelSubsystem;
import frc.subsystems.HoodSubsystem;
import frc.subsystems.IntakeSubsystem;
import frc.subsystems.SerializerSubsystem;
import frc.subsystems.TurretSubsystem;

public class OI {
  // Define controller ports | DO NOT TOUCH |
  final CommandXboxController manipController = new CommandXboxController(1);
  final CommandXboxController driveController = new CommandXboxController(0);

  // Creates Bindings for controllers
  public OI() {
    configureBindings();
  }

  private void configureBindings() {
    System.out.println("Configured Bindings");
    TurretSubsystem turretSubsystem = new TurretSubsystem();
    // double targetAngle = 45; // Set target angle for the turret
    SerializerSubsystem serializerSubsystem = new SerializerSubsystem();
    FlywheelSubsystem flywheelSubsystem = new FlywheelSubsystem();
    IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    HoodSubsystem hoodSubsystem = new HoodSubsystem();
    // double armIntakeTargetAngle = 46;
    // double intakeTargetAngle = 90;
    // double outtakeTargetAngle = 0;

    if (DriverStation.isTest()) {
      System.out.print("Driver station in test mode");
      // Testing subsytem commands
      // Turret
      manipController.povLeft().whileTrue(new TestTurret(turretSubsystem, 2));
      manipController.povRight().whileTrue(new TestTurret(turretSubsystem, -2));
      // Flywheel
      manipController.rightBumper().whileTrue(new TestShooter(flywheelSubsystem, 60));

      // Intake
      manipController.a().whileTrue(new TestIntake(intakeSubsystem, 1));
      manipController.b().whileTrue(new TestIntake(intakeSubsystem, -1));
      // Hood
      manipController.povDown().whileTrue(new TestHood(hoodSubsystem, -2));
      manipController.povUp().whileTrue(new TestHood(hoodSubsystem, 2));
      // IntakeArm
      manipController.leftBumper().whileTrue(new TestIntakeArm(intakeSubsystem, 1));
      manipController.leftTrigger().whileTrue(new TestIntakeArm(intakeSubsystem, -1));

      manipController.start().whileTrue(new TestSerializer(serializerSubsystem, 0.1));
      manipController.back().whileTrue(new TestSerializer(serializerSubsystem, -0.1));

    } else {
      // Comp commands should be put here
      // manipController.a().whileTrue(new RunIntake(intakeSubsystem, armIntakeTargetAngle));
      // manipController.b().whileTrue(intakeSubsystem.intake(Degrees.of(intakeTargetAngle)));
      // manipController.y().whileTrue(intakeSubsystem.outtake(Degrees.of(outtakeTargetAngle)));

      // manipController.x().whileTrue(new RunTurret(turretSubsystem, targetAngle));

      // manipController.rightBumper().whileTrue(new RunFlywheel(flywheelSubsystem));
    }
  }

  public Command getAutonomousCommand() {
    // AUTOS not PATHS in path planner should be called here
    return new PathPlannerAuto("AutoName");
  }
}
