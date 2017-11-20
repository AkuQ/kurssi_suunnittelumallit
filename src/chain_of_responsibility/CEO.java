
package chain_of_responsibility;

public class CEO extends Superior {
    
    public CEO(String name, int pay) {
        super(name, pay, null);
    }

    @Override
    public boolean canApproveRaise(Employee e, int percentage) {
        return true;
    }
}
