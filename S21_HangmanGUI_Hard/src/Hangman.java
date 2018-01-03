import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 *
 * <p>Hangman is a GUI program that allows the user to input a word
 * to be guessed. The user will then be able to see the GUI with the
 * buttons to guess a letter.
 *
 * A graphic to show an animation of hangman. The guessed
 * letters and the number of guesses left before the game is over.
 * At the very top is the word that will have blanks to show the
 * letters missing and it will be updated for each guess populating
 * the word slowly as the game progresses. At the end of the game
 * message boxes will show when the game is lost or won. If lost the
 * word will also be displayed to show the correct answer.</p>
 */
public class Hangman {
    /**
     * This is the word that needs to be guessed.
     */
    private String word;
    /**
     * This is the String of letters that are used. This will update
     * for each guess populating it with letters. These are non-separated.
     *
     * Ex.  ARCLEFG...
     */
    private String usedletters = " ";
    /**
     * This is the number of guesses left. As it progresses this will increment down to zero.
     */
    private int guessesleft = 6;
    /**
     * This is the number of unique letters that have been guessed.
     */
    private int guessedletters = 0;
    /**
     * This is an array of JLabels of each character in the
     * word to be guessed. This is because we want to have
     * spaces between each character.
     */
    private JLabel[] displayword;
    /**
     * This is an array of JLabels of each character that is
     * guessed.
     */
    private JLabel[] displayusedletters;
    /**
     * This is the JLabel for the number of guesses left.
     */
    private JLabel displayguessesleft;
    /**
     * This is the JPanel for where the word to be guessed.
     * This panel will be placed at the very top of the
     * frame.
     */
    private JPanel wordpanel;
    /**
     * This is the JPanel for where the buttons
     * will be placed in a grid layout format.
     * The buttons will be at the bottom of the
     * frame.
     */
    private JPanel buttonpanel;
    /**
     * This is the JPanel for where the letters
     * guessed will be placed. This will be placed
     * on the center left of the frame.
     */
    private JPanel guessedletterspanel;
    /**
     * This is the JPanel for where the number
     * of guesses left will be placed. This will
     * be placed on the center right of the frame.
     */
    private JPanel guessesleftpanel;
    /**
     * This is the graphic panel of the Hangman drawing
     * using paint component.
     */
    private DrawHangman h1 = new DrawHangman();
    /**
     * Creating a empty border for the border
     */
    private Border empty = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    /**
     * Creating a black line border
     */
    private Border blackline = BorderFactory.createLineBorder(Color.black);
    /**
     * Creating a border out of a empty border and the black line border
     */
    private CompoundBorder line = new CompoundBorder(empty, blackline);
    /**
     * Creating a JFrame for the window of the Hangman GUI
     */
    private JFrame frame = new JFrame("Hangman");

    /**
     * This is to get the word that needs to be guessed.
     * @return string of the word that needs to be guessed.
     */
    public String getWord()
    {
        return word;
    }
    /**
     * This is to get the letters that have been used
     * by the user.
     * @return string of the letters used
     */
    public String getUsedletters()
    {
        return usedletters;
    }
    /**
     * This will get the number of guesses left the game
     * has left before it ends.
     * @return integer of the number of guesses that are left in the game
     */
    public int getGuessesleft()
    {
        return guessesleft;
    }
    /**
     * This is will get the number of unique letters that
     * are guessed.
     * @return an integer of the number of unique letters that have been guessed in the game
     */
    public int getGuessedletters()
    {
        return guessedletters;
    }
    /**
     * This will initialize the GUI. This includes the buttons panel,
     * letters used panel, guesses left panel, word, and graphic.
     * This will also process the word that should be guessed. This
     * will set the panels to be aligned correctly and set also the size
     * of the window.
     * @param word the word that the user will need to guess in the game
     */
    public void initalsetup(String word)
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.word = word.toUpperCase();
        initButtonPanel();
        initLettersPanel();
        initWordPanel();
        initGuessesLeftPanel();

        frame.add(guessesleftpanel, BorderLayout.EAST);
        frame.add(guessedletterspanel, BorderLayout.WEST);
        frame.add(wordpanel, BorderLayout.NORTH);
        wordpanel.setAlignmentX(frame.getWidth()/2);
        frame.add(buttonpanel, BorderLayout.SOUTH);
        frame.add(h1, BorderLayout.CENTER);
        h1.setPreferredSize(new Dimension(150,150));
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * This will initialize the button panel creating
     * a grid layout to place buttons for each letter
     * of the alphabet. Also linking the actionlistener
     * to each button with the buttonhandler. Then
     * populating the buttons from left to right in the
     * grid layout.
     */
    private void initButtonPanel()
    {
        buttonpanel = new JPanel(new GridLayout(6, 5));
        ButtonHandler bh = new ButtonHandler();
        for(char i = 'A'; i <= 'Z'; i++)
        {
            JButton button = new JButton(i+"");
            button.addActionListener(bh);
            buttonpanel.add(button);
        }
    }

