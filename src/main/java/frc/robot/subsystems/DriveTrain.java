// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;


/**
 * Handles anything related to moving the robot.
 */
public class DriveTrain extends SubsystemBase {
    private final CANSparkMax frontLeft;
    private final CANSparkMax frontRight;
    private final CANSparkMax rearLeft;
    private final CANSparkMax rearRight;

    private final RelativeEncoder frontLeftEncoder;
    private final RelativeEncoder frontRightEncoder;
    private final RelativeEncoder rearLeftEncoder;
    private final RelativeEncoder rearRightEncoder;

    private final MecanumDrive mecanumDrive;

    public DriveTrain() {
        this.frontLeft = new CANSparkMax(Constants.frontLeftMotorPort, MotorType.kBrushless);
        this.frontRight = new CANSparkMax(Constants.frontRightMotorPort, MotorType.kBrushless);
        this.rearLeft = new CANSparkMax(Constants.rearLeftMotorPort, MotorType.kBrushless);
        this.rearRight = new CANSparkMax(Constants.rearRighttMotorPort, MotorType.kBrushless);

        this.frontLeftEncoder = this.frontLeft.getEncoder();
        this.frontRightEncoder = this.frontRight.getEncoder();
        this.rearLeftEncoder = this.rearLeft.getEncoder();
        this.rearRightEncoder = this.rearRight.getEncoder();

        this.frontRight.setInverted(false);
        this.rearRight.setInverted(false);
        this.frontLeft.setInverted(true);
        this.rearLeft.setInverted(true);

        this.mecanumDrive = new MecanumDrive(this.frontLeft, this.rearLeft, this.frontRight, this.rearRight);

        this.mecanumDrive.setSafetyEnabled(false);
    }

    public void drive(double ySpeed, double xSpeed, double zRotation) {
        this.mecanumDrive.driveCartesian(ySpeed, xSpeed, zRotation, -RobotContainer.gyro.getGyroAngle());
        
        if (RobotContainer.primaryJoystick.joystick.getRawButtonPressed(Constants.resetGyroButtonNumber)) {
            RobotContainer.gyro.resetGyroAngle();
        }
    }

    public void driveRR(double ySpeed, double xSpeed, double zRotation) {
        this.mecanumDrive.driveCartesian(ySpeed, xSpeed, zRotation, 0);
        
        if (RobotContainer.primaryJoystick.joystick.getRawButtonPressed(Constants.resetGyroButtonNumber)) {
            RobotContainer.gyro.resetGyroAngle();
        }
    }

    public double setAngle(double angle) {
        double angleDifference = angle - RobotContainer.gyro.getGyroAngle(); // gets angle difference

        if (Math.abs(angleDifference) >= 180) {
            /**
             * ensures that angleDifference is the smallest possible movement to the
             * destination
             */
            angleDifference = angleDifference + (angleDifference > 0 ? -360 : 360);
        }

        /**
         * positive angleDifference -> turn clockwise, negative angleDifference -> turn
         * counterclockwise
         * strength of turning power is proportional to size of angleDifference
         */
        double zRotation = angleDifference / 120;

        if (zRotation > 1) {
            zRotation = 1;
        } else if (zRotation < -1) {
            zRotation = -1;
        }

        return zRotation;
    }

    @Override
    public void periodic() {
    }

    @Override
    public void simulationPeriodic() {
    }

    public void stopMotors() {
        mecanumDrive.stopMotor();
    }

}