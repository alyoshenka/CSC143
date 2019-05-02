/*
 * Drawing is where the action happens.
 * 
 * The Drawing constructor should accept a File parameter indicating 
 * what instruction file to utilize.  It will need to create a 
 * Scanner pointing to the file.
 * 
 * It should also accept a ShapeLibrary parameter, which refers
 * to a fully filled-in library of shapes to utilize for drawing.
 * 
 * It should then use the appropriate Utility static methods
 * to ask for the retrieval of one CanvasInstruction, and create
 * a loop to ask for the retrieval of as many DrawInstruction 
 * objects as there are drawing instruction lines in the file.
 * You may decide to do the latter by saving all the drawing
 * instructions into an ArrayList, for later processing, or by
 * reading each drawing instruction and processing it immediately.
 * 
 * You must then do the work of drawing.  In some cases that will 
 * involved some transforms on the data, e.g., if the instruction
 * file says to draw the shape at (250, 100), then you must make
 * that happen.  Size is another transform that you'll need to 
 * handle.  Make sure to handle transforms in the proper order,
 * e.g., do you size first, then shift later, or the reverse?
 * 
 * When it comes to drawing the shape, you only need a couple of
 * basic Graphics methods.  You'll need .setColor() to change 
 * to the color you're about to draw with.  You'll also need
 * .drawPolygon() and .fillPolygon().  For extra credit a few
 * other methods will be necessary.
 * 
 * Do not use Graphics2D to do any of this work, regular or 
 * extra credit.  Use simple graphics commands and math to
 * accomplish these tasks.
 */

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

// todo
// weird random placing

/**
 * represents a full drawing with canvas and shapes
 */
public class Drawing {

    /** the canvas instructions for this drawing */
    private CanvasInstruction canvasInstruction;
    /** the drawing instructions for this drawing */
    private ArrayList<DrawInstruction> drawInstructions;
    /** the drawingpanel */
    private DrawingPanel drawingPanel;
    /** the drawingpanel's graphics */
    private Graphics graphics;
    /** the shape library to get shapes from */
    private ShapeLibrary shapeLibrary;

    /**
     * Drawing constructor
     * @param shapeLib the ShapeLibrary this Drawing uses
     * @param instructionFile the InstructionFile to read from
     */
    public Drawing(ShapeLibrary shapeLib, File instructionFile) {
        shapeLibrary = shapeLib;
        try {
            Scanner sc = new Scanner(instructionFile);
            drawInstructions = new ArrayList<DrawInstruction>(10);
            canvasInstruction = CanvasInstruction.readFromFile(sc);
            
            while(sc.hasNext()){
                drawInstructions.add(DrawInstruction.readFromFile(sc));
            }
            sc.close();
        }
        catch(IOException e){
            System.out.println("File IO Exception");
        }
    }

    /**
     * draws the canvas
     */
    private void drawCanvas(){
        drawingPanel = new DrawingPanel(canvasInstruction.getWidth(), canvasInstruction.getHeight());
        graphics = drawingPanel.getGraphics();
        if(canvasInstruction.getIsGradient()){
            setGradient(canvasInstruction.getColorStart(), canvasInstruction.getColorEnd(),
                    canvasInstruction.getGradientDirection());
        } else{
            drawingPanel.setBackground(canvasInstruction.getColorSolid());
        }
    }

