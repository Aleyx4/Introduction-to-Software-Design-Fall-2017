/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of AngleBase3DShapes. This
 * class will create a Pyramid with a square base
 * and a height of the same length as the base.</p>
 */
public class Pyramid extends AngleBase3DShapes{
    /**
     * This is the Default method to create a Pyramid of
     * a base of a 1 by 1 and a height of 1.
     */
    public Pyramid()
    {
        this(1);
    }

    /**
     * This method allows the creation of a pyramid
     * with a base and height of a specified length.
     * Also calculate and set the volume and surface
     * area.
     * @param edgelength the length of the square base and the height of the pyramid
     */
    public Pyramid(double edgelength)
    {
        setEdgeLength(edgelength);
        //Number of edges a pyramid has.
        setEdges(8);
        //Number of faces a pyramid has.
        setFaces(4);
        calcSurfaceArea();
        calcVolume();
    }

    /**
     * Used to calculate and set the volume by using the basic formula for
     * the volume of a regular pyramid.
     */
    public void calcVolume()
    {
        setVolume((Math.pow(getEdgeLength(),3))/3.0);
    }

    /**
     * Used to calculate and set the surface area by using the basic formula
     * for the surface area of a regular pyramid.
     */
    public void calcSurfaceArea()
    {
        setSurfaceArea(Math.pow(getEdgeLength(),2)+(getEdgeLength()*(Math.sqrt((Math.pow(getEdgeLength(),2)/2.0)+(Math.pow(getEdgeLength(),2)))))+(getEdgeLength()*Math.sqrt((Math.pow((0.5),2))+(Math.pow(getEdgeLength(),2)))));
    }
}
