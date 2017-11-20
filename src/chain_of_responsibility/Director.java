
package chain_of_responsibility;

public class Director extends Superior {

    public Director(String name, int pay, Superior superior) {
        super(name, pay, superior);
    }

    @Override
    public boolean canApproveRaise(Employee e, int percentage) {
        return this != e && percentage <= 5;
    }
    
}
