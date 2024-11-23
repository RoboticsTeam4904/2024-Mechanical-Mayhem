package org.usfirst.frc4904.robot.humaninterface.drivers;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.humaninput.Driver;

public class NathanGain extends Driver { //ALL NathanGain JOYSTICKS OUTPUT FROM -1 TO 1

    double SPEED_EXP = 2; //TODO TUNE
    double TURN_EXP = 2; //TODO TUNE
    static boolean button1 = false;

    public NathanGain() {
        super("NathanGain");
    }

    protected double scaleGain(double input, double exp) {
        return Math.pow(Math.abs(input), exp) * Math.signum(input);
    }

    public void bindCommands() {}

    public double getLeftSpeed() {
        double raw = RobotMap.HumanInput.Driver.leftJoystick.getY();
        DriverStation.reportWarning("left speed: " + raw);

        return scaleGain(raw, SPEED_EXP);
    }

    public double getRightSpeed() {
        double raw = RobotMap.HumanInput.Driver.rightJoystick.getY();
        DriverStation.reportWarning("right speed: " + raw);

        return scaleGain(raw, TURN_EXP);
    }

    public boolean getButton1Pressed() {
        RobotMap.HumanInput.Driver.rightJoystick.button1.onTrue(
            new InstantCommand(() -> NathanGain.button1 = true)
        );
        RobotMap.HumanInput.Driver.rightJoystick.button1.onFalse(
            new InstantCommand(() -> NathanGain.button1 = false)
        );
        return NathanGain.button1;
    }

    @Override
    public double getX() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getX'");
    }

    @Override
    public double getY() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getY'");
    }

    @Override
    public double getTurnSpeed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTurnSpeed'");
    }
}
