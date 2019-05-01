import java.io.File;
import java.io.IOException;

//todo
// close files
// test arraylist etc

/**
 * Main application class
 */
public class Main {

    /**
     * main application method
     * @param args command line arguments
     */
    public static void main(String[] args)  {
        try {
            Utility.createShapeLib();
            createShapes();
        }
        catch(Exception e){}
        ShapeLibrary shapeLib = new ShapeLibrary();

        Drawing drawing1 = new Drawing(shapeLib, new File("Instruct-Simple.txt"));
        Drawing drawing2 = new Drawing(shapeLib, new File("Instruct-Rand.txt"));
        Drawing drawing3 = new Drawing(shapeLib, new File("Instruct-RepeatOffset.txt"));
        Drawing drawing4 = new Drawing(shapeLib, new File("Instruct-Gradient.txt"));
        Drawing drawing5 = new Drawing(shapeLib, new File("Instruct-Rotate.txt"));
        Drawing drawing6 = new Drawing(shapeLib, new File("Instruct-Gradient-Horiz.txt"));
        Drawing drawing7 = new Drawing(shapeLib, new File("Instruct-Gradient-Vert.txt"));
        Drawing drawing8 = new Drawing(shapeLib, new File("Instruct-Gradient-DiagTL.txt"));
        Drawing drawing9 = new Drawing(shapeLib, new File("Instruct-Gradient-DiagTR.txt"));
        Drawing drawing10 = new Drawing(shapeLib, new File("instr1.txt"));

        drawing10.draw();
        drawing9.draw();
        drawing8.draw();
        drawing7.draw();
        drawing6.draw();
        drawing5.draw();
        drawing4.draw();
        drawing3.draw();
        drawing2.draw();
        drawing1.draw();
    }

    // DELETE
    /**
     * creates some shapes
     */
    private static void createShapes(){
        Shape shp1 = new Shape("arrowhead");
        shp1.addPoint(new Point(50, 0));
        shp1.addPoint(new Point(100, 100));
        shp1.addPoint(new Point(50, 70));
        shp1.addPoint(new Point(0, 100));

        Shape shp2 = new Shape("octagon");
        shp2.addPoint(new Point(25, 0));
        shp2.addPoint(new Point(75, 0));
        shp2.addPoint(new Point(100, 25));
        shp2.addPoint(new Point(100, 75));
        shp2.addPoint(new Point(75, 100));
        shp2.addPoint(new Point(25, 100));
        shp2.addPoint(new Point(0, 75));
        shp2.addPoint(new Point(0, 25));

        ArrayList<Shape> shapesToAdd = new ArrayList<Shape>();
        shapesToAdd.add(shp1);
        shapesToAdd.add(shp2);

        try{
        Utility.writeShapes(shapesToAdd);}
        catch(Exception e){}
    }

}
