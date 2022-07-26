// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or booleanconstants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public class Constants {
    // CAN Bus ID Declaration
    public static final int frontRightMotorPort = 1;
    public static final int rearRighttMotorPort = 2;
    public static final int rearLeftMotorPort = 3;
    public static final int frontLeftMotorPort = 4;

    // Joystick Port Numbers
    public static final int primaryJoystickPort = 0;
    public static final int secondaryJoystickPort = 1;
    public static final int tertiaryJoystickPort = 2;
    
    // button numbers for primary joystick (1-9)
    public static final int printWhenPressedButtonNumber = 1;
    public static final int resetGyroButtonNumber = 8;
}