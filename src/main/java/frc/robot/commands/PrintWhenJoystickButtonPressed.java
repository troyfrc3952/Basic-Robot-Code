package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Prints stuff to the console when the joystick button is pressed.
 * 
 * Very creative name I know
 */
public class PrintWhenJoystickButtonPressed extends CommandBase {

    public PrintWhenJoystickButtonPressed() {
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        System.out.println("You pressed a joystick button. This is a very creative example that I spent a lot of time coming up with.");
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
