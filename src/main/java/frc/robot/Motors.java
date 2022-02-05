package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Motors {
    private DifferentialDrive m_diffDrive;
    private final CANSparkMax m_leftNEO;
    private final RelativeEncoder m_leftEncoder;
    private final CANSparkMax m_rightNEO;
    private final RelativeEncoder m_rightEncoder;

    private final Servo m_servo;

    private final Spark m_pwmMotor;


    public Motors() {

        // NEO Motors
        m_leftNEO = new CANSparkMax(Constants.Motors.LeftNeoID, MotorType.kBrushless); 
        m_leftNEO.restoreFactoryDefaults();
        m_leftEncoder = m_leftNEO.getEncoder();

        m_rightNEO = new CANSparkMax(Constants.Motors.RightNeoID, MotorType.kBrushless);
        m_rightNEO.restoreFactoryDefaults();
        m_rightNEO.setInverted(true);
        m_rightEncoder = m_rightNEO.getEncoder();
    
        m_diffDrive = new DifferentialDrive(m_leftNEO, m_rightNEO);
        m_pwmMotor = new Spark(Constants.Motors.PWMMotorID);

        m_servo = new Servo(Constants.Motors.ServoPort);

    }

    public void Update(Controllers uc) {
        m_diffDrive.tankDrive(uc.getDriverLeftY(), uc.getDriverRightY());
        m_pwmMotor.set(uc.getDriverLeftTrigger());
        m_servo.set(uc.getDriverRightTrigger());

        SmartDashboard.putNumber("Left NEO", m_leftEncoder.getVelocity());
        SmartDashboard.putNumber("Right NEO", m_leftEncoder.getVelocity());
        SmartDashboard.putNumber("PWM Motor", m_pwmMotor.get());
        SmartDashboard.putNumber("Servo", m_servo.get());

    }


}


