// Trying hard to read Class names... -_-
public class FindGeneSimpleAndTest {

    public String findGeneSimple(String dna) {
        // start = "ATG"
        int startIdx = dna.indexOf("ATG");

        // end = "TAA"
        int endIdx = dna.indexOf("TAA", startIdx);

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
        String dna = "ATGCGGTTTGACCTAA";
        System.out.println("Checking "+dna);
        String gene = findGeneSimple(dna);
        System.out.println("Found "+gene);

        dna = "XXXATG0000TAA000";
        System.out.println("Checking "+dna);
        gene = findGeneSimple(dna);
        System.out.println("Found "+gene);

        dna = "XXXATGTAA000";
        System.out.println("Checking "+dna);
        gene = findGeneSimple(dna);
        System.out.println("Found "+gene);

        // some dirty dna
        dna = "XXXTAA000";
        System.out.println("Checking "+dna);
        gene = findGeneSimple(dna);
        System.out.println("Found "+gene);

        dna = "XXX000";
        System.out.println("Checking "+dna);
        gene = findGeneSimple(dna);
        System.out.println("Found "+gene);

        dna = "XXXATG000";
        System.out.println("Checking "+dna);
        gene = findGeneSimple(dna);
        System.out.println("Found "+gene);
    }

}
