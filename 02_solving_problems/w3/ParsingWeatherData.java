import org.apache.commons.csv.*;
import edu.duke.*;
import java.io.*;

public class ParsingWeatherData {
    
    public CSVRecord minOf2(CSVRecord lowest, CSVRecord row){
        if (lowest == null){lowest = row;}
        else {
            double current_temperature = Double.parseDouble(row.get("TemperatureF"));
            double minimum_temperature = Double.parseDouble(row.get("TemperatureF"));
            if(current_temperature < minimum_temperature){
                if (current_temperature != -9999){lowest = row;}
            }
        }
        return lowest;
    }
      
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord lowest = null;
        for (CSVRecord row : parser) {
            lowest = minOf2(lowest,row);
        }
        return lowest;
    }
    
    public void testColdestHourInFile(){
        FileResource fr = new FileResource("nc_weather/2012/weather-2012-01-01.csv");
        CSVRecord largest = coldestHourInFile(fr.getCSVParser());
        System.out.println(largest.get("TemperatureF") + " " + largest.get("TimeEST"));
    }
    
    public String fileWithColdestTemperature(){
        
        CSVRecord lowest = null;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord current = coldestHourInFile(fr.getCSVParser());
        }
    return "";
    }

}
