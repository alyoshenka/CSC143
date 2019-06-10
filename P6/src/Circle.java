import java.awt.Graphics;
import java.awt.Color;

/** circle drawing */
public class Circle implements FractalObject{
    /** the x coordinate */
    private int x;
    /** the y coordinate */
    private int y;
    /** the radius */
    private int radius;
    /** the color */
    private Color color;

    /**
     * default constructor
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @param radius the radius
     * @param color the color
     */
    public Circle(int x, int y, int radius, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius; // validation
        this.color = color;
    }

    /**
     * gets the x coordinate
     *
     * @return the x cordinate
     */
    public int getX(){
        return x;
    }

    /**
     * gets the y coordinate
     *
     * @return the y coordinate
     */
    public int getY(){
        return y;
    }

    /**
     * gets the radius
     *
     * @return the radius
     */
    public int getRadius(){
        return radius;
    }

    /**
     * gets the color
     *
     * @return the color
     */
    public Color getColor(){
        return color;
    }

    /**
     * {@inheritDoc}
     */
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, radius, radius);
    }
}
