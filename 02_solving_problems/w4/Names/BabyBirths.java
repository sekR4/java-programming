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
        
        int n_boys = 0;
        int n_girls = 0;
        
        for (CSVRecord row : fr.getCSVParser(false)) {     
            if (row.get(1).equals("M")) {n_boys += Integer.parseInt(row.get(2));}
            else {n_girls += Integer.parseInt(row.get(2));}
        }
        
        System.out.println("Total: "+ (n_boys+n_girls) +" Boys: "+n_boys+" Girls: "+n_girls);
    }
    
    public void testTotalBirths(){
        String path = "../us_babynames/us_babynames_by_year/yob2014.csv";
        FileResource fr = new FileResource(path);
        totalBirths(fr);
    
    }

}
