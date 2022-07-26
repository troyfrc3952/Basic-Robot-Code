# very important information here

Example code for demonstration purposes. Actual code quality/functionality not guaranteed.

### Packages:

Make sure to follow the ONLINE Installation method in the below link.

https://docs.revrobotics.com/sparkmax/software-resources/spark-max-api-information#c++-and-java

#### Subsystems:
Used to interface with the physical robot. This should only handle moving the motors and safety logic, etc. Actual logic belongs in a Command.

`public void periodic()` -- Is run once per scheduler run. Basically execute() but for subsystems

#### Commands:
Used to handle actual logic.

Within the constructor: use `addRequirements(subsystem1, subsystem2)` if you pass a subsystem as a parameter to the Command (necessary to interact with subsystems). Can be any amount of subsystems passed in. <--- VERY IMPORTANT

`public void initialize()` -- Is run when the command is scheduled.

`public void execute()` -- Is run once per scheduler run. Do NOT use a while loop in here, instead use an if statement. Using a while loop will hold up the entire robot execution.

`public void end()` -- Is run when the command ends OR is interrupted.

`public void isFinished()` -- Make this return true when the command should end.

(Last updated 07-25-22)
