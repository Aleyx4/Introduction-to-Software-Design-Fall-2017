/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of TwoDimensionalShapes. This class
 * will contain shapes with right angles. All right angled
 * shapes will have an area of just multiplying the base and
 * its height. The perimeter will be the total of two times
 * the base plus two times the height. As all right angled shapes
 * can only contain four sides.</p>
 */
public class RightAngle2DShapes extends TwoDimensionalShapes{
    /**
     * The length of the base.
     */
    private double base;
    /**
     * The length of the height.
     */
    private double height;

    /**
     * This will set the edges to be four when another class
     * inherits this class it would only have right angles
     * therefore it can only have exactly four edges.
     */
    public RightAngle2DShapes()
    {
        setEdges(4);
    }

    /**
     * Retrieve the base length.
     * @return base length of the shape.
     */
    public double getBase() {
        return base;
    }

    /**
     * Retrieve the base height length.
     * @return height length of the shape
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * Set the base length of the shape.
     * @param base the base length of the shape
     */
    public void setBase(double base)
    {
        this.base = base;
    }

    /**
     * Set the height length of the shape.
     * @param height the height length of the shape
     */
    public void setHeight(double height)
    {
        this.height = height;
    }

    /**
     * Calculate and set the perimeter of the shape with the default
     * formula of all regular quadrilaterals.
     */
    public void calcPerimeter()
    {
        setPerimeter((2*getBase())+(2*getHeight()));
    }

    /**
     * Calculate and set the area of the Regular Quadrilaterals with right angles.
     * Using the generic area calculation (base times height).
     */
    public void calcArea()
    {
        setArea(getBase()*getHeight());
    }
}
