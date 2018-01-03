/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of NoAngleBase3DShapes. This
 * class will create a circular based Regular cone with a
 * specified height.</p>
 */
public class Cone extends NoAngleBase3DShapes
{
    /**
     * The height of the cone in a double type.
     */
    private double height;

    /**
     * The Default method for creating a cone of a radius base of 1 and height of 1.
     */
    public Cone()
    {
        this(1,1);
    }

    /**
     * Method to create a cone of a specified radius and
     * height. Then calculating and setting its surface
     * area and volume.
     * @param radius the radius of the base circle of the cone to be created
     * @param height the height of the cone to be created
     */
    public Cone(double radius, double height)
    {
        setRadius(radius);
        setHeight(height);
        //Number of Edges on a Cone (Inherited Feature from the Shapes Class)
        setEdges(0);
        //Number of Faces on a Cone (Inherited Feature from the Shapes Class)
        setFaces(1);
        calcSurfaceArea();
        calcVolume();
    }

    /**
     * To set the height of the cone.
     * @param height the height of the cone
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * To get the height of the cone.
     * @return the height of the cone
     */
    public double getHeight() {
        return height;
    }

    /**
     * Used to calculate and set the surface area of the 3D shape
     * using the formula for cones.
     */
    public void calcSurfaceArea()
    {
        setSurfaceArea(Math.PI*getRadius()*(getRadius()+Math.sqrt(Math.pow(getHeight(),2)+(Math.pow(getRadius(),2)))));
    }

    /**
     * Used to calculate and set the volume
     * of a 3D shape using the formula for
     * cones.
     */
    public void calcVolume()
    {
        setVolume(Math.PI*Math.pow(getRadius(),2)*(getHeight()/3.0));
    }
}
