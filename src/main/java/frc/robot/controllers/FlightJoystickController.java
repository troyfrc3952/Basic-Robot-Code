package frc.robot.controllers;

import edu.wpi.first.wpilibj.Joystick;

/**
 * The math in here is voodoo magic passed down from the software teams of years past.
 * 
 * Basically the joysticks we use have a small area in the middle where if you move it nothing actually happens (the deadzone) and this code deals with it. Use the methods defined in here to get proper joystick values.
 */

public class FlightJoystickController {
    public static final double c = 0.1;
    public static final double deadzone = 0.2;
    public static final double max = 0.8;
    public static final double k = (max - c) / Math.log(2 - deadzone);

    public static final double cT = 0.08;
    public static final double deadzoneT = 0.08;
    public static final double maxT = 0.4;
    public static final double kT = (maxT - cT) / Math.log(2 - deadzoneT);

    public Joystick joystick;

    public FlightJoystickController(Joystick joystick) {
        this.joystick = joystick;
    }

    public double getHorizontalMovement() {
        double x = joystick.getX();
        
        return Math.abs(x) >= deadzone ? k * Math.signum(x) * (Math.log(Math.abs(x) + 1 - deadzone) + c) : 0;
    }

    public double getLateralMovement() {
        double y = joystick.getY();
        
        return Math.abs(y) >= deadzone ? k * Math.signum(y) * (Math.log(Math.abs(y) + 1 - deadzone) + c) : 0;
    }

    public double getRotation() {
        double t = joystick.getZ();

        return Math.abs(t) >= deadzoneT ? kT * Math.signum(t) * (Math.log(Math.abs(t) + 1 - deadzoneT) + cT) : 0;
    }

}