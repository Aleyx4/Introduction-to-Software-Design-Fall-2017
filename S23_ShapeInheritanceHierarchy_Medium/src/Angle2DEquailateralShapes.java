/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of TwoDimensionalShapes.
 * This will contain any Regular 2D Shapes that
 * have angles but are not right angles.</p>
 */
public class Angle2DEquailateralShapes extends TwoDimensionalShapes{
    /**
     * The length of each side of the Regular Shape.
     */
    private double sidelength;

    /**
     * To retrieve the length of the sides of a Regular Shape
     * @return a double type length of sides of a Regular Shape
     */
    public double getSidelength()
    {
        return sidelength;
    }

    /**
     * To set the length of the sides.
     * @param sidelength a double type of the side length for the Regular Shape
     */
    public void setSidelength(double sidelength)
    {
        this.sidelength = sidelength;
    }

    /**
     * Used to calculate the perimeter with the number of
     * sides times the length of the sides. This will set
     * the perimeter to the inherited methods from the
     * inherited class. As all 2D regular angled shapes
     * have equal length of sides.
     */
    public void calcPerimeter()
    {
        setPerimeter(getEdges()*sidelength);
    }
}
