// Trying hard to read Class names... -_-
public class FindGeneSimpleAndTest {

    public String findGeneSimple(String dna) {
        // start = "ATG"
        int startIdx = dna.indexOf("ATG");
        // end = "TAA"
        int endIdx = dna.indexOf("TAA", startIdx)+2;

        // result = start + between + end
        String result = dna.substring(startIdx,endIdx+1);
        return result;
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
    }

}
