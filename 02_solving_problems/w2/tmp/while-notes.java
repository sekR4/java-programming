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
        return dna.length();
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
        int tmp = Math.min(taAIdx,taGIdx);
        int minIdx = Math.min(tmp,tGAIdx);

        if (minIdx == dna.length()) {return "";}


        return dna.substring(startIdx,minIdx+3);
    }


    public static void main(String[] args){
        String dna = "ATGATCGCTAATGCTTAAGCTATG";
//        dna = "XXXATG000000TAA000";
//        dna = "XXX000000TAA000";
//        dna = "XXX000000000";
//        dna = "XXXATG000000TAATAA000";
//        System.out.println(findGene(dna));
        System.out.println(findStopCodonIDX(dna,0,"TAA"));
        System.out.println(findGeneNew(dna));
    }
}