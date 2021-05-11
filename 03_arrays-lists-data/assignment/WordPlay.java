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
        return "";
    }

    public void test_isVowel() {
        char ch = "F".charAt(0);
        assert isVowel(ch) == false : "F is not a vowel.";

        ch = "a".charAt(0);
        assert isVowel(ch) == true : "A is a vowel.";

        System.out.println("passed test_isVowel()");
    }

    // public static void main(String args[]) {

    // }
}
