import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.LinkedList;

/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a driver class that takes all of the basic functionality the
 * shapes class has and utilizes it to allow the user to create a shape of
 * there desire and specify its dimensions. This program will save the
 * shapes it creates to be printed out later when the user specifies to.
 * The user will be able to see the area, perimeter, volume, and surface
 * area depending on the shape. The user is also able to name the shape
 * to there desire as well.</p>
 */
public class ShapesTest {
    /**
     * The Scanner Object to be used for the users input.
     */
    private static Scanner userinput = new Scanner(System.in);
    /**
     * The LinkedList to store the shape objects.
     */
    private static LinkedList shapelist = new LinkedList();

    public static void main(String args[])
    {
        boolean run = true;

        while(run)
        {
            displayMenu();
            int input = userinput.nextInt();
            switch (input)
            {
                default:
                    System.out.println("ERROR - Input is Invalid");
                    break;
                case 1:
                    createShape();
                    break;
                case 2:
                    System.out.println("List of Shapes Created: ");
                    System.out.println("------------------------");
                    for(int i = 0; i<shapelist.size(); i++)
                    {
                        readShape(shapelist.get(i));
                    }
                    break;
                case 3:
                    run = false;
                    break;
            }
        }
    }

    /**
     * Displays the menu items that user can use
     * from being able to create a shape, look
     * at previously made shapes, or exiting the
     * program.
     */
    public static void displayMenu()
    {
        System.out.println("--Please Enter One of the Following Options--");
        System.out.println("1) Create Shape");
        System.out.println("2) Look at Existing Shape");
        System.out.println("3) Exit");
        System.out.println("---------------------------------------------");
    }

