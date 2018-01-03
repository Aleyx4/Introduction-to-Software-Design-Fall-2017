/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This class is a subclass of Angle2DEquailateralShapes.
 * This class will create a Regular Octagon with all equal
 * sides to a specified length.</p>
 */
public class Octagon extends Angle2DEquailateralShapes{
    /**
     * This is a Default method to create a Octagon
     * with side lengths of 1.
     */
    public Octagon()
    {
        this(1);
    }

    /**
     * This will create a Regular Octagon of a
     * specified side length on all sides and
     * then will calculate and set the area
     * and perimeter.
     * @param sidelength the length of all the sides on the Octagon
     */
    public Octagon(double sidelength)
    {
        setSidelength(sidelength);
        //Set the number of edges on a Octagon.
        setEdges(8);
        calcArea();
        calcPerimeter();
    }

    /**
     * Calculate the area of the Octagon using the basic formula for Regular Octagons.
     */
    public void calcArea()
    {
        setArea(2*(1+Math.sqrt(2))*Math.pow(getSidelength(),2));
    }
}