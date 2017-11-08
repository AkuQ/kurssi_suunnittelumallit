
package decorator;

import java.security.Key;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;

public class TextCrypter implements TextDecorator {
    private final TextIF decoree;
    private Cipher encrypt_cipher, decrypt_cipher;
    
    public TextCrypter(TextIF f) {
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            keygen.init(128);
            Key key = keygen.generateKey();
            this.encrypt_cipher = Cipher.getInstance("AES");
            this.encrypt_cipher.init(Cipher.ENCRYPT_MODE, key);
            this.decrypt_cipher = Cipher.getInstance("AES");
            this.decrypt_cipher.init(Cipher.DECRYPT_MODE, key);
        } catch (Exception ex) {
            Logger.getLogger(TextCrypter.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.decoree = f;
    }

    @Override
    public void write(String str) {
        try {
            byte[] encrypted = this.encrypt_cipher.doFinal(str.getBytes());
            decoree.write(Base64.getEncoder().encodeToString(encrypted));
        } catch (IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(TextCrypter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String read() {
        try {
            byte[] bytes = Base64.getDecoder().decode(decoree.read());
            bytes = this.decrypt_cipher.doFinal(bytes);
            return new String(bytes);
        } catch (IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(TextCrypter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
