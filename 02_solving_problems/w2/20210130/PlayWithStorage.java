
/**
 * Write a description of PlayWithStorage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class PlayWithStorage {
    public static String findGene(String dna) {

        int startIdx = dna.indexOf("ATG");
        int currentIdx = dna.indexOf("TAA", startIdx + 3);
        while (currentIdx != -1) {
            if ((currentIdx - startIdx) % 3 == 0) {
                return dna.substring(startIdx,currentIdx+3);
            }
            else {
                currentIdx = dna.indexOf("TAA", currentIdx + 1);
            }
        }
        return "";
    }
    public static int findStopCodonIDX(String dna,
                                       int startIdx,
                                       String stopCodon){
        int currentIdx = dna.indexOf(stopCodon, startIdx + 3);
        while (currentIdx != -1) {
            if ((currentIdx - startIdx) % 3 == 0) {
                return currentIdx;
            }
            else {
                // Ist das nicht optional?
                currentIdx = dna.indexOf(stopCodon, currentIdx + 1);
            }
        }
//        System.out.println("Didn't find a Stop Codon of " + stopCodon);
        return -1;//dna.length();
    }

    public static String findGeneNew(String dna) {
        //1. Beginnen wir mit ATG
        int startIdx = dna.indexOf("ATG");
        if (startIdx == -1) {
            return "";
        }
        int taAIdx = findStopCodonIDX(dna,startIdx,"TAA");
        int taGIdx = findStopCodonIDX(dna,startIdx,"TAG");
        int tGAIdx = findStopCodonIDX(dna,startIdx,"TGA");


        int minIdx = 0;
        // bool 1
        if (taAIdx == -1 || (tGAIdx != -1 && tGAIdx < taAIdx)) {
            minIdx = tGAIdx;
        }
        else {
            minIdx = taAIdx;
        }

        // bool 2
        if (minIdx == -1 || (taGIdx != -1 && taGIdx < minIdx)) {
            minIdx = taGIdx;
        }


        if (minIdx == -1) {return "";}


        return dna.substring(startIdx,minIdx+3);
    }
    public static String findGeneV3(String dna, int startfrom) {
        int startIdx = dna.indexOf("ATG", startfrom);
        if (startIdx == -1) {
            return "";
        }
        int taAIdx = findStopCodonIDX(dna,startIdx,"TAA");
        int taGIdx = findStopCodonIDX(dna,startIdx,"TAG");
        int tGAIdx = findStopCodonIDX(dna,startIdx,"TGA");

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

            String some_gene = findGeneV3(dna, startIdx);
            if (some_gene.isEmpty()) {break;}

            System.out.println(some_gene);
            startIdx = dna.indexOf(some_gene,startIdx) + some_gene.length();
        }

//        System.out.println("doing something");

    }
    
    public StorageResource getAllGenes(String dna) {
        StorageResource sr = new StorageResource();
        int startIdx = 0;

        while (true) {

            String some_gene = findGeneV3(dna, startIdx);
            if (some_gene.isEmpty()) {break;}

            //System.out.println(some_gene);
            sr.add(some_gene);
            startIdx = dna.indexOf(some_gene,startIdx) + some_gene.length();
        }
        
        return sr;
    }
    
    public void testOn(String dna){
        System.out.println("getAllGenes TEST "+dna);
        StorageResource genepool = getAllGenes(dna);
        for (String gene : genepool.data()) {
            System.out.println(gene);
        }
    }
    
    public void test() {
        String dna = "ATGATCGCTAATGCTTAAGCTATGATGATCGCTAATGCTTAAGCTATG";
        testOn(dna);
    
    }
}
