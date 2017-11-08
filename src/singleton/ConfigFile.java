
package singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConfigFile {
    private static final ConfigFile INSTANCE = new ConfigFile();
    private final HashMap<String, String> config;
    private final File file;
    
    private ConfigFile() {
        this.file = new File("config.ser");
        HashMap config;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(this.file))) {
            config = (HashMap)input.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            config = new HashMap();
        }
        this.config = config;
    }
    
    public static ConfigFile instance() {return INSTANCE; }

    void set(String key, String value) {
        this.config.put(key, value);
        try (
                FileOutputStream fos = new FileOutputStream(this.file); 
                ObjectOutputStream oos = new ObjectOutputStream(fos)) 
        {
            oos.writeObject(this.config);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(ConfigFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    String get(String key) {
        return this.config.getOrDefault(key, "DEFAULT");
    }

}
