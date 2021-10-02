/**
 * Demo class for implementing Caesar Cipher encryption and decryption.
 */
public class CaesarCipher {

    public static String encrypt(String message, int key) {
        int encryptedChar = 0;
        String encryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            encryptedChar = (int) c;
            if ( (c>='a' && c<='z') ) {
                encryptedChar = key + (int) c;
                if ( encryptedChar > 'z' ) {
                    encryptedChar = encryptedChar-26;
                }
            }
            if ( (c>='A' && c<='Z') ) {
                encryptedChar = key + (int) c;
                if (encryptedChar > 'Z') {
                    encryptedChar = encryptedChar - 26;
                }
            }
            encryptedMessage = encryptedMessage + (char) encryptedChar;
        }
        return encryptedMessage;
    }

    public static String decrypt(String message, int key) {
        int decryptedChar = 0;
        String decryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            decryptedChar = (int) c;
            if ( c>='a' && c<='z') {
                decryptedChar = -key + decryptedChar;
                if ( decryptedChar < 'a' ) {
                    decryptedChar = decryptedChar + 26;
                }
            }
            if ( c>='A' && c<='Z' ) {
                decryptedChar = -key + decryptedChar;
                if ( decryptedChar < 'A' ) {
                    decryptedChar = decryptedChar + 26;
                }
            }
            decryptedMessage = decryptedMessage + (char) decryptedChar;
        }
        return decryptedMessage;
    }

    /** Driver method */
    public static void main(String[] args) {
        String s = "Hello world!";
        for (int i = 1; i <= 52; i++) {
            String e = encrypt(s,i);
            String d = decrypt(e,i);
            System.out.printf("\nTrying key %2d: %s --> %s --> %s", i,s,e,d);
        }
    } // method main
}
