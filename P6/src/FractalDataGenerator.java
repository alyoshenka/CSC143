import java.util.ArrayList;
import java.awt.Color;

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

    /**
     * default constructor
     */
    public FractalDataGenerator(){
        listeners = new ArrayList<>();
        ratio = recDepth = 0;
        baseColor = Color.green; // default
        endColor = Color.pink; // default
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
    public void setData(double childRatio, int recDepth, Color baseColor, Color endColor){
        // not sure
    }

    /**
     * {@inheritDoc}
     */
    public ArrayList<FractalObject> getData(){
        // not sure
        return null;
    }
}
