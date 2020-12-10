import edu.duke.*;

// Doku Shape etc.: https://www.dukelearntoprogram.com/course2/doc/javadoc/index.html?course=2
public class PerimeterRunner {
    public double getPerimeter(Shape s) {
        // 1. Set totalPerim = 0
        double totalPerim = 0;
        // 2. Set prevPt = last Point
        Point prevPt = s.getLastPoint();
        // 3. for each current Point in Shape s:
        for (Point currPt : s.getPoints()) {
            // 1. Get distance between prev and current Point
            double currDist = prevPt.distance(currPt)
            // 2. totalPerim += totalPerim + current distance
            totalPerim = totalPerim + currDist
            // Set prevPt = current point
            prevPt = currPt
        }

        // 4. Return totalPerim
        return totalPerim
    }

    public void testPerimeter() {
        // HINT: Should I download some files?
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double len = getPerimeter(s);
        System.out.println("Umfang = " + len)
    }

    public static void main(String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
