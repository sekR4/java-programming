
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
   public static int findStopCodon(String dna, int startIdx,String stopCodon){
        int currentIdx = dna.indexOf(stopCodon, startIdx + 3);
        while (currentIdx != -1) {
            if ((currentIdx - startIdx) % 3 == 0) { return currentIdx; }
            else { currentIdx = dna.indexOf(stopCodon, currentIdx + 1); }
        }
        return -1;
    }
    
   public static String findGene(String dna, int startfrom) {
       int startIdx = dna.indexOf("ATG", startfrom);
       if (startIdx == -1) {return "";}
       
       int taAIdx = findStopCodon(dna,startIdx,"TAA");
       int taGIdx = findStopCodon(dna,startIdx,"TAG");
       int tGAIdx = findStopCodon(dna,startIdx,"TGA");
       int minIdx = 0;

       if (taAIdx == -1 || (tGAIdx != -1 && tGAIdx < taAIdx)) { minIdx = tGAIdx; }
       else { minIdx = taAIdx;}
       if (minIdx == -1 || (taGIdx != -1 && taGIdx < minIdx)) { minIdx = taGIdx; }
       if (minIdx == -1) {return "";}

       return dna.substring(startIdx,minIdx+3);
    } 

    public static void print_all_genes(String dna) {
        int startIdx = 0;

        while (true) {

            String some_gene = findGene(dna, startIdx);
            if (some_gene.isEmpty()) {break;}

            System.out.println(some_gene);
            startIdx = dna.indexOf(some_gene,startIdx) + some_gene.length();
        }

//        System.out.println("doing something");

    }    
   
   public static void testFindStopCodon(){
       String dna1 = "ATGATCGCTAATGCTTAAGCTATG";
       String dna2 = "ATGATCGCTAATGCTTAAGCTATGATG............TAA";
       System.out.println(findStopCodon(dna1,0,"TAA"));
    }
    
   public static void testFindGene(){
       String dna1 = "ATGATCGCTAATGCTTAAGCTATG";
       String dna2 = "ATGATCGCTAATGCTTAAGCTATGATG............TAA";
       //System.out.println(findGene(dna1,0));
       print_all_genes(dna2);
    }
    
}
