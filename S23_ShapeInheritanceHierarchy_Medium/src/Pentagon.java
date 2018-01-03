/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of Angle2DEquailateralShapes. This
 * class will create a Regular Pentagon with equal sides of
 * a specified length.</p>
 */
public class Pentagon extends Angle2DEquailateralShapes{
    /**
     * Default method will create a pentagon with
     * sides of a legnth of 1.
     */
    public Pentagon()
    {
        this(1);
    }

    /**
     * This method will create a regular pentagon of
     * side lengths of s specific length and then
     * calculate and set its area and perimeter.
     * @param sidelength the length of all the sides of the pentagon
     */
    public Pentagon(double sidelength)
    {
        setSidelength(sidelength);
        //Number of edges a pentagon has
        setEdges(5);
        calcArea();
        calcPerimeter();
    }

    /**
     * This will calculate and set the area of the pentagon
     * with the base formula of a regular pentagon.
     */
    public void calcArea()
    {
        setArea((0.25)*(Math.sqrt(5*(5+(2*Math.sqrt(5)))))*Math.pow(getSidelength(),2));
    }
}
