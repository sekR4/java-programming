// BUG: 21.02.21 CSVRead.java:1: error: package org.apache.commons.csv does not exist
import org.apache.commons.csv.*;


public class CSVRead {

    public static void read_csv(String filepath){
        File csvData = new File(filepath);
        CSVParser parser = CSVParser.parse(csvData);
        for (CSVRecord csvRecord : parser) {
            system.out.print(csvRecord.get("x1"));
            system.out.println(csvRecord.get("x2"));
        }

    }

    public static void main() {
        read_csv("demo.csv");

    }
}
