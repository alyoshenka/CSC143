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

    /**
     * default constructor
     */
    public FractalDataGenerator(){
        listeners = new ArrayList<>();
        ratio = 40; // ?
        recDepth = 2; // ?
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
        ratio = childRatio;
        this.recDepth = recDepth;
        this.baseColor = baseColor;
        this.endColor = endColor;
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
        ArrayList<FractalObject> objects = new ArrayList<>();

        objects.add(new Circle(150, 200, 50, Color.red));

        // base
        for(int i = 0; i < recDepth; i++){

        }


        return objects;
    }


}