    /**
     * This will initialize the panel for the display of the
     * letters that are to be displayed that have been guessed
     * by the user. This will utilize a grid layout to populate
     * up to 26 letters. We fill the grid with blank spaces at
     * the beginning to make sure the size of the window is to
     * the size it needs to be without needing to resize the
     * window again later on. This will also create a a border
     * around the panel to make it easier for the user to
     * understand what these letters being displayed means.
     */
    private void initLettersPanel()
    {
        guessedletterspanel = new JPanel(new GridLayout(7,4));
        guessedletterspanel.setPreferredSize(new Dimension(120,150));
        displayusedletters = new JLabel[26];
        for(int i = 0; i<26; i++)
        {
            JLabel displaychar = new JLabel("  ");
            displayusedletters[i] = displaychar;
            guessedletterspanel.add(displaychar);
            Border lettersborder = BorderFactory.createTitledBorder(line, "Used Letters");
            guessedletterspanel.setBorder(lettersborder);
        }
    }

    /**
     * This will initialize the panel to be used to see
     * the word being guessed. It will start out by
     * populating the word length with underscores to allow
     * the user to know the number of characters that will
     * are in the word. Also these underscores will be replaced
     * with the correct letter once the user guesses the
     * corresponding letter.
     */
    private void initWordPanel()
    {
        wordpanel = new JPanel();
        displayword = new JLabel[word.length()];
        for(int i = 0; i<word.length(); i++)
        {
            JLabel displaychar = new JLabel("_");
            displayword[i] = displaychar;
            wordpanel.add(displaychar);
        }
    }

    /**
     * This will initialize the panel for the number of guesses
     * left. We will take the integer variable guessesleft and
     * pass it as a string to JLabel to be displayed onto the
     * JPanel.
     */
    private void initGuessesLeftPanel()
    {
        guessesleftpanel = new JPanel();
        guessesleftpanel.setPreferredSize(new Dimension(120,150));
        displayguessesleft = new JLabel(guessesleft + "");
        displayguessesleft.setPreferredSize(new Dimension(120,40));
        displayguessesleft.setHorizontalTextPosition(SwingConstants.CENTER);
        guessesleftpanel.add(displayguessesleft);
        Border lettersborder = BorderFactory.createTitledBorder(line, "Guesses Left");
        displayguessesleft.setBorder(lettersborder);
    }

    /**
     * This ButtonHandler class will implement the ActionListener.
     * Each time the button linked to the BUttonHAndler will call
     * ActionPreformed. This will update the GUI with the correct
     * responses for the Hangman game. In this case it will take
     * the button letter pressed and search for the letter in the
     * word to be guessed. If it is found in the word then it will
     * update the displayword panel with the JLabel to hold the newly
     * filled in letters. Then it will also start populating the
     * grid of letters used and increment the number of letters used.
     * If the letter the user inputs is not in the word then decrement
     * the guesses left and call the paintcomponet to be repainted with
     * the correct display linked to the number of guesses left.
     */
    private class ButtonHandler implements ActionListener
    {
        //Tells the Compiler that this Method should be overriding the inherited method from the ActionListener Class
        @Override
        /**
         * This method is overridden from the ActionListener Class to
         * be used to process the users input of the letter guessed
         * in the Hangman game. This will update the GUI with the
         * button pressed. This will take the letter and check if
         * the user has used this letter before or if the letter is
         * in the word. This will determine the actions from changing
         * the display of the letters used panel, the word displayed,
         * the guesses left, and the stickman drawing.
         */
        public void actionPerformed(ActionEvent e) {
            /*
            * Get the button that is pressed and read its character that the button has
            * and then store it in as a String called buttonletter.
            */
            String buttonletter = ((JButton) e.getSource()).getText().toUpperCase();
            /*
            * Looks for an occurance of the buttonletter on the String of used letters.
            * This means that the user already guessed this letter before.
            * If the letter is in the String then decrement the number of guesses left
            * and update its display.
            */
            if((usedletters.indexOf(buttonletter.charAt(0))) > 0)
            {
                guessesleft--;
                displayguessesleft.setText(guessesleft + "");
            }
            /*
            * If the letter is within the the word to be guessed
            * then we need to check for where the letter occurs
            * int he word and populate the display of the word
            * to replace the underscores with the letter guessed.
            * After update the display of the letters used and
            * also the counter for the number of letters guessed.
            */
            else if(word.contains(buttonletter))
            {
                //For Loop to check all character of the word string for the guessed letter
                for(int i = 0; i<word.length(); i++)
                {
                    //Where the letter occurs on the String update the display element of that position with the guessed letter
                    if(buttonletter.charAt(0) == word.charAt(i))
                    {
                        displayword[i].setText(buttonletter);
                    }
                }
                //Update the used letters display to have the letter guessed
                displayusedletters[guessedletters].setText(buttonletter);
                usedletters = usedletters + buttonletter;
                //Increment guessed letters counter
                guessedletters++;
            }
            /*
            * If we get to this point of the if statement then the letter is not in the word and the letter was not guessed before.
            * We need to therefore update this display with the guessed letter and update the counter of the guesses left and the
            * number of guessed letters that have been guessed gets incremented as well.
            */
            else
            {
                displayusedletters[guessedletters].setText(buttonletter);
                usedletters = usedletters + buttonletter;
                guessedletters++;
                guessesleft--;
                displayguessesleft.setText(guessesleft + "");
            }
            //Repaint the graphic according to the number of guesses left
            h1.repaint();
            //Make sure the frame fits the contents it contains
            frame.pack();
            String compareuserword = "";
            //For loop to take the JPanel of JLabels and combine the strings all together to the full word
            for(int i = 0; i<word.length(); i++)
            {
                compareuserword = compareuserword + displayword[i].getText();
            }
            //If the display word is the same as the word to be guessed then the user won the game
            if(compareuserword.equals(word))
            {
                //Display dialog box of the won game and close and end the program
                JOptionPane.showMessageDialog(null,"YOU WIN!");
                System.exit(0);
            }
            //If the guesses left hits zero then the game is over
            else if(guessesleft == 0)
            {
                //Display dialog box of the game over and close and end the program
                JOptionPane.showMessageDialog(null,"GAME OVER!\n The Word Was: " + word);
                System.exit(0);
            }
        }
    }

