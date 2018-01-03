import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * This is a class that holds the properties of a ball. It contains the following:
 * 1) The Color of the Ball
 * 2) The X and Y Location of the Ball
 * 3) The Size of the Ball
 * 4) The Speed of the Ball
 *
 * These properties will be used in the Bouncing Balls Application.
 */
public class Ball {
    /**
     * The color that will be created using a random composition of reds, greens, and blues.
     */
    private Color color;
    /**
     * The X location of the Ball
     */
    private int xlocation;
    /**
     * The Y location of the Ball
     */
    private int ylocation;
    /**
     * The overall radius of the size of the ball.
     */
    private int size;
    /**
     * The Red value for the color of the ball.
     */
    private int red;
    /**
     * The Blue value for the color of the ball.
     */
    private int blue;
    /**
     * The Green value for the color of the ball.
     */
    private int green;
    /**
     * The X speed and direction for the movement of the ball.
     */
    private int xspeed;
    /**
     * The Y speed and direction for the movement of the ball.
     */
    private int yspeed;

    /**
     * The constructor for the Ball class that will generate its color, size, location, and speed.
     * This will utilize the size of the window to determine the bounds of the ball location.
     * @param frame The window that will have the balls be displayed
     */
    public Ball(JFrame frame) {
        Random ran = new Random();
        red = ran.nextInt(256);
        ran = new Random();
        blue = ran.nextInt(256);
        ran = new Random();
        green = ran.nextInt(256);
        color = new Color(red, green, blue);
        size = ran.nextInt(30) + 10;
        ran = new Random();
        xlocation = ran.nextInt(frame.getComponent(0).getWidth());
        ran = new Random();
        ylocation = ran.nextInt(frame.getComponent(0).getHeight());
        ran = new Random();
        xspeed = ran.nextInt(5) - 5;
        ran = new Random();
        yspeed = ran.nextInt(5) - 5;
    }

    /**
     * Retrieve the color object that has the color composition.
     * @return Color object that holds the color composition that was randomly generated
     */
    public Color getColor() {
        return color;
    }

    /**
     * Retrieve the Radius of the Ball Size.
     * @return The integer value of the radius of the ball
     */
    public int getSize() {
        return size;
    }

    /**
     * Retrieve the X Speed and Direction.
     * @return The integer value of the X speed and direction
     */
    public int getXspeed() {
        return xspeed;
    }

    /**
     * Retrieve the Y Speed and Direction.
     * @return The integer value of the Y speed and direction
     */
    public int getYspeed() {
        return yspeed;
    }

    /**
     * Retrieve the X Location.
     * @return The integer value of the X location
     */
    public int getXlocation() {
        return xlocation;
    }

    /**
     * Retrieve the Y Location.
     * @return The integer value of the Y location
     */
    public int getYlocation() {
        return ylocation;
    }

    /**
     * Setting the X Location.
     * @param xlocation The integer value for the X location.
     */
    public void setXlocation(int xlocation) {
        this.xlocation = xlocation;
    }

    /**
     * Setting the Y Location.
     * @param ylocation The integer value for the Y location
     */
    public void setYlocation(int ylocation) {
        this.ylocation = ylocation;
    }

    /**
     * Setting the X Speed and Direction.
     * @param xspeed The integer value for the speed and direction in the X direction.
     */
    public void setXspeed(int xspeed) {
        this.xspeed = xspeed;
    }

    /**
     * Setting the Y Speed and Direction.
     * @param yspeed The integer value for the speed and direction in the Y direction.
     */
    public void setYspeed(int yspeed) {
        this.yspeed = yspeed;
    }

    /**
     * The method to add a ball in the specific JPanel with the Paint Component Graphics Object.
     * @param g The Graphics object from the specific JPanel that wants a ball to be drawn
     */
    public void addBall(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getXlocation(), getYlocation(), getSize(), getSize());
    }
}