    /**
     * helper function to set canvas gradient
     *
     * @param start the start color
     * @param end the end color
     * @param gradientType the direction of gradient
     *          // 0 = horizontal
     *          // 1 = vertical
     *          // 2 = diagonal from top left
     *          // 3 = diagonal from top right
     */
    private void setGradient(Color start, Color end, int gradientType){

        /** canvas height */
        int height = 0;
        /** canvas width */
        int width = 0;
        switch(gradientType){

            case 0:
                height = drawingPanel.getHeight();
                width = drawingPanel.getWidth();
                for(int y = 0; y < height; y++){
                    for(int x = 0; x < width; x++){
                        drawingPanel.setPixel(x, y, colorLerp(start, end, y * 1.0f / height));
                    }
                }
                break;
            case 1:
                height = drawingPanel.getHeight();
                width = drawingPanel.getWidth();
                for(int x = 0; x < width; x++){
                    for(int y = 0; y < height; y++){
                        drawingPanel.setPixel(x, y, colorLerp(start, end, x * 1.0f / width));
                    }
                }
                break;
            case 2:
                height = drawingPanel.getHeight();
                width = drawingPanel.getWidth();
                for(int y = 0; y < height; y++){
                    for(int x = 0; x < width; x++){
                        float t = (y * 0.5f / height) + (x * 0.5f / width);
                        drawingPanel.setPixel(x, y, colorLerp(start, end, floatLerp(0f, 1f, t)));
                    }
                }
                break;
            case 3:
                height = drawingPanel.getHeight();
                width = drawingPanel.getWidth();
                for(int x = 0; x < width; x++){
                    for(int y = 0; y < height; y++){
                        float t = (y * 0.5f / height) + (0.5f - (x * 0.5f / width));
                        drawingPanel.setPixel(x, y, colorLerp(start, end, floatLerp(0f, 1f, t)));
                    }
                }
                break;
            default:
                System.out.println("Invalid gradient specified: " + gradientType);
        }
    }

    /**
     * gets a linear interpolation of two colors
     *
     * @param c1 the first color
     * @param c2 the second color
     * @param t the percentage of c2 (0-1)
     * @return a color that is (t*100)%  between c1 and c2
     */
    private Color colorLerp(Color c1, Color c2, float t){
        if(t < 0){
            t = 0;
        }
        if(t > 1){
            t = 1;
        }
        float r = c1.getRed() + t * (c2.getRed() - c1.getRed());
        float g = c1.getGreen() + t * (c2.getGreen() - c1.getGreen());
        float b = c1.getBlue() + t * (c2.getBlue() - c1.getBlue());
        float a = c1.getAlpha() + t * (c2.getAlpha() - c1.getAlpha());
        if(r > 255){
            r = 255;
        }
        if(g > 255){
            g = 255;
        }
        if(b > 255){
            b = 255;
        }
        if(a > 255){
            a = 255f;
        }
        return new Color(r/255,g/255,b/255,a/255);
    }

    /**
     * gets a linear interpolation of 2 floats
     *
     * @param i1 the first float
     * @param i2 the second float
     * @param t the percentage of i2 (0-1)
     * @return an float that is (t*100)%  between i1 and i2
     */
    private float floatLerp(float i1, float i2, float t){
        return i1 + t * (i2 - i1);
    }

    /**
     * draws all the shapes in the drawInstructions arraylist
     */
    private void drawShapes(){
        for(DrawInstruction instruction : drawInstructions){
            Shape shape = shapeLibrary.getShape(instruction.getShapeName());
            for(int i = 0; i < instruction.getRepeats(); i++){
                Polygon poly = new Polygon();
                int x = instruction.getStartingX();
                int y = instruction.getStartingY();
                if(x == Integer.MIN_VALUE) {
                    x = ThreadLocalRandom.current().nextInt(0, canvasInstruction.getWidth() + 1);
                }
                if(y == Integer.MIN_VALUE) {
                    y = ThreadLocalRandom.current().nextInt(0, canvasInstruction.getHeight() + 1);
                }
                for(Point point : shape.getPoints()){
                    int ptX = (int)point.getX() * instruction.getScalePercent() / 100
                            + x + instruction.getRepeatOffsetX() * i;
                    int ptY = (int)point.getY() * instruction.getScalePercent() / 100
                            + y + instruction.getRepeatOffsetY() * i;
                    poly.addPoint(ptX, ptY);
                }
                graphics.setColor(instruction.getColor());
                if(instruction.getFilled()){
                    graphics.fillPolygon(poly);
                } else{
                    graphics.drawPolygon(poly);
                }
            }
        }
    }

    /**
     * draws the canvas and the shapes
     */
    public void draw(){
        drawCanvas();
        drawShapes();
    }
}

