

public class Part2 {

    public String findGeneSimple(String dna, int startCodon, int stopCodon) {

        dna = dna.toUpperCase();

        // Don't understand why to destroy the working identifier...
        // start = "ATG"
        int startIdx = startCodon;

        // end = "TAA"
        int endIdx = stopCodon;



        if ((startIdx == -1 || endIdx == -1) || (startIdx == -1 && endIdx == -1)) {
            return "";
        }
        // result = start + between + end
        else {
            // check if it is a valid Gene (ATG 3letters 3letters TAA)
            if ((endIdx - startIdx) % 3 == 0) {
                return dna.substring(startIdx,endIdx + 3);
            }
            else {
                return "";
            }

        }
    }

    public void testFindGeneSimple() {
        String dna = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("Checking "+dna);
        String gene = findGeneSimple(dna,1,1);
        System.out.println("Found "+gene);

        dna = "XXXATG0000TAA000";
        System.out.println("Checking "+dna);
        gene = findGeneSimple(dna,1,1);
        System.out.println("Found "+gene);

        dna = "XXXATGTAA000";
        System.out.println("Checking "+dna);
        gene = findGeneSimple(dna,1,1);
        System.out.println("Found "+gene);

        // some dirty dna
        dna = "XXXTAA000";
        System.out.println("Checking "+dna);
        gene = findGeneSimple(dna,1,1);
        System.out.println("Found "+gene);

        dna = "XXX000";
        System.out.println("Checking "+dna);
        gene = findGeneSimple(dna,1,1);
        System.out.println("Found "+gene);

        dna = "XXXATG000";
        System.out.println("Checking "+dna);
        gene = findGeneSimple(dna,1,1);
        System.out.println("Found "+gene);
    }
}
