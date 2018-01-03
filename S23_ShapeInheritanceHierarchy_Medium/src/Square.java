/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a subclass of Rectangle. This class will create
 * a Square with the specified length.</p>
 */
public class Square extends Rectangle{
    /**
     * This is the Default method ti create a Square with
     * the side length being 1.
     */
    public Square()
    {
        this(1);
    }

    /**
     * This method will create a square that
     * is the specified side length and then
     * it will compute and set the area and
     * perimeter by using the inherited class
     * called Rectangle. As a rectangle is the
     * same as a Square but a square has all
     * equal sides.
     * @param sidelength the length of the sides for the square created
     */
    public Square(double sidelength)
    {
        super(sidelength, sidelength);
    }
}
