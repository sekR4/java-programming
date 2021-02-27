import org.apache.commons.csv.*;
import edu.duke.*;

public class ExportsFromCSV {

    public void WhichCountryExports(String commodity){
        // prints countries exporting a certain commodity
        // NOTE:23.02.21 Code will break if wrong CSV
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord csvRecord : parser) {
            String exports = csvRecord.get("Exports");
            if (exports.indexOf(commodity) != -1) {
                // alternative: exports.contains(commodity) - standard string method
                System.out.println(csvRecord.get("Country"));
            }
        }
    }
    
    public String countryInfo(CSVParser parser, String country){
        for (CSVRecord csvRecord : parser) {
            String CSVcountry = csvRecord.get("Country");
            if (CSVcountry.contains(country)){
                return CSVcountry+": "+csvRecord.get("Exports")+": "+csvRecord.get("Value (dollars)");
            }     
        }
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for (CSVRecord csvRecord : parser) {
            String exports = csvRecord.get("Exports");
            if (exports.contains(exportItem1)){
                if (exports.contains(exportItem2)) {
                    System.out.println(csvRecord.get("Country"));
                }
            }
        
        }
    
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int cnt = 0;
        for (CSVRecord csvRecord : parser) {
            String exports = csvRecord.get("Exports");
            if (exports.contains(exportItem)) {cnt += 1;}
        }
        return cnt;
    }
    
    public void bigExporters(CSVParser parser,String amount){
        for (CSVRecord csvRecord : parser) {
            String value = csvRecord.get("Value (dollars)");
            if (value.length() > amount.length()) {System.out.println(csvRecord.get("Country") +" " + value);}
        }
    }
       
    
    public void testing(CSVParser parser, String country) {
        for (CSVRecord csvRecord : parser) {
            if (csvRecord.get("Country").equals(country)) {
                System.out.println("Match");}
        }
    }

        
    public void main() {
        // String lookfor = "coffee";
        // WhichCountryExports(lookfor);
        
        // Exercise: Parsing Export
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser, "Nauru"));  
        // listExportersTwoProducts(parser, "coffee", "tea");
        // System.out.println(numberOfExporters(parser, "gold"));
        bigExporters(parser,"$999,999,999,999");
        //testing(parser, "Germany");
        //listExportersTwoProducts(parser, "fish", "nuts");
        

    }
      
}