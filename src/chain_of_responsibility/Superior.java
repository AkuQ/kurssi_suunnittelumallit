
package chain_of_responsibility;

abstract class Superior extends Employee {

    public Superior(String name, int pay, Superior superior) {
        super(name, pay, superior);
    }
    
    public void approveRaise(Employee e, int percentage) throws Exception {
        if(this.canApproveRaise(e ,percentage)) {
            e.giveRaise(percentage);
            System.out.println(this.getName() + " gave " + e.getName() + " a " 
                    + percentage + "% raise, " + e.getPay() + "€");
        }
        else if(this.getSuperior() != null) {
            this.getSuperior().approveRaise(e, percentage);
        }
        else {
            throw new Exception("Broken chain of responsibility");
        }
    }
    
    abstract protected boolean canApproveRaise(Employee e, int percentage);
}
