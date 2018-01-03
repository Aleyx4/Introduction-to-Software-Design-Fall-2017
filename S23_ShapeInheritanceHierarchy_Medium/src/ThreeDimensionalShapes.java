/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of the Shapes class that will hold
 * only #D shapes, In the shapes class we can determine that
 * all 3D shape must have a volume and surface area.</p>
 */
public class ThreeDimensionalShapes extends Shapes{
    /**
     * The volume of the 3D shape.
     */
    private double volume;
    /**
     * The Surface Area of the #D shape.
     */
    private double surfacearea;

    /**
     * Retrieve the volume of the shape.
     * @return volume of the shape
     */
    public double getVolume()
    {
        return volume;
    }

    /**
     * Retrieve the surface area of the shape.
     * @return the surface area of the shape
     */
    public double getSurfaceArea()
    {
        return surfacearea;
    }

    /**
     * Set the volume of the 3D shape.
     * @param volume volume of the 3D shape
     */
    public void setVolume(double volume)
    {
        this.volume = volume;
    }

    /**
     * Set the surface area of the 3D shape.
     * @param surfacearea surface area of the 3D shape
     */
    public void setSurfaceArea(double surfacearea)
    {
        this.surfacearea = surfacearea;
    }
}
