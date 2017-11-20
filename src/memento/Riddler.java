
package memento;

public class Riddler {
    private class Memento {
        public int number;
        public Memento(int number){
            this.number = number;
        }
    }
    
    public Object joinGame(Client c) {
        int rand = 1 + (int)(Math.random() * 10.0);
        return new Memento(rand);
    }
    
    public boolean guess(Client c, int i, Object memento) {
        return ((Memento)memento).number == i;
    }
    
}
