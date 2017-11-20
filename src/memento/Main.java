
package memento;

public class Main {
    public static void main(String[] args) {
        Riddler game = new Riddler();
        Client a = new Client("A", game);
        Client b = new Client("B", game);
        Client c = new Client("C", game);
        
        a.start();
        b.start();
        c.start();
    }
}
