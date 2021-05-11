/**
 *
 * An outline for a class with methods to encrypt and descrypt a string using
 * Caesar's Cipher. The class' methods limit encryption/decryption to the
 * alphabetical symbols in a string, i.e, letters a-z (lower case) and A-Z (upper).
 *
 * This version of the class implements separate encryption and decryption methods
 * for illustrative purposes. The methods in this version deal only with upper
 * case letters. A design decision was made to execute the methods only when
 *    0 <= ABS(key) < 26
 * A discussion with students covered the usefulness of modulo arithmetic that may
 * allow the use of any key, in a future implementation.
 */
public class CaesarTemplate {

    // Some useful constants ... we'll use them later
    private static final int LETTERS_IN_ALPHABET = 26;
    private static final int ASCII_a = (int) 'a'; // lower case a  (97)
    private static final int ASCII_z = (int) 'z'; // lower case z (122)
    private static final int ASCII_A = (int) 'A'; // upper case A  (65)
    private static final int ASCII_Z = (int) 'Z'; // upper case Z  (90)

    /**
     * A method to encrypt a given string using Caesar Cipher based on
     * the encryptionKey also passed as an argument to the method. The
     * method encrypts upper case letters only, for now.
     * @param message The String to encrypt
     * @param encryptionKey the cipher key (must be 0-26)
     * @return a String with the encrypted message
     */
    public static String encrypt(String message, int encryptionKey) {
        // Let's store the encrypted message in the following (empty for now) String
        String encryptedMessage = "** INVALID ENCRYPTION KEY **";

        // Decide if the key is acceptable

        if ( encryptionKey < LETTERS_IN_ALPHABET ) {
            encryptedMessage = "";
        /*
         For each character in input String message, find its numeric code,
         decide if the code needs to be "shifted" or remain as is, and then
         use that value to obtain a new (shifted) or the same character, and
         add it to the encrypted message.
         */
            for (int position = 0; position < message.length(); position++) {
                // Obtain the character at this position
                char characterToEncrypt = message.charAt(position);
                // Obtain the numeric code of the character
                int numericCode = (int) characterToEncrypt;
                // Assume that this character will not be encrypted,
                // by setting its encrypted numeric code to its current numeric code
                int encryptedNumericCode = numericCode;
                // Check to see if this numeric code corresponds to an upper case letter.
                // Remember, ASCII_A and ASCII_Z are constants for the numeric values
                // of characters A and Z (65 and 90 respectively). A numeric code between
                // these values is guaranteed to be an upper case letter.
                if (numericCode >= ASCII_A && numericCode <= ASCII_Z) {
                    // This is an upper case letter, so let's encrypt it by modifying
                    // by changing the value of encryptedNumericCode
                    encryptedNumericCode = numericCode + encryptionKey;
                    // Let's check that we are not passed the end of the alphabet
                    if (encryptedNumericCode > ASCII_Z) {
                        // Darn .. we are past Z ... left's fold around
                        encryptedNumericCode = encryptedNumericCode - LETTERS_IN_ALPHABET;
                    /*
                     The technique above IS A BUG !!! If the encryptionKey is large
                     e.g., 100, the encrypted numeric code, even after the subtraction
                     by 26, may be too much! The range of integer values for characters
                     is from 0 to 127. We need to correct this bug and ensure that any
                     encrypted value remained in the range from 65 to 90. There are two
                     ways to do so: (a) by limiting the value of encryption key to a max
                     of 25, and keeping the subtraction above as the corrective action,
                     or (b) to use a different corrective action, so no matter how large
                     the encryption key is, the encryptedNumericCode is always folded
                     back to the range 65-90.
                     */
                    }
                }
                // At this point the value of encryptedNumericCode is either
                // the initial value of the current character's numeric code
                // (because the character is not an upper case letter) or a
                // a modified value that still points to a different (encrypted)
                // upper case letter. Let's convert it to a character:
                char encryptedCharacter = (char) encryptedNumericCode;
                // Add this newly encrypted character to the encrypted message
                encryptedMessage = encryptedMessage + encryptedCharacter;
            }
        }
        //  Return the encrypted message
        return encryptedMessage;
    } // method encrypt


