package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

/**
 * A fake autonomous class for demonstration purposes.
 */
public class Autonomous extends CommandBase {
    private final DriveTrain driveTrain;

    public Autonomous(DriveTrain driveTrain) {
        this.driveTrain = driveTrain;

        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        RobotContainer.gyro.resetGyroAngle();
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        this.driveTrain.drive(0, 0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}