package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class Sensors {
    private DigitalInput m_limitSwitch;

    public Sensors() {
        m_limitSwitch = new DigitalInput(Constants.Sensors.LimitSwitchPort);

    }

    public void Update() {
        
    }
}
