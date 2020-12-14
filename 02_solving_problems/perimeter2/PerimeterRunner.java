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
            double currDist = prevPt.distance(currPt);
            // 2. totalPerim += totalPerim + current distance
            totalPerim = totalPerim + currDist;
            // Set prevPt = current point
            prevPt = currPt;
        }
        // 4. Return totalPerim
        return totalPerim;
    }

    public int getNumPoints(Shape s) {
        int NumPoints = 0;
        for (Point currPt : s.getPoints()) {
            NumPoints = NumPoints + 1;
        }
        return NumPoints;
    }



    public double getAverageLength(Shape s) {
        double len = getPerimeter(s);
        int pts = getNumPoints(s);
        return len/pts;
    }

    public double getLongest(Shape s) {
        double lenmax = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if (currDist > lenmax) {
                lenmax = currDist;
            }
        return lenmax;
    }

    public void testPerimeter() {
        // HINT: Should I download some files?
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double len = getPerimeter(s);
        int pts = getNumPoints(s);
        double avglen = getAverageLength(s);
        double lenmax = getLongest(s);
        System.out.println("Umfang = " + len);
        System.out.println("NumPoints = " + pts);
        System.out.println("avg(len) = " + avglen);
        System.out.println("longest = " + lenmax);

    }

    public static void main(String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
