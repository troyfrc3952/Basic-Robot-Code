package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.ADIS16470_IMU;

/**
 * self explanatory
 */
public class Gyro extends SubsystemBase {
    private final ADIS16470_IMU gyro;

    public Gyro() {
        this.gyro = new ADIS16470_IMU();
        this.gyro.setYawAxis(ADIS16470_IMU.IMUAxis.kY);
    }

    public double getGyroAngle() {
        return this.gyro.getAngle();
    }

    public void setGyroAxis(ADIS16470_IMU.IMUAxis axis) {
        this.gyro.setYawAxis(axis);
    }

    public void resetGyroAngle() {
        this.gyro.reset();
    }

    @Override
    public void periodic() {
    }

    @Override
    public void simulationPeriodic() {
    }
}