    /**
     * Allows the use of reading the type of shape object it contains
     * and print out or display its details of the name of the shape,
     * the shape it is, the area, perimeter, volume, or surface area
     * of the shape and its features.
     * @param obj an object that is  a shape from the Shapes class
     */
    public static void readShape(Object obj)
    {
        if(obj instanceof Square)
        {
            Square square = (Square)obj;
            System.out.println("Shape: Square");
            System.out.println("Shape Name: " + square.getName());
            System.out.println("Faces: " + square.getFaces());
            System.out.println("Edges: " + square.getEdges());
            System.out.println("Area: " + square.getArea());
            System.out.println("Perimeter: " + square.getPerimeter());
        }
        else if(obj instanceof Rectangle)
        {
            Rectangle rectangle = (Rectangle)obj;
            System.out.println("Shape: Rectangle");
            System.out.println("Shape Name: " + rectangle.getName());
            System.out.println("Faces: " + rectangle.getFaces());
            System.out.println("Edges: " + rectangle.getEdges());
            System.out.println("Area: " + rectangle.getArea());
            System.out.println("Perimeter: " + rectangle.getPerimeter());
        }
        else if(obj instanceof Pentagon)
        {
            Pentagon pentagon = (Pentagon) obj;
            System.out.println("Shape: Pentagon");
            System.out.println("Shape Name: " + pentagon.getName());
            System.out.println("Faces: " + pentagon.getFaces());
            System.out.println("Edges: " + pentagon.getEdges());
            System.out.println("Area: " + pentagon.getArea());
            System.out.println("Perimeter: " + pentagon.getPerimeter());
        }
        else if(obj instanceof Hexagon)
        {
            Hexagon hexagon = (Hexagon) obj;
            System.out.println("Shape: Hexagon");
            System.out.println("Shape Name: " + hexagon.getName());
            System.out.println("Faces: " + hexagon.getFaces());
            System.out.println("Edges: " + hexagon.getEdges());
            System.out.println("Area: " + hexagon.getArea());
            System.out.println("Perimeter: " + hexagon.getPerimeter());
        }
        else if(obj instanceof Octagon)
        {
            Octagon octagon = (Octagon) obj;
            System.out.println("Shape: Octagon");
            System.out.println("Shape Name: " + octagon.getName());
            System.out.println("Faces: " + octagon.getFaces());
            System.out.println("Edges: " + octagon.getEdges());
            System.out.println("Area: " + octagon.getArea());
            System.out.println("Perimeter: " + octagon.getPerimeter());
        }
        else if(obj instanceof Circle)
        {
            Circle circle = (Circle)obj;
            System.out.println("Shape: Circle");
            System.out.println("Shape Name: " + circle.getName());
            System.out.println("Faces: " + circle.getFaces());
            System.out.println("Edges: " + circle.getEdges());
            System.out.println("Area: " + circle.getArea());
            System.out.println("Circumference: " + circle.getPerimeter());
        }
        else if(obj instanceof Ellipse)
        {
            Ellipse ellipse = (Ellipse) obj;
            System.out.println("Shape: Ellipse");
            System.out.println("Shape Name: " + ellipse.getName());
            System.out.println("Faces: " + ellipse.getFaces());
            System.out.println("Edges: " + ellipse.getEdges());
            System.out.println("Area: " + ellipse.getArea());
            System.out.println("Circumference: " + ellipse.getPerimeter());
        }
        else if(obj instanceof Cube)
        {
            Cube cube = (Cube)obj;
            System.out.println("Shape: Cube");
            System.out.println("Shape Name: " + cube.getName());
            System.out.println("Faces: " + cube.getFaces());
            System.out.println("Edges: " + cube.getEdges());
            System.out.println("Volume: " + cube.getVolume());
            System.out.println("Surface Area: " + cube.getSurfaceArea());
        }
        else if(obj instanceof Pyramid)
        {
            Pyramid pyramid = (Pyramid) obj;
            System.out.println("Shape: Pyramid");
            System.out.println("Shape Name: " + pyramid.getName());
            System.out.println("Faces: " + pyramid.getFaces());
            System.out.println("Edges: " + pyramid.getEdges());
            System.out.println("Volume: " + pyramid.getVolume());
            System.out.println("Surface Area: " + pyramid.getSurfaceArea());
        }
        else if(obj instanceof Tetrahedron)
        {
            Tetrahedron tetrahedron = (Tetrahedron) obj;
            System.out.println("Shape: Tetrahedron");
            System.out.println("Shape Name: " + tetrahedron.getName());
            System.out.println("Faces: " + tetrahedron.getFaces());
            System.out.println("Edges: " + tetrahedron.getEdges());
            System.out.println("Volume: " + tetrahedron.getVolume());
            System.out.println("Surface Area: " + tetrahedron.getSurfaceArea());
        }
        else if(obj instanceof Octahedron)
        {
            Octahedron octahedron = (Octahedron)obj;
            System.out.println("Shape: Octahedron");
            System.out.println("Shape Name: " + octahedron.getName());
            System.out.println("Faces: " + octahedron.getFaces());
            System.out.println("Edges: " + octahedron.getEdges());
            System.out.println("Volume: " + octahedron.getVolume());
            System.out.println("Surface Area: " + octahedron.getSurfaceArea());
        }
        else if(obj instanceof Cone)
        {
            Cone cone = (Cone) obj;
            System.out.println("Shape: Cone");
            System.out.println("Shape Name: " + cone.getName());
            System.out.println("Faces: " + cone.getFaces());
            System.out.println("Edges: " + cone.getEdges());
            System.out.println("Volume: " + cone.getVolume());
            System.out.println("Surface Area: " + cone.getSurfaceArea());
        }
        else if(obj instanceof Sphere)
        {
            Sphere sphere = (Sphere) obj;
            System.out.println("Shape: Sphere");
            System.out.println("Shape Name: " + sphere.getName());
            System.out.println("Faces: " + sphere.getFaces());
            System.out.println("Edges: " + sphere.getEdges());
            System.out.println("Volume: " + sphere.getVolume());
            System.out.println("Surface Area: " + sphere.getSurfaceArea());
        }
        else if(obj instanceof Cylinder)
        {
            Cylinder cylinder = (Cylinder) obj;
            System.out.println("Shape: Cylinder");
            System.out.println("Shape Name: " + cylinder.getName());
            System.out.println("Faces: " + cylinder.getFaces());
            System.out.println("Edges: " + cylinder.getEdges());
            System.out.println("Volume: " + cylinder.getVolume());
            System.out.println("Surface Area: " + cylinder.getSurfaceArea());
        }
        System.out.println();
    }

