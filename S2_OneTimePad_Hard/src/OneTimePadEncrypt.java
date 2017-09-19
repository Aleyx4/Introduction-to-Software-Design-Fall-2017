import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;
import java.io.*;
/**
 * @author Alex Wong won4a@gmail.com
 * @version 1.0
 *
 * <p>OneTimePadEncrypt is the second part of the program that
 * is to take the key file and the message that the user wants
 * to be encrypted. The program will prompt the user for the
 * directory of the file location. It will ask for the
 * directory of where the new file should be created and its
 * name. The new file will have the .em extension that contains
 * The encrypted message. After it will prompt for a user input
 * of the message that should be sent. The message will then be
 * converted using the key file. Once completed the file
 * will be outputted in the file directory the user specified.
 * A system prompt will output the location of the new file
 * for confirmation it was completed.</p>**/
public class OneTimePadEncrypt {
    /**
     * This method will take each character and the value it needs
     * to shift the character to the right of the alphabet. This
     * will then then output the new character that has been encrypted.
     *
     * @param shift the number of times the character needs to be shifted to the right of the alphabet
     * @param c the character that needs to be encrypted
     * @return the encrypted character
     **/
    private static char encrypt(int shift, char c)
    {
        /*
        * For Loop
        *
        * This loop will go through the number of times the character
        * needs to be shifted
        */
        for(int i = 0; i<shift; i++)
        {
            //If character reaches to the end of the uppercase alphabet go back to 'A'
            if(c == 'Z')
            {
                c = 'A';
            }
            //If character is a space then output back a space by doing nothing
            else if(c == ' ')
            {

            }
            //Otherwise increment to the next character in the alphabet
            else
            {
                c+=1;
            }
        }
        //Return the new encrypted character
        return c;
    }

