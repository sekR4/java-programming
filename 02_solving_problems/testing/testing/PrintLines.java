import edu.duke.FileResource;

public class PrintLines {
    public void LinesIter() {
        FileResource f;
        f = new FileResource("README.TXT");
        for (String line : f.lines()) {
            System.out.println(line);
        }
    }
    public static void main(String[] args) {
        PrintLines x = new PrintLines();
        x.LinesIter();
 
    }
}
