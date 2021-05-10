import edu.duke.*;

public class CeasarCipher {
    public String encrypt(String input, int key) {

        StringBuilder message = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted_alphabet = alphabet.substring(key) + alphabet.substring(0, key);

        for (int i = 0; i < message.length(); i++) {

            char current_char = Character.toUpperCase(message.charAt(i));
            int idx = alphabet.indexOf(current_char); // -1 if char not in alphabet

            if (idx != -1) {
                char new_char = shifted_alphabet.charAt(idx);
                message.setCharAt(i, new_char);
            }

        }

        return message.toString();
    }

    public void test_Ceasar() {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26 - key);
        System.out.println(decrypted);

    }
}