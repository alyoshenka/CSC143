import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsDialogue extends JFrame{
    // window
    /** the main drawing frame */
    private JFrame frame;
    /** the drawing panel */
    private JPanel panel;

    // data to pass on
    /** main fractal color */
    private Color baseColor;
    /** end of fractal color*/
    private Color endColor;
    /** the number of time the fractal repeats */
    private int recursionDepth;
    /** ratio of child to parent radius */
    private int ratio;

    // data helpers
    /** main color button */
    private JButton mainButton;
    /** end color button */
    private JButton endButton;
    /** range for recursion depth */
    private JComboBox recursionBox;
    /** range for radius ratio */
    private JComboBox ratioBox;

    /** the button to draw the fractal */
    private JButton goButton;

    /**
     * default constructor
     */
    public SettingsDialogue(Subject sub){
        // defaults
        baseColor = Color.green;
        endColor = Color.pink;
        recursionDepth = 2;
        ratio = 40;

        // window
        frame = new JFrame("Fractals");
        frame.setSize(400, 300);
        frame.setResizable(false);
        frame.setVisible(true); // do i need?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // buttons
        mainButton = new JButton("Base Color");
        endButton = new JButton("End Color");
        goButton = new JButton("Draw Fractal");
        mainButton.setBackground(baseColor);
        endButton.setBackground(endColor);
        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baseColor = JColorChooser.showDialog(null, "Choose a base color", Color.green);
                mainButton.setBackground(baseColor);
            }
        });
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endColor = JColorChooser.showDialog(null, "Choose an end color", Color.pink);
                endButton.setBackground(endColor);
            }
        });
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.printf("%s, %s, %s, %s", baseColor, endColor, recursionDepth, ratio);
            }
        });

        // combo boxes
        recursionBox = new JComboBox();
        ratioBox = new JComboBox();
        for(int i = 2; i <= 10; i++){
            recursionBox.addItem(i);
        }
        for(int i = 40; i <= 70; i += 5){
            ratioBox.addItem(i);
        }
        recursionBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recursionDepth = (int)recursionBox.getItemAt(recursionBox.getSelectedIndex());
            }
        });
        ratioBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ratio = (int)ratioBox.getItemAt(ratioBox.getSelectedIndex());
            }
        });

        // panel
        panel = new JPanel();
        // panel.setLayout(new LayoutManager());
        panel.add(mainButton);
        panel.add(endButton);
        panel.add(goButton);
        panel.add(recursionBox);
        panel.add(ratioBox);

        frame.add(panel);
        frame.setVisible(true);
    }

}
