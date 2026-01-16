package frc.robot;

/**
 * define Hardware Ports and CAN id's in here
 */
public class RobotMap {
    //Drivetrain Motor Ports

    //Drivetrain CAN id's

    //Other Motor Ports
    //Shooter Motor Ports
    public static final int ShooterPort1 = 9;
    public static final int ShooterPort2 = 10;

    //Indexer ports
    public static final int IndexerPort = 11;
    //Turret Ports
    public static final int TurretPort = 12;
    
    //Speeds

    //Shooter Speed
    public static final double MaxShooterSpeed = 0.5; //Set on 0-1 scale
    //Indexer Speed
    public static final double MaxIndexerSpeed = 0.1; //Set on 0-1 scale
    //Turret Speed
    public static final double MaxTurretSpeed = 1; //Set on 0-1 scale

    //Other CAN id's

    //Shooter Can Id's
    public static final int ShooterCanID1 = 9;
    public static final int ShooterCanID2 = 10;
    //Indexer Can Id's
    public static final int IndexerCanID = 11;
    //Turret Can Id's
    public static final int TurretCanID = 12;   
}