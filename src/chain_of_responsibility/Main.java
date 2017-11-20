
package chain_of_responsibility;

public class Main {
    public static void main(String[] args) throws Exception {
        CEO ceo = new CEO("Claude", 12000);
        Director director = new Director("Denise" , 7000, ceo);
        Manager manager = new Manager("Michael", 4000, director);
        Employee employee = new Employee("Eleanor", 2500, manager);
        
        manager.approveRaise(employee, 1);
        manager.approveRaise(employee, 3);
        manager.approveRaise(employee, 100);
        
    }
}