    /**
     * This DrawHangman class extends JPanel which will
     * be used to inherit the paintComponent which will be
     * overridden to draw the Hangman graphic.
     */
    private class DrawHangman extends JPanel
    {
        //Tells compiler that this method should be overriding the inherited method from the JPanel Class
        @Override
        /*
        * This method overrides the painComponent method that is
        * inherited from the extended class called JPanel. This
        * allows the ability to draw the Stickman figure.
        */
        public void paintComponent(Graphics g)
        {
            //Calling the original paintComponent method
            super.paintComponent(g);
            /*
            * Creating the base structure of Hangman.
            */
            g.fillRect(0,140, 150,5);
            g.fillRect(140,10, 5,130);
            g.fillRect(100,10, 40,5);
            g.fillRect(100,10,5,20);
            /*
            * Switch-Case
            *
            * This will look at the variable called guesses left
            * and for each guess missing a body part is drawn.
            */
            switch (guessesleft) {
                case 0:
                    h1.addHead(g);
                    h1.addBody(g);
                    h1.addLeftLeg(g);
                    h1.addRightLeg(g);
                    h1.addLeftArm(g);
                    h1.addRightArm(g);
                    break;
                case 1:
                    h1.addHead(g);
                    h1.addBody(g);
                    h1.addLeftLeg(g);
                    h1.addRightLeg(g);
                    h1.addLeftArm(g);
                    break;
                case 2:
                    h1.addHead(g);
                    h1.addBody(g);
                    h1.addLeftLeg(g);
                    h1.addRightLeg(g);
                    break;
                case 3:
                    h1.addHead(g);
                    h1.addBody(g);
                    h1.addLeftLeg(g);
                    break;
                case 4:
                    h1.addHead(g);
                    h1.addBody(g);
                    break;
                case 5:
                    h1.addHead(g);
                    break;
            }
        }

        /**
         * This will draw the head of the Stick Figure using a filled Circle
         * @param g The Grapahic object that is used to draw the Hangman graphic
         */
        private void addHead(Graphics g)
        {
            g.fillOval(92,25,20,20);
        }

        /**
         * This will draw the body of the Stick Figure using a line
         * @param g The Grapahic object that is used to draw the Hangman graphic
         */
        private void addBody(Graphics g)
        {
            g.drawLine(102,30,102,70);
        }

        /**
         * This will draw the left arm of the Stick Figure using a line
         * @param g The Grapahic object that is used to draw the Hangman graphic
         */
        private void addLeftArm(Graphics g)
        {
            g.drawLine(102,60,90,50);
        }

        /**
         * This will draw the left leg of the Stick Figure using a line
         * @param g The Grapahic object that is used to draw the Hangman graphic
         */
        private void addLeftLeg(Graphics g)
        {
            g.drawLine(102,70,90,100);
        }

        /**
         * This will draw the right arm of the Stick Figure using a line
         * @param g The Grapahic object that is used to draw the Hangman graphic
         */
        private void addRightArm(Graphics g)
        {
            g.drawLine(102,60,112,50);
        }

        /**
         * This will draw the right leg of the Stick Figure using a line
         * @param g The Grapahic object that is used to draw the Hangman graphic
         */
        private void addRightLeg(Graphics g)
        {
            g.drawLine(102,70,114,100);
        }
    }
}