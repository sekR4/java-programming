import org.apache.commons.csv.*;
import edu.duke.*;

public class CSVReaderV2 {
    public void read_csv(){
        // I wish I could simply use "path/to/data.csv" :/
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord csvRecord : parser) {
            System.out.print(csvRecord.get("x1")+" | ");
            System.out.println(csvRecord.get("x2"));
        }
    }
        
        
    public void main() {
        read_csv();
    }
      
}