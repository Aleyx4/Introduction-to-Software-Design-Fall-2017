/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is the subclass of Angle2DEquailateralShapes. This will
 * create a Equilateral Triangle with equal sides of a specified side length.</p>
 */
public class Triangle extends Angle2DEquailateralShapes{
    /**
     * Default method to create a Triangle with sides of 1 unit.
     */
    public Triangle()
    {
        this(1);
    }

    /**
     * This method is to create a triangle will a specified
     * unit of length. Also will calculate and set the area
     * and perimeter.
     * @param sidelength the length of the sides of the triangle
     */
    public Triangle(double sidelength)
    {
        setSidelength(sidelength);
        //Set the number of edges a Triangle has
        setEdges(3);
        calcArea();
        calcPerimeter();
    }

    /**
     * Calculate the area of the Triangle by using the basic triangle formula
     * by multiplying the base and the height and dividing it in half.
     */
    public void calcArea()
    {
        setArea(Math.sqrt(3)*((Math.pow(getSidelength(),2))/4.0));
    }
}
