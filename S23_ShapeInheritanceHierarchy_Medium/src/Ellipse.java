/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of NoAngle2S Shapes. This
 * class will create a ellipse with a defined
 * vertical and horizontal radius.</p>
 */
public class Ellipse extends NoAngle2DShapes{
    /**
     * Default method that will create a ellipse with
     * a horizontal radius of 2 and a vertical radius
     * of 1.
     */
    public Ellipse()
    {
        this(2,1);
    }

    /**
     * Method to create a ellipse with a specified vertical
     * and horizontal radius. Then calculate and set the area
     * and perimeter using the inherited methods.
     * @param horizontalradius the horizontal radius of the ellipse
     * @param verticalradius the vertical radius of the ellipse
     */
    public Ellipse(double horizontalradius, double verticalradius)
    {
        setHorizontalRadius(horizontalradius);
        setVerticalRadius(verticalradius);
        super.calcArea();
        super.calcPerimeter();
    }
}
