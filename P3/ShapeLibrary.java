// A ShapeLibrary consists of a collection of Shape objects

// You'll need to write unit tests for this class
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * stores the available shapes
 */
public class ShapeLibrary {

    /** the shapes in this library */
    private ArrayList<Shape> shapes;

    /**
     * constructs a ShapeLibrary from a File
     */
    public ShapeLibrary() {
        shapes = new ArrayList<Shape>();
        for(File file : (new File("shapes")).listFiles()){
            if (file.isFile() && file.getName().endsWith(".shp")) {
                try{
                    FileInputStream fileIn = new FileInputStream(file);
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Shape newShape = (Shape)in.readObject();
                    shapes.add(newShape);
                }
                catch(IOException e){
                    System.out.println("IO Exception");
                }
                catch(ClassNotFoundException e){
                    System.out.println("Class Not Found Exception");
                }
            }
        }
    }

    /**
     * adds a shape to the library
     *
     * @param shape the shape to add
     */
    public void addShape(Shape shape){ // input validation
        shapes.add(shape);
    }

    /**
     * gets a shape by its name
     *
     * @param name the desired shape's name
     * @return the named shape
     */
    public Shape getShape(String name){
        for(Shape shape : shapes){
            if(shape.getName().equals(name)){
                return shape;
            }
        }
        return new Shape("notAShape");
    }
}