    /**
     * A method to encrypt a given string using Caesar Cipher based on
     * the decryptionKey also passed as an argument to the method. The
     * method encrypts upper case letters only, for now.
     * @param message The String to encrypt
     * @param decryptionKey the cipher key (must be 0-26)
     * @return a String with the encrypted message
     */
    public static String decrypt(String message, int decryptionKey) {
        // Let's store the encrypted message in the following (empty for now) String
        String decryptedMessage = "** INVALID DECRYPTION KEY **";

        // Decide if the key is acceptable

        if ( decryptionKey > -LETTERS_IN_ALPHABET ) {
            decryptedMessage = "";
        /*
         For each character in input String message, find its numeric code,
         decide if the code needs to be "shifted" or remain as is, and then
         use that value to obtain a new (shifted) or the same character, and
         add it to the encrypted message.
         */
            for (int position = 0; position < message.length(); position++) {
                // Obtain the character at this position
                char characterToDecrypt = message.charAt(position);
                // Obtain the numeric code of the character
                int numericCode = (int) characterToDecrypt;
                // Assume that this character will not be encrypted,
                // by setting its encrypted numeric code to its current numeric code
                int decryptedNumericCode = numericCode;
                // Check to see if this numeric code corresponds to an upper case letter.
                // Remember, ASCII_A and ASCII_Z are constants for the numeric values
                // of characters A and Z (65 and 90 respectively). A numeric code between
                // these values is guaranteed to be an upper case letter.
                if (numericCode >= ASCII_A && numericCode <= ASCII_Z) {
                    // This is an upper case letter, so let's encrypt it by modifying
                    // by changing the value of decryptedNumericCode
                    decryptedNumericCode = numericCode + decryptionKey;
                    // Let's check that we are not passed the end of the alphabet
                    if (decryptedNumericCode < ASCII_A) {
                        // Darn .. we are way before A ... left's fold around
                        decryptedNumericCode = decryptedNumericCode + LETTERS_IN_ALPHABET;
                    /*
                     The technique above IS A BUG !!! If the decryptionKey is large
                     e.g., 100, the encrypted numeric code, even after the subtraction
                     by 26, may be too much! The range of integer values for characters
                     is from 0 to 127. We need to correct this bug and ensure that any
                     encrypted value remained in the range from 65 to 90. There are two
                     ways to do so: (a) by limiting the value of encryption key to a max
                     of 25, and keeping the subtraction above as the corrective action,
                     or (b) to use a different corrective action, so no matter how large
                     the encryption key is, the decryptedNumericCode is always folded
                     back to the range 65-90.
                     */
                    }
                }
                // At this point the value of decryptedNumericCode is either
                // the initial value of the current character's numeric code
                // (because the character is not an upper case letter) or a
                // a modified value that still points to a different (decrypted)
                // upper case letter. Let's convert it to a character:
                char decryptedCharacter = (char) decryptedNumericCode;
                // Add this newly encrypted character to the encrypted message
                decryptedMessage = decryptedMessage + decryptedCharacter;
            }
        }
        //  Return the encrypted message
        return decryptedMessage;
    } // method decrypt

    /**
     * This method provides a verbose, step by step demonstration
     * of the Caesar Cipher encryption. It may not be my finest
     * programming job, but it does produce a decent demonstration.
     * @param message The String to encrypt
     * @param encryptionKey the cipher key
     */
    public static void howEncryptWorks(String message, int encryptionKey) throws InterruptedException {
        int interLinePause = 250; // how many msec to pause between printouts?
        System.out.printf("\n\nYou are asking to encrypt the following message:" +
                        "\n\t%s\nusing Caesar Cipher with a key" +
                        " of %d",
                message, encryptionKey);
        System.out.printf("\n\nWe start by looking at every symbol (character) in the message:\n\n");
        System.out.println("Position\tCharacter\tCode\tLetter?\t\tEncoded\t\t\tOutside\t\tEncrypted");
        System.out.println("in string\t\t\t\tvalue\t(y/n)\t\tvalue\t\t\tof A-Z?\t\tcharacter");
        System.out.println("---------\t---------\t-----\t--------\t-------------\t-------\t\t---------");
        String encrypted = "";
        for (int i = 0; i < message.length(); i++) {
            Thread.sleep(5*interLinePause); // longer pause at the beginning of a new line
            char c = message.charAt(i);
            int clearCode = (int) c;
            int enCode = clearCode;
            System.out.printf("%2d",i); Thread.sleep(interLinePause);
            System.out.printf("\t\t\t%5s",c); Thread.sleep(interLinePause);
            System.out.printf("\t\t%3d",clearCode); Thread.sleep(interLinePause);
            String isItALetter = "No";
            String outsideZ  = "";
            String note = "";
            String newValue = String.format("Same (=%d+0)",clearCode);
            if ( clearCode >= 65 && clearCode <= 90 ) {
                isItALetter = "Yes";
                enCode = clearCode + encryptionKey;
                newValue = String.format("%4d (=%d+%d)",enCode,clearCode,encryptionKey);
                outsideZ = "No";
                note = String.format("(Using code %d)",enCode);
                System.out.printf("\t\t%5s",isItALetter); Thread.sleep(interLinePause);
                System.out.printf("\t\t%s",newValue); Thread.sleep(interLinePause);
                if ( enCode > 90 ) {
                    enCode = enCode-26;
                    outsideZ = "Yes";
                    note = String.format("(Using code %d-26=%d)",enCode+26,enCode);
                }
                System.out.printf("\t%6s",outsideZ); Thread.sleep(interLinePause);
            }
            char newChar = (char) enCode;
            encrypted += newChar;
            System.out.printf("\t\t%s",newChar); Thread.sleep(interLinePause);
            System.out.printf(" %s\n", note); Thread.sleep(interLinePause*5);
            Thread.sleep(500);
        }
        System.out.printf("\n\nYou successfully encrypted: %s\n" +
                "                        to: %s\n",message,encrypted);
    } // method howEncryptWorks

    public static void main(String[] args) throws InterruptedException {
        int key = 20;
        String inputMessage = "HELLO WORLD";
        String encrypted = encrypt(inputMessage,key);
        String decrypted = decrypt(encrypted,-key); // Note the minus sign
        System.out.println("            You entered: " + inputMessage + " and a key of "+key);
        System.out.println("    it was encrypted to: " + encrypted +" (using the encrypt() method).");
        System.out.println("and it was decrypted to: " + decrypted +" (using the decrypt() method).");
    }
} // class CaesarTemplate
