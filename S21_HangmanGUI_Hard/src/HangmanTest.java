import javax.swing.*;

/**
 * This is the tester class of the Hangman program.
 * It will start by prompting the user to input a word.
 * Through the GUI PasswordField to make sure the player
 * is unable to see the word being inputted in the screen.
 * As long as the user inputs in only letters for a single
 * word the word will be passed to the Hangman program
 * otherwise a dialog box will prompt the user the input
 * was invalid. If the user cancels or closes the frame with
 * the PasswordField the program will end.
 */
public class HangmanTest {
    public static void main(String args[])
    {
        //The String for the word that will be guessed by the user
        String word = null;
        //Boolean variable to loop if the user does not input a valid String for the Hangman Game
        boolean loop = true;
        //While Loop for Error Checking
        while(loop) {
            //PasswordField to make sure the user is not able to see the word is the object created with a size length of 10 units for its text box
            JPasswordField wordchoice = new JPasswordField(10);
            //Retrieve the buttons pressed on the Dialog box which includes Okay, Cancel, and Exit (X)
            int actions = JOptionPane.showConfirmDialog(null, wordchoice, "Enter Word to be Guessed", JOptionPane.OK_CANCEL_OPTION);
            //If the user presses cancel or the exit key then end the program
            if ((actions < 0) || (actions == 2)) {
                System.exit(0);
            }
            //If the user does not enter anything in the text box the give an error
            else if (wordchoice.getPassword().length <= 0) {
                JOptionPane.showMessageDialog(null, "Invalid Input - Please Try Again");
            }
            //If there is content in the text box check its contents
            else {
                //Store the String that was entered into the text box in the String called word
                word = new String(wordchoice.getPassword());
                //Force all the letters in the String word to be uppercase
                word = word.toUpperCase();
                //For all the the letters in the String word check if they are only letters
                for(int i = 0; i<word.length(); i++)
                {
                    //If at any point a character in the String is not a letter output a dialog error message and ask to reinput a String
                    if((word.charAt(i) < 'A')||(word.charAt(i) > 'Z'))
                    {
                        i = word.length();
                        JOptionPane.showMessageDialog(null, "Invalid Input - This Word Can Only Contain Letters");
                        loop = true;
                    }
                    //If the string is valid then the loop may end
                    else
                    {
                        loop = false;
                    }
                }
            }
        }
        //Create a Hangman Object
        Hangman hangman = new Hangman();
        //Put the word into the Hangman object to be initialized to begin the Hangman Game and start up the GUI Frame
        hangman.initalsetup(word);

    }

}
