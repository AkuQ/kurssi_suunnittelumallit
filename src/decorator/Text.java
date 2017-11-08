
package decorator;

import java.io.File;

public class Text implements TextIF {
    private File file;
    private String text;
    
    
    public Text() {
        //this.file = new File(path);
    }

    @Override
    public void write(String str) {
        this.text = str;
    }

    @Override
    public String read() {
        return this.text;
    }
    
}
