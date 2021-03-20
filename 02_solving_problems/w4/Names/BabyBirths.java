import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

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
        
        int n_boys_names = 0;
        int n_girls_names = 0;
        
        for (CSVRecord row : fr.getCSVParser(false)) {     
            if (row.get(1).equals("M")) {
                n_boys += Integer.parseInt(row.get(2));
                n_boys_names += 1;
            }
            else {
                n_girls += Integer.parseInt(row.get(2));
                n_girls_names += 1;
            }
        }
        
        System.out.println("Total Births: " + (n_boys+n_girls) 
                         +"\nBoys Births: " + n_boys
                         +"\nGirls Births: " + n_girls
                         +"\n Names Total: " + (n_boys_names + n_girls_names)
                         +"\n Boys Names: " + n_boys_names
                         +"\n Girls Names: " + n_girls_names
        );
    }
    
    public FileResource get_file_by_year(int year){
        String path = "../us_babynames/us_babynames_by_year/yob" + year + ".csv";
        return new FileResource(path);
    }
    
    
    public int getRank(int year, String name, String gender){
        // NOTE: We're assuming there are no duplications and the file is not messy
        int n_row = 0;
        int rank = 0;        
        FileResource fr = get_file_by_year(year); 
        
        // Loop over CSV:
        for (CSVRecord row : fr.getCSVParser(false)) {
            
            // if current gender == gender: n_row +=1
            if (row.get(1).equals(gender)){
                n_row +=1;
                
                // if current name == name: rank = n_row
                if (row.get(0).equals(name)){
                    rank = n_row;
                }
            }    
        }
        // if rank > 0: return rank
        if (rank > 0){return rank;}
        else {return -1;}
    }
    
    public String getName(int year, int rank, String gender){
        FileResource fr = get_file_by_year(year);    
        int n_row = 0;
        String name = "";
        
        // Loop over CSV:
        for (CSVRecord row : fr.getCSVParser(false)) {
            
            // if current gender == gender: n_row +=1
            if (row.get(1).equals(gender)){
                n_row +=1;
                
                // if n_row == rank: name = row.get(0)
                if (n_row == rank){
                    name = row.get(0);
                }
            }    
        }
        
        // if len(name)>0: return name
        if (name.length() > 0) {return name;}
        else {return "NO NAME";}
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender){

        String he_or_she = "she";
        if (gender.equals("M")){he_or_she="he";}
        int rank = getRank(year,name,gender);
        String new_name = getName(newYear,rank, gender);
        
        System.out.println(name + " born in " 
                           + year + " would be " 
                           + new_name + " if " 
                           + he_or_she + " was born in " 
                           + newYear + ".");
    }
    
    public int year_from_file(File f){
        String abs_path = f.getAbsolutePath();
        return Integer.parseInt(
                        abs_path.substring(
                            abs_path.length()-8,
                            abs_path.length()-4
                            )
                        );
    }
    
    public int yearOfHighestRank(String name, String gender){
        int best_year = -1;
        int best_rank = 999999999; // maybe not best practice, but it works
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            int year = year_from_file(f);
            int curr_rank = getRank(year,name,gender);
            if (curr_rank != -1){
                if (curr_rank < best_rank){
                    best_rank = curr_rank;
                    best_year = year;
                }
            }   
        }
        return best_year;
    }
    
    public double getAverageRank(String name, String gender){
        
        int sum_rank = 0;        
        int n_years = 0;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            int year = year_from_file(f);
            int curr_rank = getRank(year,name,gender);
            if (curr_rank > -1){
                sum_rank += curr_rank;
                n_years += 1;
            }
        }
        
        if (n_years > 0){return sum_rank/n_years;}
        else {return -1.0;}
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        
        int n_row = 0;
        int sum_births = 0;
        int exclude_rank = getRank(year, name, gender);
        
        FileResource fr = get_file_by_year(year);
        for (CSVRecord row : fr.getCSVParser(false)) {
            if (row.get(1).equals(gender)){
                n_row += 1;
                if (n_row < exclude_rank){
                    sum_births += Integer.parseInt(row.get(2));
                }
            }
        }
       
        if (sum_births > 0){return sum_births;}
        else {return -1;}
    }
    
    public void test_TotalBirths(){totalBirths(get_file_by_year(1905));}
    public void test_getRank(){System.out.println(getRank(1971,"Frank","M"));}
    public void test_getName(){System.out.println(getName(1982,450,"M"));}
    public void test_whatIsNameInYear(){whatIsNameInYear("Owen", 1974, 2014, "M");}
    public void test_yearOfHighestRank(){System.out.println(
                                            yearOfHighestRank("Mich", "M"));}
    public void test_getAverageRank(){System.out.println(
                                            getAverageRank("Robert","M"));}
    public void test_getTotalBirthsRankedHigher(){
        System.out.println(getTotalBirthsRankedHigher(1990, "Drew", "M"));
    }
}
