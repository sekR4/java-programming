public class WhileNotes {
    public static String findGene(String dna) {

        int startIdx = dna.indexOf("ATG");
        if (startIdx == -1) {
            return "";
        }
        else {
            int currentIdx = dna.indexOf("TAA", startIdx + 3);
            if (currentIdx == -1) {
                return "";

                }
            else {
                while ((currentIdx - startIdx) % 3 != 0) {
                    currentIdx = dna.indexOf("TAA", currentIdx + 1);
                }
                System.out.println("Start at Index: " + startIdx);
                System.out.println("Current Index: " + currentIdx);
                System.out.println(dna.length());
                return dna.substring(startIdx,currentIdx+3);
            }
        }
//        System.out.println("Start at Index: " + startIdx);
//        System.out.println("Current Index: " + currentIdx);
//        return ""; //dna.substring(startIdx,currentIdx+3);
    }
    public static void main(String[] args){
        String dna = "ATGATCGCTAATGCTTAAGCTATG";
        dna = "XXXATG000000TAA000";
        System.out.println(findGene(dna));
    }
}