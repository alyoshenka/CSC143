import java.awt.Graphics;
import java.util.ArrayList;

/** drawing display */
public class DrawFractal implements Observer {

    /** the object to listen to */
    private Subject subject;
    /** the panel */
    private GPanel panel;
    /** the current list of objects to draw */
    private ArrayList<FractalObject> shapes;
    /** the current Graphics object */
    private Graphics g;

    /**
     * default constructor
     *
     * @param sub the object to listen to
     */
    public DrawFractal(Subject sub){
        subject = sub;
        panel = new GPanel();
        g = panel.getGraphics();

        sub.addListener(this);
    }

    /**
     * {@inheritDoc}
     */
    public void update(){
        panel.draw(subject.getData());
    }
}
