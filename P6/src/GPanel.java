import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/** graphics drawing panel */
public class GPanel extends JPanel {

    /** the frame to draw on */
    private JFrame frame;
    /** the list of shapes to be drawn */
    private ArrayList<FractalObject> objects;

    /**
     * default constructor
     */
    public GPanel(){
        frame = new JFrame("Drawing");
        frame.setSize(600, 500);
        frame.setResizable(false);
        frame.setVisible(true); // do i need?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);

        frame.getGraphics().setColor(Color.blue);
        frame.getGraphics().drawOval(10, 10, 10, 10);
        objects = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for(FractalObject shape : objects){
            shape.draw(g);
        }
    }

    /**
     * draw the shapes
     *
     * @param objects the shapes to draw
     */
    public void draw(ArrayList<FractalObject> objects){
        this.objects = objects;
        repaint();
    }
}
