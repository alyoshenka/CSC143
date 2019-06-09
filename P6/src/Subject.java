import java.util.ArrayList;
import java.awt.Color;

/** event object */
public interface Subject {

    /**
     * add an observer to the observing objects
     *
     * @param o the observer to add
     */
    void addListener(Observer o);

    /**
     * remove an observer from the observing objects
     *
     * @param o the observer to remove
     */
    void removeListener(Observer o);

    /**
     * notify all observers of changes
     */
    void notifyObservers();

    /**
     * set the data
     *
     * @param childRatio parent to child ratio (*100)
     * @param recDepth number of recursions
     * @param baseColor base fractal color
     * @param endColor end fractal color
     */
    void setData(double childRatio, int recDepth, Color baseColor, Color endColor);

    /**
     * gets a list of generated FractalObjects
     *
     * @return the list of generated FractalObjects
     */
    ArrayList<FractalObject> getData();

}
