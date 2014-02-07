
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;

public class Actuators {

    private final Talon frontLeft;
    private final Talon rearLeft;
    private final Talon frontRight;
    private final Talon rearRight;
    
    private final Jaguar turretMotor;
    
    public Actuators() {
        
        frontLeft = new Talon(StaticVars.FRONT_LEFT_MOTOR);
        rearLeft = new Talon(StaticVars.REAR_LEFT_MOTOR);
        frontRight = new Talon(StaticVars.FRONT_RIGHT_MOTOR);
        rearRight = new Talon(StaticVars.REAR_RIGHT_MOTOR);
        
        turretMotor = new Jaguar(StaticVars.TURRET_MOTOR);
    }
    
    /**
     * I decided to use nested if-else statements to better encapsulate motor channels.
     * @param motorChannel
     * @return SpeedController (Jaguar, Talon, Victor)
     */
    public SpeedController getMotorController(int motorChannel) {
        if (motorChannel == StaticVars.FRONT_LEFT_MOTOR) {
            return frontLeft;
        } else {
            if (motorChannel == StaticVars.REAR_LEFT_MOTOR) {
                return rearLeft;
            } else {
                if (motorChannel == StaticVars.FRONT_RIGHT_MOTOR) {
                    return frontRight;
                } else {
                    if (motorChannel == StaticVars.REAR_RIGHT_MOTOR) {
                        return rearRight;
                    } else {
                        if (motorChannel == StaticVars.TURRET_MOTOR)
                            return turretMotor;
                        else {
                            return null;
                        }
                    }
                }
            }
        }
    }
}
