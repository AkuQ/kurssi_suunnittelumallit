
package singleton;

public class Main {
    
    public static void main(String[] args) {
        ConfigFile config = ConfigFile.instance();
        
        System.out.println("Loaded content:");
        System.out.println("size = " + config.get("FontSize"));
        System.out.println("color = " + config.get("FontColor"));
        System.out.println("style = " + config.get("FontStyle"));
        System.out.println();
        
        System.out.println("Reset to defaults:");
        config.set("FontSize", "DEFAULT");
        config.set("FontColor", "DEFAULT");
        config.set("FontStyle", "DEFAULT");
        System.out.println("size = " + config.get("FontSize"));
        System.out.println("color = " + config.get("FontColor"));
        System.out.println("style = " + config.get("FontStyle"));
        System.out.println();
        
        config.set("FontSize", "DEFAULT");
        config.set("FontColor", "DEFAULT");
        config.set("FontStyle", "DEFAULT");
        
        System.out.println("Set values using instance handles:");
        ConfigFile config1 = ConfigFile.instance();
        ConfigFile config2 = ConfigFile.instance();
        ConfigFile config3 = ConfigFile.instance();
        
        config1.set("FontSize", "16");
        config2.set("FontColor", "red");
        config3.set("FontStyle", "bold");
        
        System.out.println("size = " + config.get("FontSize"));
        System.out.println("color = " + config.get("FontColor"));
        System.out.println("style = " + config.get("FontStyle"));
    }
}
