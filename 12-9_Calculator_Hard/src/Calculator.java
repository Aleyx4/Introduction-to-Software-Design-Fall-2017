import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 *
 * <p>Calculator is a GUI program that does basic
 * calculator functions. Allowing the user to input
 * values through the press of the GUI buttons.</p>
 **/

public class Calculator {
    /**
     *String array of elements that will populate the buttons in grid order (Never To Be Changed)
     **/
    private final String buttonelements[] = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+","C"};
    /**
     * The window that will hold the contents of the Calculator application
     * which includes the JButtons in the grid and the TextField for the
     * display.
     */
    private JFrame frame = new JFrame("Calculator");
    /**
     * A TextField that will display what is inputted and its answer once the "=" is hit.
     */
    //Initialized with a size length of 10 units
    private final JTextField textField = new JTextField(10);
    /**
     * The panel that will hold the buttons for the user to interact with.
     */
    //Initialized a panel divided with a grid of Rows: 5 and Columns: 4
    private JPanel buttonpanel = new JPanel(new GridLayout(5,4));
    /**
     * The following is the default method that will be called to initialize
     * and setup the GUI display. This will format each of the panels to be
     * added in the correct BorderLayout location and set the Frame to be
     * visible.
     */
    public Calculator()
    {
        //If the user hits the close window "X" it will end the program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Setup the JPanel for the Buttons
        initButtonPanel();
        //Add the TextField to the top of the JFrame
        frame.add(textField, BorderLayout.NORTH);
        //Add the Button Panel to the bottom of the JFrame1
        frame.add(buttonpanel, BorderLayout.SOUTH);
        //Set the preferred size of the TextField
        textField.setPreferredSize(new Dimension(75,25));
        //Set the TextField not to be editable so the user may not modify or input values that are not allowed
        textField.setEditable(false);
        //Set the size to the frame to make all contents in the frame to be visible
        frame.pack();
        //Set the frame to be visible once everything has been setup
        frame.setVisible(true);
    }

    /**
     * This will initialize the JPanel with the buttons by creating a button with
     * a action listener for each element in the buttonelements array. It will
     * populate the grid from the JPanel from left to right and top to bottom.
     */
    private void initButtonPanel()
    {
        //Create a new ButtonHandler Object that will listen for buttons pressed
        ButtonHandler bh = new ButtonHandler();
        /*
        * For Loop
        *
        * This will go through the buttonelements array
        * and create a button for each element and link it
        * to an ActionListener. Then populate the buttonpanel
        * JPanel that has a  grid layout from left to right of
        * the grid.
        **/
        for(String element : buttonelements)
        {
            //Create a JButton Object with the a element in the array of buttonelements
            JButton button = new JButton(element);
            //Link the ButtonHandler to the button created
            button.addActionListener(bh);
            //Add the button to the panel that has the grid layout
            buttonpanel.add(button);
        }
    }

