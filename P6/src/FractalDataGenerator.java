import java.util.ArrayList;
import java.awt.Color;

/** settings gui */
public class FractalDataGenerator implements Subject {

    /** the objects subscribed to this */
    private ArrayList<Observer> listeners;
    /** the ratio of child to parent objects (*100) */
    private double ratio;
    /** the number of times to recurse*/
    private int recDepth;
    /** the color of the body */
    private Color baseColor;
    /** the color of the ends */
    private Color endColor;
    /** the angle in radians*/
    private double angle;
    /** the current list of FractalObjects */
    private ArrayList<FractalObject> objects;

    /** the starting X coordinate */
    private int startX;
    /** the starting y coordinate */
    private int startY;
    /** the starting radius */
    private int startRad;

    /**
     * default constructor
     */
    public FractalDataGenerator(){
        listeners = new ArrayList<>();
        objects = new ArrayList<>();
        ratio = 40;
        recDepth = 2;
        angle = 0;
        baseColor = Color.green; // default
        endColor = Color.pink; // default
        startX = 250;
        startY = 300;
        startRad = 100;
    }

    /**
     * {@inheritDoc}
     */
    public void addListener(Observer listener){
        listeners.add(listener);
    }

    /**
     * {@inheritDoc}
     */
    public void removeListener(Observer listener){
        listeners.remove(listener);
    }

    /**
     * {@inheritDoc}
     */
    public void notifyObservers(){
        for(Observer listener : listeners){
            listener.update();
        }
    }

    /**
     * {@inheritDoc}
     */
    public void setData(double childRatio, int recDepth, Color baseColor, Color endColor, int angle){
        ratio = childRatio;
        this.recDepth = recDepth;
        this.baseColor = baseColor;
        this.endColor = endColor;
        this.angle = Math.toRadians(angle);
    }

    /**
     * {@inheritDoc}
     */
    public ArrayList<FractalObject> getData(){
        return generateObjects();
    }

    /**
     * makes the list of objects
     *
     * @return the list of objects
     */
    private ArrayList<FractalObject> generateObjects(){
        objects.clear();
        getNext(startX, startY, startRad, recDepth, angle);
        return objects;
    }

    /**
     * continues the recursion
     *
     * @param startX the x coordinate of the shape
     * @param startY the y coordinate of the shape
     * @param startRad the radius of the shape
     * @param recDepth the number of recursions left
     * @param startAngle the angle to draw at
     * @return if there will be another recursion
     */
    private boolean getNext(double startX, double startY, int startRad, int recDepth, double startAngle) {
        System.out.println(Math.toDegrees(startAngle));
        if (recDepth <= 0 || startRad < 1) {
            return false;
        } else if (1 == recDepth) {
            objects.add(new Circle((int) (startX - 0.5 * startRad), (int) (startY - 0.5 * startRad), startRad, endColor));
            return false;
        } else {
            objects.add(new Circle((int) (startX - 0.5 * startRad), (int) (startY - 0.5 * startRad), startRad, baseColor));
            double deltaX = startRad * Math.cos(startAngle);
            double deltaY = startRad * Math.sin(startAngle);
            startRad *= (ratio / 100.0);
            deltaX += startRad * Math.cos(startAngle);
            deltaY += startRad * Math.sin(startAngle);
            startAngle += Math.toRadians(45);
            getNext(startX + deltaX, startY - deltaY, startRad, recDepth - 1, startAngle); // right
            getNext(startX - deltaX, startY - deltaY, startRad, recDepth - 1, startAngle); // left
            return true;
        }
    }

}
