import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyBirths {
    public void printNames(){
        FileResource fr = new FileResource();
        for (CSVRecord row : fr.getCSVParser(false)) {
            String name     = row.get(0);
            String gender   = row.get(1);
            int count     = Integer.parseInt(row.get(2)); // NOTE: 03.02.21 Won't work with big numbers
            
            System.out.println(name+" "+gender+" "+count);
        }
    
    }
    
    public void totalBirths(FileResource fr){
        int total = 0;
        for (CSVRecord row : fr.getCSVParser(false)) {total += Integer.parseInt(row.get(2));}    
        System.out.println(total);
    }

}
