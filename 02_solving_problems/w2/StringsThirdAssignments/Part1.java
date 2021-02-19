
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part1 {
    public static int findStopCodonIDX(String dna,
                                       int startIdx,
                                       String stopCodon){
        int currentIdx = dna.indexOf(stopCodon, startIdx + 3);
        while (currentIdx != -1) {
            if ((currentIdx - startIdx) % 3 == 0) {
                return currentIdx;
            }
            else {
                currentIdx = dna.indexOf(stopCodon, currentIdx + 1);
            }
        }
        return -1;
    }
    
    public static String findGene(String dna, int startfrom) {
        int startIdx = dna.indexOf("ATG", startfrom);
        if (startIdx == -1) { return ""; }
        int taAIdx = findStopCodonIDX(dna,startIdx,"TAA");
        int taGIdx = findStopCodonIDX(dna,startIdx,"TAG");
        int tGAIdx = findStopCodonIDX(dna,startIdx,"TGA");
        int minIdx = 0;
        if (taAIdx == -1 || (tGAIdx != -1 && tGAIdx < taAIdx)) { minIdx = tGAIdx; }
        else { minIdx = taAIdx; }
        if (minIdx == -1 || (taGIdx != -1 && taGIdx < minIdx)) { minIdx = taGIdx; }
        if (minIdx == -1) { return ""; }
        return dna.substring(startIdx,minIdx+3);
    }
    
    public StorageResource getAllGenes(String dna) {
        StorageResource sr = new StorageResource();
        int startIdx = 0;
        int cntGenes = 0; 
        while (true) {
            String some_gene = findGene(dna, startIdx);
            if (some_gene.isEmpty()) {break;}
            sr.add(some_gene);
            cntGenes += 1;
            startIdx = dna.indexOf(some_gene,startIdx) + some_gene.length();
        }
        System.out.println("#Genes: "+cntGenes);
        return sr;
    }
    
    public static int howMany(String A, String B) {
        int curridx = 0;
        int cnt = 0;
        while (curridx != -1) {
            if (curridx == 0) {
                curridx = B.indexOf(A, curridx);
                if (curridx != -1) {cnt +=1;}
            }
            else {
                curridx = B.indexOf(A, curridx + A.length());
                if (curridx != -1) {cnt +=1;}
            }
        }
        return cnt;
    }
    
    public double cgRatio(String dna) {
        /*Returns the ratio of C’s and G’s in dna*/
        int c = howMany("C", dna);
        int g = howMany("G", dna);
        
        if (g > 0 & c > 0) {return (float) c/g;}
        else {return -1;}
    }
    
    public int countCTG(String dna) {
        /*Returns the number of times the codon CTG appears in dna*/
        return howMany("CTG", dna);
    }
    
    public void processGenes(StorageResource sr) {
        int cnt9 = 0;
        int cntCGR = 0;
        int cntMaxLen = 0;
        
        for (String gene : sr.data()){
            if (gene.length() > 60) {
                System.out.println("len(gene) > 60: " + gene); 
                cnt9 += 1;
            }
            if (cgRatio(gene) > 0.35) {
                System.out.println("C/G > 0.35: " + gene);
                cntCGR += 1;
            }
            if (gene.length() > cntMaxLen){cntMaxLen = gene.length();}
        }
        
        System.out.println("#genes with len(gene) > 60: " + cnt9);
        System.out.println("#genes with C/G > 0.35: " + cntCGR);
        System.out.println("#characters longest Gene: " + cntMaxLen);
    
    }
    
   public void testProcessGenes(){
    //String dna = "ATGATCGCTAATGCTTAAGCTATGATGATGAAGCTAATGCFFTTAAGCTATGATG";
    FileResource fr = new FileResource("GRch38dnapart.fa");
    String dna = fr.asString();
    System.out.println(dna.length());
    StorageResource tmp = getAllGenes(dna.toUpperCase());
    processGenes(tmp);
    System.out.println("#CTGs: "+countCTG(dna));
//    processGenes(getAllGenes(dna));
    }
}
