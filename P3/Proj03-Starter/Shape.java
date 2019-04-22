// A shape consists of a shape name and a collection of points

// You'll need to write unit tests for this class

import java.io.Serializable;
import java.lang.IllegalArgumentException;

public class Shape implements Serializable {

    /** the name of this shape */
    private String name;
    /** the points for this shape */
    private ArrayList<Point> points;

    /** shape constructor
     *
     * @param name this shape's name, must not be null
     */
    public Shape(String name) {
        if(name == null){
            throw new IllegalArumentException("shape name cannot be null");
        }
        this.name = name;
        points = new ArrayList<Point>();
    }

    /**
     * adds a point to the vertices of this shape
     *
     * @param point the point to add
     */
    public void addPoint(Point point){
        points.add(point);
    }

}
