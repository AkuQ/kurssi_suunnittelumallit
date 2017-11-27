
package builder;

public class Director {
    private BurgerBuilder builder;
    private Burger burger;
    
    public Director(BurgerBuilder builder){
        this.builder = builder;
    }
    
    public void constructBurger() {
        this.builder.buildBuns();
        this.builder.buildPatty();
        this.builder.buildCondiment();
        this.builder.buildFilling();
        this.burger = this.builder.getBurger();
    }
    
    public Burger getBurger() {
        return this.burger;
    }
}
