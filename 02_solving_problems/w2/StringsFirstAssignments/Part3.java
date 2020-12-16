
/**
 * Write a description of Part3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String a, String b) {
        // Returns true if a appears in b at least twice
        // 'aa', 'baananaa'

        int startAinB = b.indexOf(a);   // 1
        int nextAinB = b.indexOf(a, startAinB + a.length()); // 6
        if (nextAinB != -1) {
            return true;
        }
        else {
            return false;
        }
    }

    public String lastPart(String a, String b) {
        int startAinB = b.indexOf(a);   // 1
        int nextAinB = b.indexOf(a, startAinB + a.length()); // 6
        if (nextAinB != -1) {
            return b.substring(nextAinB,b.length());
        }

        else {
            return b;
        }

    }

    public void testtwoOccurrences() {

        //true
        System.out.println("twoOccurrences(“by”, “A story by Abby Long”)");
        System.out.println(twoOccurrences("by", "A story by Abby Long"));

        //true
        System.out.println("twoOccurrences(“a”, “banana”)");
        System.out.println(twoOccurrences("a", "banana"));

        //false
        System.out.println("twoOccurrences(“atg”, “ctgtatgta”)");
        System.out.println(twoOccurrences("atg", "ctgtatgta"));
    }

    public void testlastPart() {
        // ana
        System.out.println("lastPart(“an”, “banana”)");
        System.out.println(lastPart("an", "banana"));

        // forest
        System.out.println("lastPart(“zoo”, “forest”)");
        System.out.println(lastPart("zoo", "forest"));

    }
}
