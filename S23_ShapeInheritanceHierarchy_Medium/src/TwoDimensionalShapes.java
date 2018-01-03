/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of the Shapes class that will hold only
 * 2D shapes. In the shapes class we can determine that all 2D
 * shapes can only have 1 face. We also know that 2D shapes can
 * only have area and perimeter.</p>
 */
public class TwoDimensionalShapes extends Shapes{
    /**
     * The area of the 2D shape.
     */
    private double area;
    /**
     * The perimeter of the 2D shape.
     */
    private double perimeter;

    /**
     * This method will set the number of faces on all
     * 2D shapes to 1. Since if another class inherits
     * this class it should also only have 1 face since
     * it should also be 2D.
     */
    public TwoDimensionalShapes()
    {
        setFaces(1);
    }

    /**
     * Retrieve the area of the 2D shape.
     * @return area of the 2D shape in type double
     */
    public double getArea()
    {
        return area;
    }

    /**
     * Retrieve the perimeter of the 2D shape.
     * @return perimeter of the 2D shape in type double
     */
    public double getPerimeter()
    {
        return perimeter;
    }

    /**
     * Set the area of the 2D shape.
     * @param area area of the 2D shape in type double
     */
    public void setArea(double area)
    {
        this.area = area;
    }

    /**
     * Set the perimeter of the 2D shape.
     * @param perimeter perimeter of the 2D shape in type double
     */
    public void setPerimeter(double perimeter)
    {
        this.perimeter = perimeter;
    }
}
