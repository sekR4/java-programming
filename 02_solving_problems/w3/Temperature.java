import org.apache.commons.csv.*;
import edu.duke.*;

public class Temperature {
    
    public double max(String column){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();   
        double max_value = -100.0;
        for (CSVRecord csvRecord : parser) {
                double value = Double.parseDouble(csvRecord.get(column));
                if (value > max_value){
                    max_value = value;
                }
        }
        
        return max_value;
    }

    
    public CSVRecord MaxV2(CSVParser parser) {
        /* Returns the whole CSVRecord with highest temperature*/
        CSVRecord maxTemp = null;  
        for (CSVRecord csvRecord : parser) {
            if(maxTemp == null){maxTemp=csvRecord;}
            else {
                double current_tmp =  Double.parseDouble(csvRecord.get("TemperatureF"));
                double Temp_max =  Double.parseDouble(maxTemp.get("TemperatureF"));
                if (current_tmp > Temp_max){maxTemp=csvRecord;}
            }
        }
    
        return maxTemp;
    }

    
    public void testHottestInDay(){
        FileResource fr = new FileResource("nc_weather/2012/weather-2012-01-01.csv");
        CSVRecord largest = MaxV2(fr.getCSVParser());
        System.out.println(largest.get("TemperatureF") + " " + largest.get("TimeEST"));
    
    }
    
    public void main() {
        
        // Exercise: Parsing Export
        //FileResource fr = new FileResource();
        //CSVParser parser = fr.getCSVParser();
        
        //System.out.println(max("TemperatureF"));
        testHottestInDay();
        

    }
      
}