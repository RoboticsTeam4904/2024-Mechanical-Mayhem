package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.custom.motorcontrollers.CANTalonFX;
import org.usfirst.frc4904.standard.custom.motorcontrollers.CustomCANSparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class InOutSubsystem extends SubsystemBase{
    public final CustomCANSparkMax leftMotor;
    public final CustomCANSparkMax rightMotor;
    public Double inSpeed;
    public Double outSpeed;
    public InOutSubsystem (CustomCANSparkMax leftMotor, CustomCANSparkMax rightMotor, Double inSpeed, Double outSpeed) {
        this.leftMotor = leftMotor;
        this.rightMotor = rightMotor;
        this.inSpeed = inSpeed;
        this.outSpeed = outSpeed;
    }
    public Command c_intake () {
         return this.run(() -> {
            setVoltage(inSpeed);
        });
    }
    public Command c_outtakeFront () {
        return this.run(() -> {
            setVoltage(-inSpeed);
        });
    }
    public void setVoltage(Double voltage) {
        leftMotor.setVoltage(voltage);
        rightMotor.setVoltage(voltage);
    }
    public Command c_outtakeBack () {
         return this.run(() -> {
            setVoltage(outSpeed);
        });
    }
}
