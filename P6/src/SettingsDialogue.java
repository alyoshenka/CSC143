import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** setting dialogue */
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
    /** offset angle for recursion */
    private int angle;

    // data helpers
    /** main color button */
    private JButton mainButton;
    /** end color button */
    private JButton endButton;
    /** range for recursion depth */
    private JComboBox<Integer> recursionBox;
    /** range for radius ratio */
    private JComboBox<Integer> ratioBox;
    /** angle for recursion */
    private JComboBox<Integer> angleBox;
    /** recursion label */
    private JLabel recursionLabel;
    /** ratio label */
    private JLabel ratioLabel;
    /** angle label */
    private JLabel angleLabel;


    /** the button to draw the fractal */
    private JButton goButton;

    /**
     * default constructor
     *
     * @param sub the Subject
     */
    public SettingsDialogue(Subject sub){
        // defaults
        baseColor = Color.green;
        endColor = Color.pink;
        recursionDepth = 2;
        ratio = 40;
        recursionDepth = 2;
        angle = 30;

        // window
        frame = new JFrame("Fractals");
        frame.setSize(300, 300);
        frame.setResizable(false);
        frame.setVisible(true); // do i need?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // buttons
        mainButton = new JButton("Base Color");
        endButton = new JButton("End Color");
        goButton = new JButton("Draw Fractal");
        mainButton.setBackground(baseColor);
        endButton.setBackground(endColor);
        mainButton.setBounds(20, 20, 100, 30);
        endButton.setBounds(160, 20, 100, 30);
        goButton.setBounds(80, 200, 120, 40);
        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(null, "Choose a base color", Color.green);
                if(null != newColor){
                    baseColor = newColor;
                }
                mainButton.setBackground(baseColor);
                sub.setData(ratio, recursionDepth, baseColor, endColor, angle);
            }
        });
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(null, "Choose an end color", Color.pink);
                if(null != newColor) {
                    endColor = newColor;
                }
                endButton.setBackground(endColor);
                sub.setData(ratio, recursionDepth, baseColor, endColor, angle);
            }
        });
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sub.notifyObservers();
            }
        });

        // combo boxes
        recursionBox = new JComboBox<Integer>();
        ratioBox = new JComboBox<Integer>();
        angleBox = new JComboBox<Integer>();
        recursionLabel = new JLabel("Recursion");
        ratioLabel = new JLabel("Ratio");
        angleLabel = new JLabel("Angle");
        recursionBox.setBounds(20, 110, 70, 20);
        ratioBox.setBounds(110, 110, 70, 20);
        angleBox.setBounds(200, 110, 70, 20);
        recursionLabel.setBounds(20, 90, 70, 20);
        ratioLabel.setBounds(110, 90, 70, 20);
        angleLabel.setBounds(200, 90, 70, 20);
        for(int i = 2; i <= 10; i++){
            recursionBox.addItem(i);
        }
        for(int i = 40; i <= 70; i += 5){
            ratioBox.addItem(i);
        }
        for(int i = 30; i <= 60; i += 5){
            angleBox.addItem(i);
        }
        recursionBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recursionDepth = (int)recursionBox.getItemAt(recursionBox.getSelectedIndex());
                sub.setData(ratio, recursionDepth, baseColor, endColor, angle);
            }
        });
        ratioBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ratio = (int)ratioBox.getItemAt(ratioBox.getSelectedIndex());
                sub.setData(ratio, recursionDepth, baseColor, endColor, angle);
            }
        });
        angleBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle = (int)angleBox.getItemAt(angleBox.getSelectedIndex());
                sub.setData(ratio, recursionDepth, baseColor, endColor, angle);
            }
        });

        // panel
        panel = new JPanel();
        panel.setLayout(null);
        panel.add(mainButton);
        panel.add(endButton);
        panel.add(goButton);
        panel.add(recursionBox);
        panel.add(ratioBox);
        panel.add(angleBox);
        panel.add(recursionLabel);
        panel.add(ratioLabel);
        panel.add(angleLabel);

        frame.add(panel);
        frame.setVisible(true);
    }

}
