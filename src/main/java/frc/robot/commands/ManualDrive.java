// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Drive the robot manually (during teleop).
 */
public class ManualDrive extends CommandBase {
    private final DriveTrain driveTrain;
    
    private double MICRO_PP = -0.15; // MicroPinpointPositioning™

    public ManualDrive(DriveTrain driveTrain) {
        this.driveTrain = driveTrain;

        // Use addRequirements() here to declare subsystem dependencies.
        this.addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        //input joystick controls
        double ySpeed = (RobotContainer.primaryJoystick.getLateralMovement());
        double xSpeed = (-RobotContainer.primaryJoystick.getHorizontalMovement());
        double zRotation = (-RobotContainer.primaryJoystick.getRotation());

        // microadjustment
        if (RobotContainer.primaryJoystick.joystick.getPOV() == 0) {
            ySpeed += MICRO_PP;
        } else if (RobotContainer.primaryJoystick.joystick.getPOV() == 315) {
            ySpeed += MICRO_PP;
            xSpeed -= MICRO_PP;
        } else if (RobotContainer.primaryJoystick.joystick.getPOV() == 270) {
            xSpeed -= MICRO_PP - 0.05;
        } else if (RobotContainer.primaryJoystick.joystick.getPOV() == 225) {
            ySpeed -= MICRO_PP;
            xSpeed -= MICRO_PP;
        } else if (RobotContainer.primaryJoystick.joystick.getPOV() == 180) {
            ySpeed -= MICRO_PP;
        } else if (RobotContainer.primaryJoystick.joystick.getPOV() == 135) {
            ySpeed -= MICRO_PP;
            xSpeed += MICRO_PP;
        } else if (RobotContainer.primaryJoystick.joystick.getPOV() == 90) {
            xSpeed += MICRO_PP + 0.05;
        } else if (RobotContainer.primaryJoystick.joystick.getPOV() == 45) {
            ySpeed += MICRO_PP;
            xSpeed += MICRO_PP;
        }

        driveTrain.drive(ySpeed, xSpeed, zRotation);

    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.stopMotors();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}