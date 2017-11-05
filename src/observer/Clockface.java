package observer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.TimeZone;

public class Clockface implements Observer {
    private Date time;
    final private TimeZone tz;
    final private DateFormat format;
    
    @SuppressWarnings("LeakingThisInConstructor")
    public Clockface(Clock clock, TimeZone tz) {
        this.time = clock.getTime();
        this.tz = tz;
        this.format = new SimpleDateFormat("HH:mm:ss");
        this.format.setTimeZone(tz);
        clock.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Clock) {
            this.time = ((Clock)o).getTime();
        }
    }
  
    public void print(){
        System.out.println(this.tz.getID() + " " + this.format.format(this.time));
    }

   
}
