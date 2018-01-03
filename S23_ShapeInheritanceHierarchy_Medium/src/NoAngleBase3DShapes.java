/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of ThreeDimensionalShapes. This will
 * contain shapes that have a rounded base. Since they will be
 * regular 3D shapes they will be all containing a radius of the
 * size of the base.</p>
 */
public class NoAngleBase3DShapes extends ThreeDimensionalShapes{
    /**
     * The radius of the base of the 3D shape.
     */
    private double radius;

    /**
     * To retrieve the radius of the base.
     * @return the radius of the base of the 3D shape
     */
    public double getRadius()
    {
        return radius;
    }

    /**
     * To set the radius of the base.
     * @param radius the radius of the base on the 3D shape
     */
    public void setRadius(double radius)
    {
        this.radius = radius;
    }
}
