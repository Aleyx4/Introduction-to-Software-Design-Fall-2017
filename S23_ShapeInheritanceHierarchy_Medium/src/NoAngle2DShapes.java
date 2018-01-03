/**
 * This is a subclass of TwoDimensionalShapes.
 * This class will contain 2D shapes that are rounded.
 * These shapes will automatically only have a total of
 * one edge as it contains no angles. Regular shapes
 * that are rounded will have a horizontal and vertical
 * radius. To calculate this we can use the formula of
 * an ellipse to get the area and circumference.
 */
public class NoAngle2DShapes extends TwoDimensionalShapes{
    /**
     * This is the radius in the vertical axis.
     */
    private double verticalradius;
    /**
     * This is the radius in the horizontal axis.
     */
    private double horizontalradius;

    /**
     * This method will set the edges of the shape to 1.
     * Since if another class inherits this class then it should also
     * only have one edge if it is circular without any angles.
     */
    public NoAngle2DShapes()
    {
        setEdges(1);
    }

    /**
     * Retrieve the vertical radius.
     * @return the vertical radius
     */
    public double getVerticalRadius()
    {
        return verticalradius;
    }

    /**
     * Retrieve the horizontal radius.
     * @return the horizontal radius
     */
    public double getHorizontalRadius()
    {
        return horizontalradius;
    }

    /**
     * Used to calculate and set the area of a circular shape.
     */
    public void calcArea()
    {
        setArea(getHorizontalRadius()*getVerticalRadius()*Math.PI);
    }

    /**
     * Used to calculate and set the perimeter of a circular shape.
     */
    public void calcPerimeter()
    {
        setPerimeter(Math.PI*(3*(getVerticalRadius()+getHorizontalRadius())-Math.sqrt((3*getVerticalRadius()+getHorizontalRadius())*(getVerticalRadius()+3*getHorizontalRadius()))));
    }

    /**
     * Set the vertical radius value.
     * @param verticalradius the vertical radius
     */
    public void setVerticalRadius(double verticalradius)
    {
        this.verticalradius = verticalradius;
    }

    /**
     * Set the horizontal radius value.
     * @param horizontalradius the horizontal radius
     */
    public void setHorizontalRadius(double horizontalradius)
    {
        this.horizontalradius = horizontalradius;
    }
}
