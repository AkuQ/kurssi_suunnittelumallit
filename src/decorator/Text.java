
package decorator;

public class Text implements TextIF {
    private String text;
    
    @Override
    public void write(String str) {
        this.text = str;
    }

    @Override
    public String read() {
        return this.text;
    }
    
}
