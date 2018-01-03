/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of AngleBase3DShapes. This class
 * will create a Cube with the specified edge length.</p>
 */
public class Cube extends AngleBase3DShapes{
    /**
     * The Default method for creating a cube of all edge lengths of 1.
     */
    public Cube()
{
    this(1);
}

    /**
     * Method to create a cube of a specified
     * edge length. Then calculating and setting
     * its surface area and volume.
     * @param edgelength the length of the edge
     */
    public Cube(double edgelength)
    {
        setEdgeLength(edgelength);
        //Set the number of edges a cube has. (Inherited Method from the Shapes Class)
        setEdges(12);
        //Set the number of faces a cube has. (Inherited Method from the Shapes Class)
        setFaces(6);
        calcSurfaceArea();
        calcVolume();
    }

    /**
     * Used to calculate and set the volume of the cube using the base formula.
     */
    public void calcVolume()
    {
        setVolume(Math.pow(getSurfaceArea(),3));
    }

    /**
     * Used to calculate and set the surface area of the cube using the base formula.
     */
    public void calcSurfaceArea()
    {
        setSurfaceArea(6*Math.pow(getSurfaceArea(),2));
    }
}
