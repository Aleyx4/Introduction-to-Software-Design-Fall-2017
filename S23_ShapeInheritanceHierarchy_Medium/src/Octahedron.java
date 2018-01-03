/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of AngleBase3DShapes.
 * This class will create a Octahedron with
 * all edges the same length.</p>
 */
public class Octahedron extends AngleBase3DShapes{
    /**
     * Default method that will create a Octahedron
     * with edge lengths of 1.
     */
    public Octahedron()
    {
        this(1);
    }

    /**
     * Method that will create a octahedron of
     * edge lengths of a desired legnth.
     * @param edgelength the edge lengths for all edges of the octahedron
     */
    public Octahedron(double edgelength)
    {
        setEdgeLength(edgelength);
        //Number of edges an octahedron has.
        setEdges(12);
        //Number of faces an octahedron has.
        setFaces(8);
        calcSurfaceArea();
        calcVolume();
    }

    /**
     * Calculate and set the volume of the octahedron.
     * Using the base formula for the volume of a octahedron.
     */
    public void calcVolume()
    {
        setVolume(Math.sqrt(2)*(Math.pow(getEdgeLength(),3)/3.0));
    }

    /**
     * Calculate and set the surface area of the octahedron.
     * Using the base formula for the surface area of a octahedron.
     */
    public void calcSurfaceArea()
    {
        setSurfaceArea(2*Math.sqrt(3)*Math.pow(getEdgeLength(),2));
    }
}
