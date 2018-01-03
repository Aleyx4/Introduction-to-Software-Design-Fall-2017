/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of an Ellipse where
 * Circles are equal radius on the horizontal
 * and vertical axes.</p>
 */
public class Circle extends Ellipse{
    /**
     * Default method for creating a circle of a radius of 1.
     */
    public Circle()
    {
        this(1);
    }

    /**
     * Method to create a circle of a radius specified.
     * Setting the Horizontal and Vertical radius from
     * the inherited class "Ellipse" to be the same
     * radius as a ellipse is a circle but of equal
     * radius.
     * @param radius the radius of the circle to be created
     */
    public Circle(double radius)
    {
        super(radius, radius);
    }
}
