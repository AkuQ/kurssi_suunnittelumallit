package observer;

import java.util.Date;
import java.util.Observable;

public class Clock extends Observable {
    private Date time;
    
    public Clock() {
        this.updateTime();
    } 
    
    final public void updateTime() {
        this.time = new Date();
        this.setChanged();
        this.notifyObservers();
    }
    
    public Date getTime(){
        return this.time;
    }
}
