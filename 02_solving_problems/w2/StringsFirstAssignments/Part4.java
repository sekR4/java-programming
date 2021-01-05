import edu.duke.*;
import java.io.File;

public class Part4 {

    public String findURL() {

    String regex = "(?i)\"(.+)youtube\\.com(.+)\"";
    URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    // System.out.println("fun");
    for ( String word : ur.words() ) {

        if (word.matches(regex)) {
           return word;
            }
        }
        return "nothing found";
    }

    public void testfindURL() {
        System.out.println(findURL());
    }
}
