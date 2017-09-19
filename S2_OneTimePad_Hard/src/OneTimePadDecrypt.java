import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;
import java.io.*;
/**
 * @author Alex Wong won4a@gmail.com
 * @version 1.0
 *
 * <p>OneTimePadDecrypt is the final part of the program that
 * is to take the key file and the message file then convert
 * it to the original message. The program will ask the user
 * to input the directories of the file location for the key
 * and the encrypted message. The program will take these files
 * and decrypt the message and print it out onto the prompt.</p>**/
public class OneTimePadDecrypt {
    /**
     * This method will take each charter and the value it
     * needs to shift the character to the left of the
     * alphabet. This will then output the new character that
     * has been decrypted.
     *
     * @param shift the number of times the character needs to be shifted to the left of the alphabet
     * @param c the character that needs to be decrypted
     * @return the decrypted character
     **/
    private static char decrypt(int shift, char c)
    {
        /*
        * For Loop
        *
        * This loop will go through the number of times the character
        * needs to be shifted
        */
        for(int i = 0; i<shift; i++)
        {
            //If character reaches to the beginning of the uppercase alphabet go back to 'Z'
            if(c == 'A')
            {
                c = 'Z';
            }
            //Otherwise decrement to the next character in the alphabet
            else
            {
                c-=1;
            }
        }
        //Return the new decrypted character
        return c;
    }

    public static void main(String[] args)
    {
        //Creating a Scanner object to obtain the input from the user
        Scanner input  = new Scanner(System.in);
        //Creating a Stack object to use for reading the key and message file
        Stack stack = new Stack();
        //Initializing a String called "fullmessage" that will contain the entire decrypted message
        String fullmessage = "";
        //Initializing count and pointer to determine the number of values in the stack and point at the shifting values
        int count = 0, pointer = 0;
        //Initializing boolean variables for loops to allow the user to correct input errors
        boolean error = true;
        while(error)
        {
            //Prompt the user input for the key file location
            System.out.println("Please Input the Directory with the .ky Key File (ex. C:\\folder\\subfolder\\filename.ky ): ");
            try {
                //Store the location of the key file in "dir"
                String dir = input.nextLine();
                //Create a new File object with the directory of the key file
                File file = new File(dir);
                //Create a Scanner object to read the key file
                Scanner read = new Scanner(file);
                //Read all of the integers of the key file and push them into the stack and count the number of values that are stored in the stack
                while (read.hasNextInt()) {
                    stack.push(read.nextInt());
                    count++;
                }
                //Create a array of integers with the total number of values in the stack
                int[] keyvalues = new int[count];
                //Pop all the values off the stack and place them into the new array called "keyvalues"
                for(int i = 0; i < count; i++)
                {
                    keyvalues[(count-1)-i] = (int)stack.pop();
                }
                //Prompt the user to input the location of the file for the encrypted message
                System.out.println("Please Input the Directory with the .em Encrypted Message File (ex. C:\\folder\\subfolder\\filename.em ): ");
                //Store the location of the encrypted message file into "dir"
                dir = input.nextLine();
                //Recreate the File object with the new directory to the encrypted message file
                file = new File(dir);
                //Recreate the Scanner object with the new directory to the message file
                read = new Scanner(file);
                //Read the first integer in the file and make it the pointer value
                pointer = read.nextInt();
                //Reset the count to zero
                count = 0;
                //Read the message file String by String and push each String into the empty stack adn increment count for the number of elements in the stack
                while(read.hasNext()) {
                    stack.push(read.next());
                    count++;
                }
                //Create a String Array with the number of elements in the stack
                String[] message = new String[count];
                //For each element in the stack pop it off and store it into the new String Array
                for(int i = 0; i<count; i++)
                {
                    message[(count-1)-i] = (String)stack.pop();
                }
                /*
                * For Loop
                *
                * For each String in the array get the legnth of the number of chars in the String and
                * call the decrypter for each char in the string and use the pointer to get each shift
                * value from "keyvalues" and take the decrypted char and add it to the full message. Do
                * this for each char in the string. Decrement the pointer to the next shift value if it
                * reaches to the end of the "keyvalue" on the left side go back to the right (the end of
                * the "keyvalue" array. Once you reach the end of the String give the "fullmessage" a
                * space. Then go on to the next string and continue on until all of the strings are
                * completely decrypted. Once it is completed display the string "fullmessage" as it will
                * have the entire decrypted message stored.
                */
                for(int i = 0; i < message.length; i++)
                {
                    for(int j = 0; j < message[i].length(); j++)
                    {
                        fullmessage = fullmessage + decrypt(keyvalues[pointer] , message[i].charAt(j));
                        if(pointer == ((keyvalues.length)-1))
                        {
                            pointer = 1;
                        }
                        else
                        {
                            pointer++;
                        }
                    }
                    fullmessage = fullmessage + " ";
                }
                System.out.println();
                System.out.println("Decrypted Message: ");
                System.out.println(fullmessage);
                //End the Program Loop as the Message has been decrypted
                error = false;
            }
            catch (FileNotFoundException e)
            {
                System.out.println("ERROR - Key File Could Not Be Opened");
            }
            catch (InputMismatchException e)
            {
                System.out.println("Error - Key File Is Invalid");
            }
        }
    }
}
