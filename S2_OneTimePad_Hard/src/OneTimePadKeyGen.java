import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 *
 * <p>OneTimePadKeyGen is part one of the program that creates a
 * key file with the extension ky. The program will prompt to input
 * a directory location on the local computer that the user would
 * like the key file to be stored. The full directory must be entered.
 * After it will prompt to input a name for the newly created file the
 * extension will automatically be placed in. Ex. filename.ky
 * The file will be created and then will ask the user for the number
 * of values the key should have and then the constraint on the max value
 * that can be generated in the key file. Once all fields have been
 * entered it will generate the key file with the parameters the user
 * inputted. The program will print out the directory of where the file
 * was placed and its file name confirming it was created. Any file
 * originally placed in the specified directory with the same extension
 * will automatically be erased once inputted in.</p>
 **/
public class OneTimePadKeyGen {
    /**
    * This method is the brains of the program that will
    * generate the values for the key file with the specified
    * parameters the user entered.
    *
    * @param numset the number of numbers that should be listed in the key file
    * @param range the max the number can be in the key file
    * @return the values generated in a String with a space in between each number ex. 6 12 1 18 20 5
    **/
    private static String keygen(int numset, int range)
    {
        //Creating a new Random object called "rn" for the random number generator
        Random rn = new Random();
        /*
        * "numline" is the array of values that will be randomly generated and stored.
        * The number of preallocated slots is determined by "numset" with one extra slot.
        */
        int[] numline = new int[numset + 1];
        /*
        * For Loop
        *
        * This for loop will go through the array called "numline" and store
        * a random number to be generated with the given range from 1 to "range".
        * We store these values from array slots 1 through "numset".
        */
        for(int i = 0; i < numset; i++) {
            numline[i + 1] = rn.nextInt(range) + 1;
        }
        /*
        * Slot zero of the "numline" array is a random generated number from 1 to
        * "numset". This number is used as to define where the key should start to
        * encrypt and decrypt in the later programs.
        */
        numline[0] = rn.nextInt(numset) + 1;
        //Building the string with the values from the array and putting a space in between each number
        String strline = numline[0] + " ";
        for(int i = 1; i <= numset; i++)
        {
            strline = strline + numline[i] + " ";
        }
        //Return the final string of key values for the key file
        return strline;
    }

    public static void main(String[] args)
    {
        //Creating a Scanner object to obtain input from the user
        Scanner input = new Scanner(System.in);
        /*
        * Initializing Boolean Logic Loop
        *
        * error - used to allow the user to try again if the user inputs errors throwing exceptions
        */
        boolean error = true;
        while (error)
        {
            //Prompt for user input for the directory where the key file should be created
            System.out.println("Please Input A Directory for the Output File (ex. C:\\folder\\subfolder ): ");
            /*
            * Try-Catch Block
            *
            * Used to catch any input errors for going to the directory
            * and trying to create the file for the key file. Also used
            * to catch errors for any inputs that are not integers in
            * the fields that require integers from the variables "numvalues"
            * and "valuerange".
            */
            try {
                //"dir" is the user input of the directory for the file to be created
                String dir = input.nextLine();
                //Prompt the user to input the file name that should be created
                System.out.println("Please Input File Name to Be Created (ex. key): ");
                //"filename" is the stored name the user inputted
                String filename = input.nextLine();
                //Creating a File object that has the full directory with the new file name and extension
                File fileloc = new File(dir + "\\" + filename + ".ky");
                //Creating a FileOutputStream object
                FileOutputStream fileout = new FileOutputStream(fileloc);
                //Creating a OutputStreamWriter object
                OutputStreamWriter outputwriter = new OutputStreamWriter(fileout);
                //Creating a BufferWriter object
                BufferedWriter bw = new BufferedWriter(outputwriter);
                //Prompt user to input a integer for the number of values that should be in they key
                System.out.println("Please Enter the Number of Values You Want in the Key Set: ");
                //"numvalues" stores the number that will be used to create that numver of values for the key file
                int numvalues = input.nextInt();
                //Prompt user to input the value for the max value that can be generated for the key file
                System.out.println("Please Enter the Max Value the Key Set Can Have: ");
                //"valuerange" stores the value that will determine the max value that can be generated
                int valuerange = input.nextInt();
                //"outputstring" will get the String returned by the method keygen which will give a string of numbers that are separated by a space each
                String outputstring = keygen(numvalues, valuerange);
                //Split the string of values into an array of Strings called "parts"
                String[] parts = outputstring.split(" ");
                //With the new created file write String in the array cell parts[0] on the first line
                bw.write(parts[0]);
                //Point the cursor to the next line
                bw.newLine();
                /*
                * For Loop
                *
                * Write to the file on the second line each String in each array cell of parts
                * while placing a space in between each of the Strings in separate array cells.
                * At the last value do not write a space into the file.
                */
                for (int i = 1; i < parts.length; i++) {
                    bw.write(parts[i]);
                    if (i != ((parts.length) - 1)) {
                        bw.write(" ");
                    }
                }
                //Flush any remaining data to be written to the file
                bw.flush();
                //Close and save the newly created file
                bw.close();
                //Print out the file location and file name of the newly created file
                System.out.println();
                System.out.println("The Following Key File: " + filename + ".ky");
                System.out.println("Is Located In: " + dir);
                //End the loop if the file is created successfully
                error = false;
            }
            catch (IOException e)
            {
                System.out.println("ERROR - File Could Not Be Created");
                input.next();
            }
            catch (InputMismatchException e)
            {
                System.out.println("ERROR - Value Inputted Is Invalid");
               input.nextLine();
            }


        }
    }
}
