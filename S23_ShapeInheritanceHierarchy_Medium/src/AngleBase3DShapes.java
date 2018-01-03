/**
 * @author Alex Wong
 * @version 1.0
 * <p>This is a subclass of ThreeDimensionalShapes.
 * This will contain the 3D shapes that have angles
 * and on rounded sides. All these shapes are Regular
 * 3D shapes.</p>
 */
public class AngleBase3DShapes extends ThreeDimensionalShapes{
    /**
     * The length of each edge of the shape.
     */
    private double edgelength;

    /**
     * This will get the edge length of the shape.
     * @return an double type of the edge length
     */
    public double getEdgeLength()
    {
        return edgelength;
    }

    /**
     * To set the length of the edges of the Regular 3D shape.
     * @param edgelength a double type of the edge length for all edges of the Regular Shape
     */
    public void setEdgeLength(double edgelength)
    {
        this.edgelength = edgelength;
    }
}
