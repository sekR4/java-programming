import edu.duke.*;

public class WordPlay {
    boolean isVowel(char ch) {

        String vowels = "AEIOU";
        int idx = vowels.indexOf(Character.toUpperCase(ch));

        if (idx != -1) {
            return true;
        } else {
            return false;
        }
    }

    String replaceVowels(String phrase, char ch) {

        StringBuilder phrase_ = new StringBuilder(phrase);

        for (int i = 0; i < phrase_.length(); i++) {
            char current_char = phrase_.charAt(i);
            if (isVowel(current_char)) {
                phrase_.setCharAt(i, ch);
            }
        }
        return phrase_.toString();
    }

    String emphasize(String phrase, char ch) {

        StringBuilder phrase_ = new StringBuilder(phrase);

        for (int i = 0; i < phrase_.length(); i++) {
            char current_char = Character.toUpperCase(phrase_.charAt(i));
            if (current_char == Character.toUpperCase(ch)) {
                if (((i + 1) & 1) == 0) {
                    phrase_.setCharAt(i, "+".charAt(0));
                } else {
                    phrase_.setCharAt(i, "*".charAt(0));
                }
            }

        }
        return phrase_.toString();
    }

    // Tests

    public void test_isVowel() {
        char ch = "F".charAt(0);
        assert isVowel(ch) == false : "F is not a vowel.";

        ch = "a".charAt(0);
        assert isVowel(ch) == true : "A is a vowel.";

        System.out.println("passed test_isVowel()");
    }

    public void test_replaceVowels() {
        char ch = "*".charAt(0);
        assert replaceVowels("Hello World!", ch).equals("H*ll* W*rld!") : "Replacement did not work";
        System.out.println("passed test_replaceVowels()");
    }

    public void test_emphasize() {
        char ch = "a".charAt(0);
        // System.out.println(emphasize("dna ctgaaactga", ch));
        // System.out.println(emphasize("Mary Bella Abracadabra", ch));
        assert emphasize("dna ctgaaactga", ch).equals("dn* ctg+*+ctg+") : "Emphasis didn't work";
        assert emphasize("Mary Bella Abracadabra", ch).equals("M+ry Bell+ +br*c*d*br+") : "Emphasis didn't work";

        System.out.println("passed test_emphasize()");
    }
    //

    // public static void main(String args[]) {

    // }
}
