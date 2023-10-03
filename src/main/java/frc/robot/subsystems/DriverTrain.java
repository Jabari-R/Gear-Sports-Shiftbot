package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriverTrain extends SubsystemBase{
    
    private PWMSparkMax leftMotor = new PWMSparkMax(0);
    private PWMSparkMax rightMotor = new PWMSparkMax(1);


    private DifferentialDrive mDrivetrain = new DifferentialDrive(leftMotor, rightMotor);

    public void tankDrive(double leftSpeed, double rightSpeed){
        mDrivetrain.tankDrive(leftSpeed, rightSpeed);
    }


}
