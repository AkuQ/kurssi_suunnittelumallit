
package builder;

public interface BurgerBuilder {

    public void buildBuns();
    public void buildCondiment();
    public void buildPatty();
    public void buildFilling();
    public Burger getBurger();
}
