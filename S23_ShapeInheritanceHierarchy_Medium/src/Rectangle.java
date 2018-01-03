/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of RightAngle2DShapes. This will
 * create a Rectangle of a specified base and height.</p>
 */
public class Rectangle extends RightAngle2DShapes{
    /**
     * Default method that will create a rectangle with a
     * base of 2 and height of 1.
     */
    public Rectangle()
    {
        this(2,1);
    }

    /**
     * This method will create a rectangle of a desired
     * base and height that is specified. Also it will
     * calculate and set the area and perimeter.
     * @param base the length of the base for the rectangle
     * @param height the length of the height for the rectangle
     */
    public Rectangle(double base, double height)
    {
        setBase(base);
        setHeight(height);
        calcPerimeter();
        calcArea();
    }
}
