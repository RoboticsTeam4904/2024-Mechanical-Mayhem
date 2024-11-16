package org.usfirst.frc4904.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.function.Supplier;

public class TankDrive extends SubsystemBase {

    public final DifferentialDrive DriveTrain;

    public TankDrive(DifferentialDrive m_drive) {
        this.DriveTrain = m_drive;
    }

    public Command c_TankDrive(Supplier<Double> LeftSpeeds, Supplier<Double> RightSpeeds) {
        Command command = new Command() {
            public void execute() {
                DriveTrain.tankDrive(LeftSpeeds.get(), RightSpeeds.get());
            }
        };
        return command;
    }
}
