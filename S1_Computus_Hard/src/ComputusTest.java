import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 *
 * <p>ComputusTest is a program that implements Computus allowing the user
 * to input a year to get the date of Easter in the format: MMMMM DD, YYYY
 * Then it will print out the occurrences of the dates of Easter for an
 * entire cycle of 5,700,000 years. After the program allows the user to
 * input a new year or end the program.</p>
**/
public class ComputusTest {
    public static void main(String[] args) {
        //Creating a Scanner object to obtain input from the user
        Scanner input = new Scanner(System.in);
        /*
        * Initializing Boolean Logic Loops
        *
        * repeat - is used as the main program loop.
        * error - is used to make sure if the user inputs an error
        * the program allows the user to try and input it again.
        */
        boolean error = true, repeat = true;
        //Create a com.homework.S1_Computus_Hard.Computus object and assign it to the com.homework.S1_Computus_Hard.Computus
        Computus theComputus = new Computus();
        /*
        * Main Program Loop
        *
        * This loop will end if the user tells the program
        * to do so at the end of the program loop.
        */
        while(repeat)
        {
            /*
            * User Input Loop
            *
            * This loop is to allow the user to keep trying
            * to input a year if the input was invalid. It is
            * invalid if the value is not an integer.
            */
            while (error)
            {
                //Dialog for user to inout in a year
                System.out.printf("Enter A Year: ");
                /*
                * Try-Catch Block
                *
                * Used to catch user input errors for entering a year.
                * The user can only enter integers otherwise the program
                * will catch the exception and ask the user to input the
                * year again.
                */
                try
                {
                    //theYear is the year inputted by the user that must be an Integer
                    int theYear = input.nextInt();
                    //Calls setYear() method to set the year in com.homework.S1_Computus_Hard.Computus from the user inputted integer
                    theComputus.setYear(theYear);
                    //If the user input is valid then error loop will end
                    error = false;
                }
                catch (InputMismatchException e)
                {
                    //If user input is invalid then we print out an error message
                    System.out.println("ERROR - Invalid Year!");
                    //Buffer is used to flush out any remaining input
                    input.next();
                }
            }
            /*
            * Calculating The Day of Easter
            *
            * Calling the method calculateDayValue() to calculate the which day
            * number Easter lands on and using getMonthName() to get the month
            * name that Easter is on.
            */
            int dayvalue = theComputus.calculateDayValue();
            //getMonthName{} is called to take the calculated month number to a String of the actual month name
            String monthname = theComputus.getMonthName();
            //Printing out formatted display of when Easter occurs
            System.out.println("Easter Occurs On: " + monthname + " " + dayvalue + ", " + theComputus.getYear());
            //Method called to print out the frequency of Easter dates from the users input year
            theComputus.occurrenceDateDisplay();
            /*
            * User Input Loop
            *
            * This loop is to determine if the user would like to
            * run the program again. The user must input a [y/n].
            * This is not capital sensitive but other inputs will
            * make a prompt to ask the question again till a valid
            * input is typed in.
            */
            while(!error)
            {
                //Prompt the user if they would like to run the program again
                System.out.printf("Do You Wish To Input A New Year [Y/N]?: ");
                //Creating a Scanner object to obtain input from the user
                Scanner input2 = new Scanner(System.in);
                //yesno is the String response of the user input to the question
                String yesno = input2.nextLine();
                /*
                * Yes or No If Statement
                *
                * This if statement will check if the user inputs a [y/Y] for yes
                * or a [n/N] for no to rerun the program. If the input is one of
                * the following it will exit out of the error loop and either end
                * or continue the repeat loop of the program. If it is an invalid
                * input then we will print out an error and ask to try to input a
                * valid response.
                */
                if((yesno.charAt(0) == 'y') || (yesno.charAt(0) == 'Y'))
                {
                    error = true;
                }
                else if((yesno.charAt(0) == 'n') || (yesno.charAt(0) == 'N'))
                {
                    error = true;
                    repeat = false;
                }
                else
                {
                    System.out.println("ERROR - Response Is Invalid!");
                }
            }
        }
        //Output Statement that the user has decided to end the program repeat loop
        System.out.println("PROGRAM HAS BEEN TERMINATED");
    }
}