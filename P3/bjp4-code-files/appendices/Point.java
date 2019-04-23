/**
 *  A Point object represents an ordered pair of
 *  (x, y) coordinates in the 2D Cartesian plane.
 *
 *  @author Marty Stepp (stepp@example.com)
 *  @version 1.2 (January 12, 2007)
 */
public class Point {
    private int x, y;
    
    /**
     *  Computes and returns the distance between this point
     *  and the given other point.
     *
     *  @param p The point to which the distance is computed.
     *  @return The distance, computed as the square root of
     *          the sums of the squares of the differences
     *          between the two points' x-coordinates (dx)
     *          and between their y-coordinates (dy).
     *  @throws NullPointerException if p is null.
     */
    public double distance(Point p) {
        int dx = x - p.x;
        int dy = y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
