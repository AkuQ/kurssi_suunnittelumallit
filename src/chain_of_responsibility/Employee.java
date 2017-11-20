
package chain_of_responsibility;

public class Employee {
    private String name;
    private int pay;
    private Superior superior;
    
    public Employee(String name, int pay, Superior superior) {
        this.name = name;
        this.pay = pay;
        this.superior = superior;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getPay(){
        return this.pay;
    }
    
    public Superior getSuperior() {
        return this.superior;
    }
    
    protected void giveRaise(int percentage) {
        this.pay *= 1.0 + (float)percentage * 0.01;
    }
}
