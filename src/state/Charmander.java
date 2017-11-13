
package state;

import java.awt.Toolkit;

public class Charmander extends Pokemon {
    private static class CharmanderState implements Pokemon.State {
        @Override
        public String getSpecies() {
            return "Charmander";
        }

        @Override
        public String getAttack() {
            return "ember";
        }

        @Override
        public void makeSound() {
            Toolkit.getDefaultToolkit().beep();
        }

        @Override
        public State evolve() {
            return new CharmeleonState();
        }
    }
    
    private static class CharmeleonState implements Pokemon.State {
        @Override
        public String getSpecies() {
            return "Charmeleon";
        }

        @Override
        public String getAttack() {
            return "flamethrower";
        }

        @Override
        public void makeSound() {
            Toolkit.getDefaultToolkit().beep();
            Toolkit.getDefaultToolkit().beep();
        }

        @Override
        public State evolve() {
            return new CharizardState();
        }
    }

    private static class CharizardState implements Pokemon.State {
        @Override
        public String getSpecies() {
            return "Charizard";
        }

        @Override
        public String getAttack() {
            return "blaze";
        }

        @Override
        public void makeSound() {
            Toolkit.getDefaultToolkit().beep();
            Toolkit.getDefaultToolkit().beep();
            Toolkit.getDefaultToolkit().beep();
        }

        @Override
        public State evolve() {
            return this;
        }
    }
    
    public Charmander(){
        super(new Charmander.CharmanderState());
    }
}