    /**
     * The method to create a shape the user desires with the users inputs.
     * Saving the shapes created into a linkedlist to be recalled when
     * looking back at created shapes.
     */
    private static void createShape()
    {
        System.out.println("Please Input Unique Name for Your Shape: ");
        userinput.nextLine();
        String nameinput = userinput.nextLine();
        System.out.println("Please Choose a Shape to Create: ");
        System.out.println("1) Rectangle 9) Cube");
        System.out.println("2) Square    10) Pyramid");
        System.out.println("3) Pentagon  11) Tetrahedron");
        System.out.println("4) Hexagon   12) Octahedron");
        System.out.println("5) Heptagon  13) Cone");
        System.out.println("6) Octagon   14) Sphere");
        System.out.println("7) Ellipse   15) Cylinder");
        System.out.println("8) Circle    0) CANCEL");
        System.out.println("---------------------------------");
        int shapeinput = userinput.nextInt();
        int state = 0;
        double sidelength1, sidelength2;
        try {
            switch (shapeinput) {
                case 1:
                    System.out.println("Please Input Base Size: ");
                    sidelength1 = userinput.nextDouble();
                    System.out.println("Please Input Height Size: ");
                    sidelength2 = userinput.nextDouble();
                    Rectangle rectangle = new Rectangle(sidelength1, sidelength2);
                    rectangle.setName(nameinput);
                    shapelist.addLast(rectangle);
                    break;
                case 2:
                    System.out.println("Please Input Side Length: ");
                    sidelength1 = userinput.nextDouble();
                    Square square = new Square(sidelength1);
                    square.setName(nameinput);
                    shapelist.addLast(square);
                    break;
                case 3:
                    System.out.println("Please Input Side Length: ");
                    sidelength1 = userinput.nextDouble();
                    Pentagon pentagon = new Pentagon(sidelength1);
                    pentagon.setName(nameinput);
                    shapelist.addLast(pentagon);
                    break;
                case 4:
                    System.out.println("Please Input Side Length: ");
                    sidelength1 = userinput.nextDouble();
                    Hexagon hexagon = new Hexagon(sidelength1);
                    hexagon.setName(nameinput);
                    shapelist.addLast(hexagon);
                    break;
                case 5:
                    System.out.println("Please Input Side Length: ");
                    sidelength1 = userinput.nextDouble();
                    Heptagon heptagon = new Heptagon(sidelength1);
                    heptagon.setName(nameinput);
                    shapelist.addLast(heptagon);
                    readShape(heptagon);
                    break;
                case 6:
                    System.out.println("Please Input Side Length: ");
                    sidelength1 = userinput.nextDouble();
                    Octagon octagon = new Octagon(sidelength1);
                    octagon.setName(nameinput);
                    shapelist.addLast(octagon);
                    break;
                case 7:
                    System.out.println("Please Input Horizontal Radius: ");
                    sidelength1 = userinput.nextDouble();
                    System.out.println("Please Input Vertical Radius: ");
                    sidelength2 = userinput.nextDouble();
                    Ellipse ellipse = new Ellipse(sidelength1, sidelength2);
                    ellipse.setName(nameinput);
                    shapelist.addLast(ellipse);
                    break;
                case 8:
                    System.out.println("Please Input Radius: ");
                    sidelength1 = userinput.nextDouble();
                    Circle circle = new Circle(sidelength1);
                    circle.setName(nameinput);
                    shapelist.addLast(circle);
                    break;
                case 9:
                    System.out.println("Please Input Side Length: ");
                    sidelength1 = userinput.nextDouble();
                    Cube cube = new Cube(sidelength1);
                    cube.setName(nameinput);
                    shapelist.addLast(cube);
                    readShape(cube);
                    break;
                case 10:
                    System.out.println("Please Input Side Length: ");
                    sidelength1 = userinput.nextDouble();
                    Pyramid pyramid = new Pyramid(sidelength1);
                    pyramid.setName(nameinput);
                    shapelist.addLast(pyramid);
                    break;
                case 11:
                    System.out.println("Please Input Side Length: ");
                    sidelength1 = userinput.nextDouble();
                    Tetrahedron tetrahedron = new Tetrahedron(sidelength1);
                    tetrahedron.setName(nameinput);
                    shapelist.addLast(tetrahedron);
                    break;
                case 12:
                    System.out.println("Please Input Side Length: ");
                    sidelength1 = userinput.nextDouble();
                    Octahedron octahedron = new Octahedron(sidelength1);
                    octahedron.setName(nameinput);
                    shapelist.addLast(octahedron);
                    break;
                case 13:
                    System.out.println("Please Input Base Radius: ");
                    sidelength1 = userinput.nextDouble();
                    System.out.println("Please Input Height: ");
                    sidelength2 = userinput.nextDouble();
                    Cone cone = new Cone(sidelength1, sidelength2);
                    cone.setName(nameinput);
                    shapelist.addLast(cone);
                    break;
                case 14:
                    System.out.println("Please Input Base Radius: ");
                    sidelength1 = userinput.nextDouble();
                    Sphere sphere = new Sphere(sidelength1);
                    sphere.setName(nameinput);
                    shapelist.addLast(sphere);
                    break;
                case 15:
                    System.out.println("Please Input Base Radius: ");
                    sidelength1 = userinput.nextDouble();
                    System.out.println("Please Input Height: ");
                    sidelength2 = userinput.nextDouble();
                    Cylinder cylinder = new Cylinder(sidelength1, sidelength2);
                    cylinder.setName(nameinput);
                    shapelist.addLast(cylinder);
                    break;
                case 0:
                    state = 1;
                    break;
                default:
                    System.out.println("ERROR- Input is Invalid");
                    state = 1;
                    break;
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Error - Value is Invalid");
        }
        if(state == 0)
        {
            readShape(shapelist.getLast());
        }
    }
}
