package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Controllers {
    private XboxController m_driveController;
    private XboxController m_assistController;

    public Controllers() {
        m_driveController = new XboxController(Constants.Controllers.DrivePort);
        m_assistController = new XboxController(Constants.Controllers.AssistPort);
    }

    public XboxController getDriver() {
        return m_driveController;
    }

    public XboxController getAssist() {
        return m_assistController;
    }

    public double getDriverLeftY() {
        return removeDeadband(m_driveController.getLeftY());
    }

    public double getDriverRightY() {
        return removeDeadband(m_driveController.getRightY());
    }

    public double getDriverLeftTrigger() {
        return removeDeadband(m_driveController.getLeftTriggerAxis());
    }

    public double getDriverRightTrigger() {
        return removeDeadband(m_driveController.getLeftTriggerAxis());
    }

    public double getAssistLeftY() {
        return removeDeadband(m_assistController.getLeftY());
    }

    public double getAssistRightY() {
        return removeDeadband(m_assistController.getRightY());
    }

    public double getAssistLeftTrigger() {
        return removeDeadband(m_assistController.getLeftTriggerAxis());
    }

    public double getAssistRightTrigger() {
        return removeDeadband(m_assistController.getLeftTriggerAxis());
    }

    public void Update() {
        SmartDashboard.putNumber("Driver L", getDriverLeftY());
        SmartDashboard.putNumber("Driver R", getDriverRightY());
    }

    public double removeDeadband(double value) {
        if(Math.abs(value) < Constants.Controllers.DeadBand) {
            return 0.0;
        } else {
            return value;
        }
    }

}
