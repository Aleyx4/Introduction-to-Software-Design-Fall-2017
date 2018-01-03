/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of the Angle2DEquailateralShapes. This
 * class will create a Regular Hexagon with a specified side
 * length.</p>
 */
public class Hexagon extends Angle2DEquailateralShapes{
    /**
     * This is a Default method for creating a hexagon
     * with the side length of 1 on each side.
     */
    public Hexagon()
    {
        this(1);
    }

    /**
     * This is to create a hexagon with a specified
     * side length and then calculate and set the area
     * and perimeter.
     * @param sidelength the side length of the hexagon to be created
     */
    public Hexagon(double sidelength)
    {
        setSidelength(sidelength);
        //Number of edges a hexagon has.
        setEdges(6);
        calcArea();
        calcPerimeter();
    }

    /**
     * Used to calculate and set the area of the hexagon
     * by using the Regular Hexagon Formula.
     */
    public void calcArea()
    {
        setArea(3*(Math.sqrt(3)/2.0)*Math.pow(getSidelength(),2));
    }
}
