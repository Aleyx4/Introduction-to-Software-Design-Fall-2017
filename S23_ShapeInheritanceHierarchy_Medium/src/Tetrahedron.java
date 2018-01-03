/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of AngleBase3DShapes which
 * is to create a Regular Tetrahedron with a
 * specified length of the edges.</p>
 */
public class Tetrahedron extends AngleBase3DShapes{
    /**
     * Default method to create a Tetrahedron with sides
     * with a unit of 1.
     */
    public Tetrahedron()
    {
        this(1);
    }

    /**
     * This method will create a Regular Tetrahedron with sides
     * of a specified length. Then it will calculate and set the
     * area and volume.
     * @param edgelength the length of the sides of the Tetrahedron
     */
    public Tetrahedron(double edgelength)
    {
        setEdgeLength(edgelength);
        //Set the number of edges the Tetrahedron has
        setEdges(6);
        //Set the number of faces the Tetrahedron has
        setFaces(4);
        calcSurfaceArea();
        calcVolume();
    }

    /**
     * Used to calculate the volume of the Tetrahedron using the formula
     * to calculate the volume of a Regular Tetrahedron.
     */
    public void calcVolume()
    {
        setVolume((Math.pow(getEdgeLength(),3))/(6*Math.sqrt(2)));
    }

    /**
     * Used to calculate the surface area of the Tetrahedron using the formula
     * to calculate the surface area of the Regular Tetrahedron.
     */
    public void calcSurfaceArea()
    {
        setSurfaceArea(Math.sqrt(3)*(Math.pow(getEdgeLength(),2)));
    }
}
