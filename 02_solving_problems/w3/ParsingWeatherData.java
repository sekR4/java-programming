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
                if (current_temperature != -9999){lowest = row;} // NOTE: avoid garbage data & short circuit eval
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
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println(coldest.get("TemperatureF") + " " + coldest.get("TimeEST"));
    }
    
    public String fileWithColdestTemperature(){
        // Returns name of file with minimum temperature
        
        CSVRecord lowest = null;
        String filename = "";
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord row = coldestHourInFile(fr.getCSVParser());
            lowest = minOf2(lowest,row);
            if (row == lowest){
                filename = f.getAbsolutePath();
            }
        }
        return filename;
    }

    public void testFileWithColdestTemperature(){
        File file = new File(fileWithColdestTemperature());
        System.out.println(file.getName());
        
        FileResource fr = new FileResource(file);
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        
        System.out.println(fr);
        System.out.println(coldest.get("TemperatureF"));
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord row : parser) {
            System.out.println(row.get("DateUTC") +": "+row.get("TemperatureF"));
        }
    
    }
}
