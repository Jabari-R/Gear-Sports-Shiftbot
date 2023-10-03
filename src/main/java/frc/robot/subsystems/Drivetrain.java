package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

public class Drivetrain extends SubsystemBase {

public static final double PlaceDistance = 0.1;
public static final double BackAwayDistance = 0.6;

private PWMVictorSPX left1;
private PWMVictorSPX left2;
private MotorControllerGroup leftMotor;
private PWMVictorSPX right1;
private PWMVictorSPX right2;
private MotorControllerGroup rightMotor;
private DifferentialDrive drive;
private Encoder leftEncoder;
private Encoder rightEncoder;
private AnalogGyro gyro;
private AnalogInput rangefinder;




    public Drivetrain(){

        left1 = new PWMVictorSPX(0);
        addChild("left1", left1);
        left1.setInverted(false);

        left2 = new PWMVictorSPX(1);
        addChild("left2", left2);
        left2.setInverted(false);

        leftMotor = new MotorControllerGroup(left1, left2, null);
        addChild("leftMotor", leftMotor);

        right1 = new PWMVictorSPX(5);
        addChild("right1", right1);
        right1.setInverted(false);

        right2 = new PWMVictorSPX(6);
        addChild("right2", right2);
        right2.setInverted(false);

        rightMotor = new MotorControllerGroup(right1, right2, null);
        addChild("rightMotor", rightMotor);

        drive = new DifferentialDrive(leftMotor, rightMotor);
        addChild("drive", drive);
        drive.setSafetyEnabled(true);
        drive.setExpiration(0.1);
        drive.setMaxOutput(1.0);

    leftEncoder = new Encoder(0, 1, false, EncodingType.k4X);
    addChild("leftEncoder", leftEncoder);
    leftEncoder.setDistancePerPulse(1.0);

    rightEncoder = new Encoder(2, 3, false, EncodingType.k4X);
    addChild("rightEncoder", rightEncoder);
    rightEncoder.setDistancePerPulse(1.0);

    gyro = new AnalogGyro(0);
    addChild("gyro", gyro);
    gyro.setSensitivity(0.007);

    rangefinder = new AnalogInput(1);
    addChild("rangefinder", rangefinder);


    }




    @Override
    public void periodic() {



    }



    @Override
    public void simulationPeriodic(){



    }



    public void drive(double left, double right){

        drive.tankDrive(left, right);

        
    }






    
}
