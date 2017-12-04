
package prototype;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Clock implements Cloneable {
    static private class Hand implements Cloneable {
        int pos, max;
        Hand next;
        
        Hand(int max, Hand next){
            this(max);
            this.next = next;
        }
        
        Hand(int max){
            this.pos = 0;
            this.max = max;
        }
        
        void tick(){
            this.pos++;
            if(this.pos == max) {
                this.pos = 0;
                if(this.next != null) 
                    next.tick();
            }
        }
        
        @Override
        public Hand clone(){
            try {
                return (Hand)super.clone();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    }
    
    private Hand seconds, minutes, hours;
    
    public Clock(){
        this.hours = new Hand(24);
        this.minutes = new Hand(60, this.hours);
        this.seconds = new Hand(60, this.minutes);
    }
    
    private Clock(Clock original){
        this.hours = original.hours.clone();
        this.minutes = original.minutes.clone();
        this.seconds = original.seconds.clone();
        
        this.seconds.next = this.minutes;
        this.minutes.next = this.hours;
    }
    
    public void tick(){
        this.seconds.tick();
    }
    
    public void print(){
        System.out.format(
                "%02d:%02d:%02d\n", 
                this.hours.pos, 
                this.minutes.pos, 
                this.seconds.pos
        );
    }
    
    @Override
    public Clock clone(){
        return new Clock(this);
    }
}
