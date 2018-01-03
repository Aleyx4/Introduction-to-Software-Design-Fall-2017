/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is the Shapes class that all the shapes branch and
 * inherit from. All shapes will have a name, the number of
 * edges it contains, and the number of faces it has. It is
 * worth noting 2D shapes can only have 1 face.</p>
 */
public class Shapes {
    /**
     * The is the name for a shape that is created.
     */
    private String name;
    /**
     * This is the number of edges a shape has.
     */
    private int edges;
    /**
     * This is the number of faces a shape has.
     */
    private int faces;

    /**
     * Retrieve the name of a shape.
     * @return the String of the name of a shape created
     */
    public String getName()
    {
        return name;
    }

    /**
     * To set the name of the shape that is created
     * @param name the name of a shape that is created
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Retrieve the number of edges a shape has.
     * @return the number of edges a shape has in integer form
     */
    public int getEdges()
    {
        return edges;
    }

    /**
     * To set the number of edges a shape has.
     * @param edges the integer of the number of edges a shape has
     */
    public void setEdges(int edges)
    {
        this.edges = edges;
    }

    /**
     * Retrieve the number of faces a shape has.
     * @return the integer form of the number of faces a shape has
     */
    public int getFaces() {
        return faces;
    }

    /**
     * To set the number of faces a shape has.
     * @param faces the integer form of the number of faces a shape has
     */
    public void setFaces(int faces)
    {
        this.faces = faces;
    }
}
