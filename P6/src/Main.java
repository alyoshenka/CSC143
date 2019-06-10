/** main application class */
public class Main {

    /** the settings dialogue */
    private SettingsDialogue gui;
    /** the fractal generator */
    private FractalDataGenerator dataGen;
    /** the display */
    private DrawFractal display;

    /**
     * main application method
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        FractalDataGenerator dat = new FractalDataGenerator();
        DrawFractal display = new DrawFractal(dat);
        SettingsDialogue s = new SettingsDialogue(dat);
    }
}
