// A ShapeLibrary consists of a collection of Shape objects

// You'll need to write unit tests for this class 

public class ShapeLibrary {

    /** the shapes in this library */
    private ArrayList<Shape> shapes;

    public ShapeLibrary() {

    }

    /**
     * gets a shape by its name
     *
     * @param name the desired shape's name
     * @return the named shape
     */
    public Shape getShape(String name){
        return new Shape("notAShape");
    }



}
