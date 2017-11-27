
package builder;

import java.util.HashMap;

public class McDonalds implements BurgerBuilder {
    private HashMap<String,String> parts = new HashMap();

    @Override
    public void buildBuns() {
        this.parts.put("buns", "wholewheat");
    }

    @Override
    public void buildCondiment() {
        this.parts.put("condiment", "ketchup"); 
    }

    @Override
    public void buildPatty() {
         this.parts.put("patty", "groundbeef");
    }

    @Override
    public void buildFilling() {
         this.parts.put("filling", "cheddar & salad");
    }

    @Override
    public Burger getBurger() {
        Burger burger = new Burger(
                this.parts.get("buns"),
                this.parts.get("patty"),
                this.parts.get("filling"),
                this.parts.get("condiment")
        );
        this.parts = new HashMap();
        return burger;
    }
    
}
