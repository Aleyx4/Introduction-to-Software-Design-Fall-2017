/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of NoAngleBase3DShapes. This will
 * create a Regular Cylinder with a circular base of a
 * specified radius and height.</p>
 */
public class Cylinder extends NoAngleBase3DShapes{
    /**
     * This is the height of the Cylinder in a double type.
     */
    private double height;

    /**
     * The Default method for creating a Cylinder of a radius and height of 1.
     */
    public Cylinder()
    {
        this(1,1);
    }

    /**
     * Method to create a cylinder of a specified
     * radius and height. Then calculate and set
     * the surface area and volume.
     * @param radius the radius of the base circle of the cylinder
     * @param height the height of the cylinder from base to base
     */
    public Cylinder(double radius, double height)
    {
        setRadius(radius);
        setHeight(height);
        //Number of edges oon a cylinder
        setEdges(0);
        //Number of faces on a cylinder
        setFaces(2);
        calcSurfaceArea();
        calcVolume();
    }

    /**
     * To set the height of the cylinder.
     * @param height the height of the cylinder from base to base
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * To get the height of the cylinder.
     * @return the height of the cylinder
     */
    public double getHeight() {
        return height;
    }

    /**
     * Used to calculate and set the surface area
     * of the Cylinder by using the formula for Cylinders.
     */
    public void calcSurfaceArea()
    {
        setSurfaceArea((2*Math.PI*getRadius()*getHeight())+(2*Math.PI*Math.pow(getRadius(),2)));
    }

    /**
     * Used to calculate and set the volume
     * of the Cylinder by using the formula
     * for Cylinders.
     */
    public void calcVolume()
    {
        setVolume(Math.PI*Math.pow(getRadius(),2)*getHeight());
    }
}
