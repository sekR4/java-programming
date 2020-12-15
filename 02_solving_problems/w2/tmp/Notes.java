
/**
 * Write a description of Notes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Notes {

    public static void main(String[] args) {
        String m1 = "Some built-in functions for string operations";
        System.out.println(m1);
        String s = "dukeprogramming";
        System.out.println(s);
        System.out.println(s.substring(4,7));
        System.out.println(s.length());
        System.out.println(s.indexOf("program"));
        System.out.println(s.indexOf("g"));
        System.out.println("If start not found, it returns: " + s.indexOf("f"));
        String m2 = "Look for 'g', beginning with index 8: ";
        System.out.println(m2+s.indexOf("g",8));
        System.out.println(s.startsWith("duke")); // bool


    }
}
