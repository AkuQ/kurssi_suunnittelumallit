
package chain_of_responsibility;

public class Manager extends Superior {

    public Manager(String name, int pay, Superior superior) {
        super(name, pay, superior);
    }

    @Override
    public boolean canApproveRaise(Employee e, int percentage) {
        return this != e && percentage <= 2;
    }
    
}
