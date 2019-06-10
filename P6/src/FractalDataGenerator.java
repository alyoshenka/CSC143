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
        /** initialize to defaults */
        ratio = 40;
        recDepth = 2;
        angle = Math.toRadians(30);
        baseColor = Color.green;
        endColor = Color.pink;
        startX = 250;
        startY = 260;
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
        double offset = Math.toRadians(90);
        getNext(startX, startY, startRad, recDepth, angle + offset); // right
        getNext(startX, startY, startRad, recDepth, offset - angle); // left
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
    private boolean getNext(double startX, double startY, double startRad, int recDepth, double startAngle) {
        if (recDepth <= 0 || startRad < 1) {
            return false;
        } else if (1 == recDepth) {
            objects.add(new Circle((int) (startX - 0.5 * startRad), (int) (startY - 0.5 * startRad), (int)startRad, endColor));
            return false;
        } else {
            objects.add(new Circle((int) (startX - 0.5 * startRad), (int) (startY - 0.5 * startRad), (int)startRad, baseColor));
            double deltaX = startRad / 2 * Math.cos(startAngle);
            double deltaY = startRad / 2 * Math.sin(startAngle);
            startRad *= (ratio / 100.0);
            deltaX += startRad / 2 * Math.cos(startAngle);
            deltaY += startRad / 2 * Math.sin(startAngle);
            getNext(startX + deltaX, startY - deltaY, startRad, recDepth - 1, startAngle + angle); // right
            getNext(startX + deltaX, startY - deltaY, startRad, recDepth - 1, startAngle - angle); // left
            return true;
        }
    }

}