    public static void main(String[] args)
    {
        //Creating a Scanner object to obtain the input from the user
        Scanner input  = new Scanner(System.in);
        //Creating a Stack object to use for reading the key file of Integers
        Stack stack = new Stack();
        //Initializing a counter to count the number of numbers in the key file that is being read out
        int count = 0;
        //Initializing Strings for the user input of a message to be encrypted and the directory location for the key file
        String message = null, keydir = null;
        //Initializing boolean variables for loops to allow the user to correct input errors
        boolean error = true, error2 = true, error3 = true;
        //Initializing an Integer array to be used to store values read in the key file
        int[] keyvalues = null;
        while(error) {
            //Prompt the user to input the directory of where the key file on the local drive
            System.out.println("Please Input the Directory with the .ky File (ex. C:\\folder\\subfolder\\filename.ky ): ");
            /*
            * Try-Catch Block
            *
            * Used to catch any input errors or directory errors in
            * trying to open or find the key file.
            */
            try {
                //Storing user input of the key file directory in "keydir"
                keydir = input.nextLine();
                //Creating a File object with the full key file directory location
                File file = new File(keydir);
                //Creating a new Scanner object with the File object to open and read the contents in the file
                Scanner read = new Scanner(file);
                //Reading the keu file of all Integers till there are none left and storing them by pushing them into a stack
                while (read.hasNextInt()) {
                    stack.push(new Integer(read.nextInt()));
                    count++;
                }
                //No error occurred while reading the file, End while loop.
                error = false;
            } catch (FileNotFoundException e) {
                System.out.println("ERROR - Key File Could Not Be Opened");
            } catch (InputMismatchException e) {
                System.out.println("Error - Key File Is Invalid");
            }
            //Initialize the array with a storage of the number of values that have been pushed into the stack
            keyvalues = new int[count];
            /*
            * For Loop
            *
            * Pop all of the values off the stack and store
            * them into the array "keyvalues".
            */
            for (int i = 0; i < count; i++) {
                keyvalues[(count - 1) - i] = (int) stack.pop();
            }
        }
        while(error2) {
            /*
            * Try-Catch Block
            *
            * Used to catch any input that is not valid. The input
            * is the message and it can only be letters and spaces.
            * Any message with anything else will be rejected and
            * will prompt the user to try entering a message again.
            */
            try {
                //Prompt the user to input a message with only letters and spaces
                System.out.println("Please Input Your Message (Note: Message Can ONLY Contain Spaces and Letters of the English Alphabet): ");
                //Store the message as a string called "message" that the user inputted
                message = input.nextLine();
                //Make all of the characters in the string uppercase
                message = message.toUpperCase();
                /*
                * For Loop
                *
                * Go through each of the characters in the string to see if it only
                * contains letters and spaces otherwise throw a "InputMismatchException".
                */
                for (int i = 0; i < message.length(); i++) {
                    //Take the character at location "i" of the string
                    char c = message.charAt(i);
                    //If character is not a letter or a space throw a "InputMismatchException"
                    if (((c < 65) && (c != 32)) || (c > 90)) {
                        System.out.println(c);
                        throw new InputMismatchException();
                    }
                }
                //End While Loop if Message is Valid
                error2 = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("ERROR - Message Has Invalid Characters");
            }
        }
        while(error3) {
            //Prompt the user to input the directory for the new output file of the encrypted message
            System.out.println("Please Input A Directory for the Output File (ex. C:\\folder\\subfolder ): ");
            /*
            * Try-Catch Block
            *
            * This is used to catch the user input if the file
            * directory the user inputs is invalid or if the
            * new file cannot be created. For storing the encrypted
            * message.
            */
            try {
                //Created a new string called "dir" for the directory of where the new file should be created
                String dir = input.nextLine();
                //Prompt the user to input a file name that should be created in the directory
                System.out.println("Please Input File Name to Be Created (ex. message): ");
                //Store the file name in a String called "filename"
                String filename = input.nextLine();
                //Create a new File Object with the file directory and name with the extension .em
                File fileloc = new File(dir + "\\" + filename + ".em");
                //Create a new FileObjectStream object
                FileOutputStream fileout = new FileOutputStream(fileloc);
                //Create a new OutputStreamWriter object
                OutputStreamWriter outputwriter = new OutputStreamWriter(fileout);
                //Create a new BufferWriter object
                BufferedWriter bw = new BufferedWriter(outputwriter);
                //Store the starting point value in "pointer" which is the first value in the "keyvalues" array
                int pointer = keyvalues[0];
                //In the new file write the starting point value for future reference
                bw.write(String.valueOf(pointer));
                //Move the cursor to the next line for writing in the new file
                bw.newLine();
                /*
                * For Loop
                *
                * Going through each character in the String called "message" and corresponding
                * to the shifted value starting at the pointer of the array for "keyvalues" we
                * call the method encrypt() with the shift value and the character that needs
                * to be shifted. Each character will increment the pointer to the next shfit
                * value on the right of the array (skipping slot 0 since it was the pointer to
                * the starting point of the shift value). If reach to the end of the shift values
                * start back at the beginning and continue on.
                * */
                for (int i = 0; i < message.length(); i++) {
                    bw.write(encrypt(keyvalues[pointer], message.charAt(i)));
                    if (pointer == ((keyvalues.length) - 1)) {
                        pointer = 1;
                    } else if (message.charAt(i) == ' ') {
                    } else {
                        pointer++;
                    }
                }
                //Flush out any left overs to be written to the new file
                bw.flush();
                //Close and save the new file content
                bw.close();
                //Going back and reopening the key file to be overwritten and updated
                fileloc = new File(keydir);
                fileout = new FileOutputStream(fileloc);
                outputwriter = new OutputStreamWriter(fileout);
                bw = new BufferedWriter(outputwriter);
                //Write the new starting point of the key file where the pointer was left off
                bw.write(String.valueOf(pointer++));
                //Write the original second line of the key file with no changes using the "keyvalues" array
                bw.newLine();
                for (int i = 1; i < (keyvalues.length); i++) {
                    if (i == ((keyvalues.length) - 1)) {
                        bw.write(String.valueOf(keyvalues[i]));
                    } else {
                        bw.write(String.valueOf(keyvalues[i]) + " ");
                    }
                }
                //Flush any left over content that needed to be written
                bw.flush();
                //Close and overwrite the old key file with the updated value
                bw.close();
                //Print out the location and name of the new encrypted message file that was created
                System.out.println();
                System.out.println("The Following Encrypted Message File: " + filename + ".em");
                System.out.println("Is Located In: " + dir);
                //End While Loop confirming the encrypted file was created
                error3 = false;
            } catch (IOException e) {
                System.out.println("ERROR - Encrypted File Could Not Be Created");
            }
        }
    }
}
