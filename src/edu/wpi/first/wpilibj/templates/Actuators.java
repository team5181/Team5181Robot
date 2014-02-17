
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Actuators {

    private final Talon frontLeft;
    private final Talon rearLeft;
    private final Talon frontRight;
    private final Talon rearRight;
    
    private final Relay magLockRelay;
    private final Relay ballLoadRelay;
    
    private final Compressor compressor;
    private final DoubleSolenoid solenoid;
    
    public Actuators() {
        
        frontLeft = new Talon(StaticVars.FRONT_LEFT_MOTOR);
        rearLeft = new Talon(StaticVars.REAR_LEFT_MOTOR);
        frontRight = new Talon(StaticVars.FRONT_RIGHT_MOTOR);
        rearRight = new Talon(StaticVars.REAR_RIGHT_MOTOR);
        
        magLockRelay = new Relay(StaticVars.MAG_LOCK_RELAY_CHANNEL);
        ballLoadRelay = new Relay(StaticVars.BALL_LOAD_RELAY_CHENNEL);
        
        compressor = new Compressor(StaticVars.PRESSURE_SWITCH_CHANNEL, StaticVars.COMPRESSOR_RELAY_CHANNEL);
        solenoid = new DoubleSolenoid(StaticVars.DOUBLE_SOLENOID_FORWARD_CHANNEL,
                                      StaticVars.DOUBLE_SOLENOID_REVERSE_CHANNEL);
    }
    
    public void turnMagLockOff() {
        magLockRelay.set(Relay.Value.kOff);
    }
    
    public void turnMagLockOn() {
        magLockRelay.set(Relay.Value.kOn);
    }
    
    public void setBallLoadRelayForward() {
        ballLoadRelay.set(Relay.Value.kForward);
    }
    
    public void setBallLoadRelayReverse() {
        ballLoadRelay.set(Relay.Value.kReverse);
    }
    
    public void setballLoadRelayOff() {
        ballLoadRelay.set(Relay.Value.kOff);
    }
    
    public void startCompressor() {
        compressor.start();
    }
    
    public void stopCompressor() {
        compressor.stop();
    }
    
    public void setSolenoidForward() {
        solenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void setSolenoidReverse() {
        solenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void setSolenoidOff() {
        solenoid.set(DoubleSolenoid.Value.kOff);
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
                        return null;
                    }
                }
            }
        }
    }
}
