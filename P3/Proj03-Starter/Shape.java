// A shape consists of a shape name and a collection of points

// You'll need to write unit tests for this class

import java.io.Serializable;
import java.lang.IllegalArgumentException;

/**
 * a series of points associated with a name
 */
public class Shape implements Serializable {

    /** the name of this shape */
    private String name;
    /** the points for this shape */
    private ArrayList<Point> points;
    /** the class version */
    public static final long serialVersionUID = 1;

    /**
     * shape constructor
     *
     * @param name this shape's name, must not be null
     */
    public Shape(String name) {
        if(name == null){
            throw new IllegalArgumentException("shape name cannot be null");
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

    /**
     * gets the name of the shape
     *
     * @return this shape's name
     */
    public String getName(){
        return name;
    }

    /**
     * gets the points in this shape
     *
     * @return the points for this shape
     */
    public ArrayList<Point> getPoints(){
        return points;
    }
}
