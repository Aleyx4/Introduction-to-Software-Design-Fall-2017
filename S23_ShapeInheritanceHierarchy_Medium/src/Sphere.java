/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of the NoAngleBase3DShapes. This
 * class will create a sphere of a specified radius.</p>
 */
public class Sphere extends NoAngleBase3DShapes{
    /**
     * Default method to create a sphere of a radius of 1.
     */
    public Sphere()
    {
        this(1);
    }

    /**
     * Method that will create a sphere of a specified radius.
     * Also will calculate and set the surface area and volume.
     * @param radius the radius of the sphere
     */
    public Sphere(double radius)
    {
        setRadius(radius);
        //The number of edges a Sphere has
        setEdges(0);
        //The number of faces a Sphere has
        setFaces(0);
        calcSurfaceArea();
        calcVolume();
    }

    /**
     * Calculate and set the surface area of the sphere using the basic formulas.
     */
    public void calcSurfaceArea()
    {
        setSurfaceArea(4*Math.PI*Math.pow(getRadius(),2));
    }

    /**
     * Calculate and set the volume of the sphere usin the basic formulas.
     */
    public void calcVolume()
    {
        setVolume(4*Math.PI*(Math.pow(getRadius(),3)/3.0));
    }
}
