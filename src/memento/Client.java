
package memento;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends Thread {
    private String name;
    private Riddler game;
    private Object memento; 
    
    public Client(String name, Riddler game) {
        this.name = name;
        this.game = game;
    }
    
    public void run(){
        this.memento = this.game.joinGame(this);
        boolean done = false;
        
        while (!done) { 
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int rand = 1 + (int)(Math.random() * 10.0);
            
            if(this.game.guess(this, rand, memento)) {
                System.out.println(this.name + " guessed correctly!");
                done = true;
            }
            else {
                System.out.println(this.name + " guessed " + rand);
            }
        }
        
    }
}
