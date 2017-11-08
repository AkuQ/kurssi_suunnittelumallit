
package decorator;

public class Main {
    public static void main(String[] args) {
        Text text = new Text();
        TextCrypter crypted = new TextCrypter(text);
        crypted.write("Hello world!");
        
        System.out.println(text.read());
        System.out.println(crypted.read());
    }
}
