
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Timer;

public class Turret {
    
    boolean triggerPulled;
    boolean reloading;
    boolean pushTimerStarted;
    boolean pullTimerStarted;
    Timer reloadTimer;
    Actuators actuators;
    
    public Turret(Actuators actuators) {
        this.actuators = actuators;
        reloadTimer = new Timer();
    }
    public void setTriggerPull(boolean isPulled){
        if (isPulled)
            actuators.turnMagLockOff();
        else actuators.turnMagLockOn();
    }
    
    public void reloadInit() {
        if(!reloading) {
            reloading = true;
            reloadTimer.start();
            pushTimerStarted = true;
            pullTimerStarted = false;
            actuators.setReloadRelayForward();
        }
    }
    public void reloadUpdate() {
        if (reloading){
            if (pushTimerStarted == true){
                if(reloadTimer.get() > StaticVars.PUSH_TIME_LIMIT) {
                    actuators.setReloadRelayReverse();
                    pushTimerStarted = false;
                    pullTimerStarted = true;
                    reloadTimer.reset();
                    reloadTimer.start();
                } else actuators.setReloadRelayForward();
            } else {
                if (pullTimerStarted ==true){
                    if(reloadTimer.get() > StaticVars.PULL_TIME_LIMIT){
                        actuators.setReloadRelayStop();
                        pushTimerStarted = false;
                        pullTimerStarted = false;
                        reloading =false;
                        reloadTimer.reset();    
                    } else actuators.setReloadRelayReverse();
                }
            }
        }
    }
}
