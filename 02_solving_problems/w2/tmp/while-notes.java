public class WhileNotes {
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

        // Umstaendlicher Weg, das Minimum zwischen 3 Zahlen zu finden. Lang lebe Python :)
//        int tmp = Math.min(taAIdx,taGIdx);
//        int minIdx = Math.min(tmp,tGAIdx);

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

    public static int howMany(String A, String B) {
        //howMany(“GAA”, “ATGAACGAATTGAATC”) ==3
        return 0;

    }
    public static void main(String[] args){
//        String dna = "ATGATCGCTAATGCTTAAGCTATG";
        String dna = "ATGATCGCTAATGCTTAAGCTATGATG............TAA";
//        dna = "XXXATG000000TAA000";
//        dna = "XXX000000TAA000";
//        dna = "XXX000000000";
//        dna = "XXXATG000000TAATAA000";
//        System.out.println(findGene(dna));
//        System.out.println(findStopCodonIDX(dna,0,"TAA"));
//        System.out.println(findGeneNew(dna));
//        if ("".isEmpty()) {System.out.println("This string is empty.");}
        print_all_genes(dna);
    }
}