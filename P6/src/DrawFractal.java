import javax.swing.JFrame;

public class DrawFractal implements Observer {

    /** the object to listen to */
    private Subject subject;
    /** the drawing frame */
    private JFrame frame;
    /** the panel */
    private GPanel panel;


    /**
     * default constructor
     *
     * @param sub the object to listen to
     */
    public DrawFractal(Subject sub){

    }

    /**
     * {@inheritDoc}
     */
    public void update(){

    }
}
