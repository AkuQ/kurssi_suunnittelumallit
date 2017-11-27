
package builder;

public class Main {
    public static void main(String[] args) {
        Hesburger h = new Hesburger();
        Director dh = new Director(h);
        dh.constructBurger();
        System.out.println(dh.getBurger());
        
        McDonalds mc = new McDonalds();
        Director dmc = new Director(mc);
        dmc.constructBurger();
        System.out.println(dmc.getBurger());
    }
}
