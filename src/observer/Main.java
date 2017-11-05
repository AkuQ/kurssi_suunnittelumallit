
package observer;

import static java.lang.Thread.sleep;
import java.util.TimeZone;

public class Main {
    
    @SuppressWarnings("SleepWhileInLoop")
    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        Clockface[] clockfaces = {
            new Clockface(clock, TimeZone.getTimeZone("Europe/Oslo")),
            new Clockface(clock, TimeZone.getTimeZone("Europe/Stockholm")),
            new Clockface(clock, TimeZone.getTimeZone("Europe/Helsinki")),
            new Clockface(clock, TimeZone.getTimeZone("Europe/Moscow")),
        };
        
        while (true) {
            System.out.println("tick (every 3 sec)");
            clock.updateTime();
            for(Clockface c : clockfaces) {
                c.print();
            }
            sleep(3000);
        }
    } 
}