    /**
     * This ButtonHandler class will implement the ActionListener.
     * Each time the button linked to the ButtonHandler will call
     * ActionPreformed. This will update the GUI with the correct
     * responses for a Calculator.
     */
    private class ButtonHandler implements ActionListener
    {
        //Tells Compiler That This Method should be overriding the inherited method from the ActionListener Class
        @Override
        /**
         * This method is overridden from the ActionListener Class to
         * be used to process what will happen when the buttons from
         * the JPanel are pressed. This is also where we process the
         * textfield expression to be computed and set the answer of
         * the expression back into the textfield.
         */
        public void actionPerformed(ActionEvent e)
        {
            //Take the button that was pressed and get the text that is on the button and store it into a String called button input
            String buttoninput = ((JButton) e.getSource()).getText();
            //Set the textfield to what was in the textfield previously and add what was pressed
            textField.setText(textField.getText() + buttoninput);
            //Ii the button was "C" then clear the textfield
            if(buttoninput.equals("C"))
            {
                textField.setText("");
            }
            //If the button "=" is pressed then start calculating
            else if(buttoninput.equals("="))
            {
                //Initialize a pointer integer for pointing at a specific char of the String from the textfield
                int pointer = 0;
                //Initialize a String called expression with the contents of the textfield
                String expression = textField.getText();
                //Create an LinkedList Object that only contains Strings called operation
                LinkedList<String> operation = new LinkedList<String>();
                /*
                * For Loop
                *
                * This is to parse the String to populate the linkedlist to separate the numbers
                * from the operators. This will also consider negatives and double negatives if
                * it occurs in the expression the user inputs.
                */
                for(int i = 0; i<expression.length(); i++)
                {
                    /*
                    * If we find an operator in the expression then parse
                    * the float on the left side of the operator and add
                    * it to the linkedlist. Then place the operator into
                    * the linked list. Also increment the pointer to where
                    * the next starting point will be.
                    */
                    if((expression.charAt(i)=='+')||((expression.charAt(i)=='-')&&(i!=pointer)&&(!(expression.charAt(i+1)=='-')))||(expression.charAt(i)=='*')||(expression.charAt(i)=='/'))
                    {
                        operation.addLast(expression.substring(pointer,i));
                        operation.addLast(expression.substring(i,i+1));
                        pointer = i+1;
                    }
                    /*
                    * If the expression has a negative sign and is not a double negative then
                    * add the negative to the linkedlist. Then increment
                    * the pointer.
                    */
                    else if((expression.charAt(i)=='-')&&(i==pointer)&&(!(expression.charAt(i+1)=='-')))
                    {
                        operation.add(0,"-");
                        pointer = i+1;
                    }
                    /*
                    * If the expression contained a double negative then but is not at the
                    * beginning of the starting point indicated by the pointer. Then it
                    * becomes addition so add the float into the linkedlist and an addtion
                    * operator into the linkedlist as well. Increment the pointer afterwards.
                    */
                    else if((expression.charAt(i)=='-')&&(expression.charAt(i+1)=='-')&&(pointer != i))
                    {
                        operation.addLast(expression.substring(pointer,i));
                        operation.addLast("+");
                        i=i+1;
                        pointer = i+1;
                    }
                    /*
                    * If we reach to the end of the expression then place the last
                    * float into the linkedlist.
                    */
                    else if(expression.charAt(i)=='=')
                    {
                        operation.addLast(expression.substring(pointer,(expression.length()-1)));
                    }
                }
                /*
                * For Loops
                *
                * This for loop will go though the processed string that is stored into
                * a linkedlist. It will take each of the elements and compute the values
                * then remove the old elements and add the newly computed element back
                * to the linkedlist until one element is left in the linkedlist.
                * We will display the last element to the textfield for the next computation.
                */

                //Deal with the negatives first
                try {
                    for (int i = 0; i < operation.size(); i++) {
                        //If we get a double negative then remove the double negatives and start over to the beginning of the linkedlist
                        if ((operation.get(i).equals("-")) && (operation.get(i + 1).equals("-"))) {
                            operation.remove(i);
                            operation.remove(i);
                            i = 0;
                        }
                        //If we get a negative and a float at the beginning of the linkedlist then combine the negative with the float and remove the two elements and put the new element in
                        else if ((operation.get(i).equals("-")) && (i == 0) && (!(operation.get(i + 1).equals("-")))) {
                            operation.add(i, "-" + operation.get(i + 1));
                            operation.remove(i + 1);
                            operation.remove(i + 1);
                            i = 0;
                        }
                    }
                    //Following order of operations check for a multiplication or division
                    for (int i = 0; i < operation.size(); i++) {
                        if ((operation.get(i).equals("*")) || (operation.get(i).equals("/"))) {
                            float num1 = Float.parseFloat(operation.get(i - 1));
                            float num2 = Float.parseFloat(operation.get(i + 1));
                            if (operation.get(i).equals("*")) {
                                operation.add(i - 1, Float.toString(num1 * num2));
                                operation.remove(i);
                                operation.remove(i);
                                operation.remove(i);
                            } else if (operation.get(i).equals("/")) {
                                operation.add(i - 1, Float.toString(num1 / num2));
                                operation.remove(i);
                                operation.remove(i);
                                operation.remove(i);
                            }
                            i = 0;
                        }
                    }
                    //Deal will the addition and subtraction operations last
                    for (int i = 0; i < operation.size(); i++) {
                        if ((operation.get(i).equals("+")) || (operation.get(i).equals("-"))) {
                            float num1 = Float.parseFloat(operation.get(i - 1));
                            float num2 = Float.parseFloat(operation.get(i + 1));
                            if (operation.get(i).equals("+")) {
                                operation.add(i - 1, Float.toString(num1 + num2));
                                operation.remove(i);
                                operation.remove(i);
                                operation.remove(i);
                            } else if (operation.get(i).equals("-")) {
                                operation.add(i - 1, Float.toString(num1 - num2));
                                operation.remove(i);
                                operation.remove(i);
                                operation.remove(i);
                            }
                            i = 0;
                        }
                    }
                    //Set the final linkedlist element to be displayed on the textfield
                    textField.setText(operation.getFirst());
                }
                //Catch any expression that is not correctly formatted ex. **, //, *+, and etc.
                catch(NumberFormatException f)
                {
                    textField.setText("ERROR");
                }
            }
        }
    }
}
