
package state;

public abstract class Pokemon {
    protected static interface State {
        public String getSpecies();
        public String getAttack();
        public void makeSound();
        public State evolve();
    }
    State state;
    
    protected Pokemon(State state) {
        this.state = state;
    }
    
    public final String getSpecies(){
        return this.state.getSpecies();
    }
    
    public final void makeSound(){
        this.state.makeSound();
    }
    
    public final String getAttack(){
        return this.state.getAttack();
    }
    
    public final void evolve() {
        this.state = this.state.evolve();
    }
}
