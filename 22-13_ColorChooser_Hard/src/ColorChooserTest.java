/**
 * @author Alex Wong
 * @version 1.0
 * This is the tester class for ColorChooser program. This will
 * initialize the window and set the beginning color to be black.
 */
public class ColorChooserTest {
    public static void main(String args[])
    {
        ColorChooser cc = new ColorChooser();
        cc.initWindow();
        cc.setRedValue(255);
        cc.setGreenValue(255);
        cc.setBlueValue(255);
    }
}
