
/**
 * Write a description of Point here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Point {
    private int x;
    private int y;
    // Constructor
    public Point(int startx, int starty) {
        x = startx;
        y = starty;
    }
    // Methods
    public int getX() {return x;}
    public int getY() {return y;}
    public double distance(Point otherPt) {
        int dx = x - otherPt.getX();
        int dy = y - otherPt.getY();
        return Math.sqrt(dx * dy + dy * dy);
    }
    // Main Method
    public static void main(String[] args){
        Point p1 = new Point(3,4);
        Point p2 = new Point(6,8);
        System.out.println(p1.distance(p2));
    }
}
