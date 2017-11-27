
package builder;

public class Hesburger implements BurgerBuilder {
    private Burger burger = new Burger();
    
    @Override
    public void buildBuns() {
        this.burger.setBuns("barley");
    }

    @Override
    public void buildCondiment() {
        this.burger.setCondiment("mayonnase");
    }

    @Override
    public void buildPatty() {
        this.burger.setPatty("chicken");
    }

    @Override
    public void buildFilling() {
        this.burger.setFilling("egg & salad");
    }

    @Override
    public Burger getBurger() {
        Burger burger = this.burger;
        this.burger = new Burger();
        return burger;
    }
    
}
