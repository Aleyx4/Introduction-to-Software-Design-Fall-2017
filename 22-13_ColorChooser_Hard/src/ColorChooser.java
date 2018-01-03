import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * This is a program that will allow the user to preview a RGB color code utilizing
 * three separate sliders to change the color composition of Red, Green, and Blue.
 * At the bottom of the sliders will show the color preview of the current value
 * settings on the slider. The sliders will adjust values or they can be manually typed
 * into and it will automatically update to the newest color.
 */
public class ColorChooser {
    /**
     * This is the main window that will hold the sliders and color previewer.
     */
    private JFrame frame = new JFrame("Color Chooser");
    /**
     * This is a panel to format the placement of the sliders in a vertical position.
     */
    private JPanel rgb = new JPanel(new GridLayout(3,1));
    /**
     * The Red Color Value Slider, Value Text Box and Label Holder
     */
    private JPanel r = new JPanel(new FlowLayout());
    /**
     * The Green Color Value Slider, Value Text Box and Label Holder
     */
    private JPanel g = new JPanel(new FlowLayout());
    /**
     * The Blue Color Value Slider, Value Text Box and Label Holder
     */
    private JPanel b = new JPanel(new FlowLayout());
    /**
     * The Red Value Slider
     */
    private JSlider redSlide = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
    /**
     * The Green Value Slider
     */
    private JSlider greenSlide = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
    /**
     * The Blue Value Slider
     */
    private JSlider blueSlide = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
    /**
     * The Text Field for the Red Color Value
     */
    private JTextField redText = new JTextField(3);
    /**
     * The Text Field for the Green Color Value
     */
    private JTextField greenText = new JTextField(3);
    /**
     * The Text Field for the Blue Color Value
     */
    private JTextField blueText = new JTextField(3);
    /**
     * Self created object that extends JPanel that will be used for painting the preview color.
     */
    private FillColor fc = new FillColor();

    /**
     * This will set the red value that is given updating the slider, its text, and the color viewer.
     * @param redvalue The integer value for the red value that is between 0 - 255
     */
    public void setRedValue(int redvalue)
    {
        redText.setText(Integer.toString(redvalue));
        redSlide.setValue(redvalue);
        fc.repaint();
    }

    /**
     * This will set the green value that is given updating the slider, its text, and the color viewer.
     * @param greenvalue The integer value for the green value that is between 0 - 255
     */
    public void setGreenValue(int greenvalue)
    {
        greenText.setText(Integer.toString(greenvalue));
        greenSlide.setValue(greenvalue);
        fc.repaint();
    }

    /**
     * This will set the blue value that is given updating the slider, its text, and the color viewer.
     * @param bluevalue The integer value for the blue value tat is between 0 - 255
     */
    public void setBlueValue(int bluevalue)
    {
        blueText.setText(Integer.toString(bluevalue));
        blueSlide.setValue(bluevalue);
        fc.repaint();
    }

    /**
     * Retrieve the red value from the current slider position.
     * @return The integer value for the color red in the slider
     */
    public int getRedValue()
    {
        return redSlide.getValue();
    }

    /**
     * Retrieve the green value from the current slider position.
     * @return The integer value for the color green in the slider
     */
    public int getGreenValue()
    {
        return greenSlide.getValue();
    }

    /**
     * Retrieve the blue value from the current slider position.
     * @return The integer value for the color blue in the slider
     */
    public int getBlueValue()
    {
        return blueSlide.getValue();
    }

    /**
     * Initializer method to setup the window and placements for all the objects
     * like the sliders, text fields, labels, and color viewer. This will also
     * setup the handlers for the sliders movements and the text field changes.
     */
    public void initWindow()
    {
        //Handlers for the Sliders and Text Box
        SlideHandler sh = new SlideHandler();
        TextHandler th = new TextHandler();

        //Exit Case for Closing A Window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Red Row that includes the label, slider, and text field.
        JLabel redlabel = new JLabel("Red");
        redlabel.setHorizontalAlignment(SwingConstants.RIGHT);
        redlabel.setPreferredSize(new Dimension(50,10));
        r.add(redlabel);

        redSlide.setName("r");
        redSlide.addChangeListener(sh);
        r.add(redSlide);

        redText.setName("r");
        redText.addKeyListener(th);
        redText.setText("0");
        r.add(redText);

        rgb.add(r);

        //Green Row that includes the label, slider, and text field.
        JLabel greenlabel = new JLabel("Green");
        greenlabel.setHorizontalAlignment(SwingConstants.RIGHT);
        greenlabel.setPreferredSize(new Dimension(50,10));
        g.add(greenlabel);

        greenSlide.setName("g");
        greenSlide.addChangeListener(sh);
        g.add(greenSlide);

        greenText.setName("g");
        greenText.addKeyListener(th);
        greenText.setText("0");
        g.add(greenText);

        rgb.add(g);

        //Blue Row that includes the label, slider, and text field.
        JLabel bluelabel = new JLabel("Blue");
        bluelabel.setHorizontalAlignment(SwingConstants.RIGHT);
        bluelabel.setPreferredSize(new Dimension(50,10));
        b.add(bluelabel);

        blueSlide.setName("b");
        blueSlide.addChangeListener(sh);
        b.add(blueSlide);

        blueText.setName("b");
        blueText.addKeyListener(th);
        blueText.setText("0");
        b.add(blueText);

        rgb.add(b);

        //Set All Rows Into Center Panel
        frame.add(rgb, BorderLayout.CENTER);

        //Set Color Previewer Into Bottom Panel
        frame.add(fc, BorderLayout.SOUTH);
        fc.setPreferredSize(new Dimension(150,150));

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Text Field Handler that will update the value in the text field
     * and to its corresponding slider and then update the color previewer.
     * If any thing inputted is not a number do nothing.
     */
    private class TextHandler implements KeyListener
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                try {
                    JTextField source = (JTextField) e.getSource();
                    if (source.getName().equals("r")) {
                        redSlide.setValue(Integer.parseInt(source.getText()));
                    } else if (source.getName().equals("g")) {
                        greenSlide.setValue(Integer.parseInt(source.getText()));
                    } else {
                        blueSlide.setValue(Integer.parseInt(source.getText()));
                    }
                }
                catch(NumberFormatException f)
                {

                }
            }
        }
        public void keyReleased(KeyEvent e)
        {

        }
        public void keyTyped(KeyEvent e)
        {

        }
    }

    /**
     * Slider Handler that will check if the slider changes or is modified. This
     * will get the updated value and change the text fields that correspond to
     * its change and update the color viewer.
     */
    private class SlideHandler implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider) e.getSource();
            if (source.getName().equals("r")) {
                redText.setText(Integer.toString(source.getValue()));
            } else if (source.getName().equals("g")) {
                greenText.setText(Integer.toString(source.getValue()));
            } else {
                blueText.setText(Integer.toString(source.getValue()));
            }
            fc.repaint();
        }
    }

    /**
     * FillColor is a class that extends JPanel. It will be used to color its entire window size
     * to the color value composition of the red, green, and blue that is from the sliders / text.
     */
    private class FillColor extends JPanel{
        @Override

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Color selectedColor = new Color(Integer.parseInt(redText.getText()), Integer.parseInt(greenText.getText()), Integer.parseInt(blueText.getText()));
            g.setColor(selectedColor);
            g.fillRect(0,0, getWidth(), getHeight());
        }
    }
}
