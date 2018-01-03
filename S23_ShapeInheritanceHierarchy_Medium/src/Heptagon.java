/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of Angle2DEquailateralShapes.
 * This class will create a Regular Heptagon with all
 * the sides equal to a specified length.</p>
 */
public class Heptagon extends Angle2DEquailateralShapes{
    /**
     * This is the Default method to create a Heptagon
     * with the sides of length 1.
     */
    public Heptagon()
    {
        this(1);
    }

    /**
     * This method creates a Regular Heptagon of
     * a specified equal side length. Then calculate
     * and set the area and perimeter.
     * @param sidelength the side length of a radius
     */
    public Heptagon(double sidelength)
    {
        setSidelength(sidelength);
        //Set the number of edges a Heptagon has
        setEdges(7);
        calcArea();
        calcPerimeter();
    }

    /**
     * Used to calculate and set the area of the heptagon using
     * the base formula for a regular heptagon.
     */
    public void calcArea()
    {
        setArea((1.75)*((Math.pow(getSidelength(),2))/(Math.tan(Math.PI/7.0))));
    }
}
