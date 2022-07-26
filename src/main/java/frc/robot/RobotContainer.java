package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Autonomous;
import frc.robot.commands.ManualDrive;
import frc.robot.commands.PrintWhenJoystickButtonPressed;
import frc.robot.controllers.FlightJoystickController;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gyro;

/**
 * The container for the robot. Contains subsystems, OI devices, commands, etc.
 * 
 * Declare all subsystems, commands, joysticks, etc. in here.
 */
public class RobotContainer {
    public static final Gyro gyro = new Gyro();

    public static final DriveTrain driveTrain = new DriveTrain();

    public static final Autonomous autonomous = new Autonomous(driveTrain);
    public static final ManualDrive manualDrive = new ManualDrive(driveTrain);
    public static final PrintWhenJoystickButtonPressed printWhenPressed = new PrintWhenJoystickButtonPressed();

    public static final FlightJoystickController primaryJoystick = new FlightJoystickController(new Joystick(Constants.primaryJoystickPort));

    public RobotContainer() {
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link GenericHID} or one of its subclasses ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
     * it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    public void configureButtonBindings() {
        JoystickButton printWhenPressedButton = new JoystickButton(primaryJoystick.joystick, Constants.printWhenPressedButtonNumber);
        printWhenPressedButton.whenPressed(printWhenPressed);
    }

    public void autonomousInit() {
        autonomous.schedule();
    }

    public void teleopInit() {
        autonomous.cancel();
        this.configureButtonBindings();
        driveTrain.setDefaultCommand(manualDrive);
    }
}
