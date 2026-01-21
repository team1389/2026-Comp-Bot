package frc.robot;

/**
 * define Hardware Ports and CAN id's in here
 */
public class RobotMap {
    //Max Speed
    public static double MAX_SPEED = 20; //Meters per Second

    //Drivetrain Motor Ports
    public static int FrontLeftDrive = 1;
    public static int FrontLeftSteer = 2;
    public static int FrontRightDrive = 4;
    public static int FrontRightSteer = 5;
    public static int BackLeftDrive = 7;
    public static int BacklLeftSteer = 8;
    public static int BackRightDrive = 10;
    public static int BackRightSteer = 11;

    //Drivetrain CAN id's

    public static int FrontLeftCanDrive = 1;
    public static int FrontLeftCanSteer = 2;
    public static int CanCoderFrontLeft = 3;
    public static int FrontRightCanDrive = 4;
    public static int FrontRightCanSteer = 5;
    public static int CanCoderFrontRight = 6;
    public static int BackLeftCanDrive = 7;
    public static int BackLeftCanSteer = 8;
    public static int CanCoderBackLeft = 9;
    public static int BackRightCanDrive = 10;
    public static int BackRightCanSteer = 11;
    public static int CanCoderBackRight = 12;
    public static int Pigeon2 = 32;
    //Other Motor Ports

    //Other CAN id's

    //Controler Constants
    public static double DEADBAND = 0.5;

    
}