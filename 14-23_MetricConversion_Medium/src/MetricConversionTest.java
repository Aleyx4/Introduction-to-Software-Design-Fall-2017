import java.util.Scanner;

/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is the tester ckass to implement the Metric Conversion
 * program. It will prompt the user to enter a question with an
 * example given. The structure of the question must include
 * the Imperial Unit first then the Metric Value to be converted
 * to Imperial and the Metric Unit should be to the right of the
 * Metric Value. Any prefix should be included with the Metric
 * Unit. The tester class will setup and run the MetricConversion
 * classes to parse and return the correct value. The tester class
 * will then print out the returned values from the MetricConverter
 * class.</p>
 */
public class MetricConversionTest {
    public static void main(String args[]) {
        //Create New Scanner Object for User Input
        Scanner scanner = new Scanner(System.in);
        //Prompt User For Input
        System.out.println("Enter In Conversion Question: (ex. How many inches are in 1 meter?)");
        //Store User Input Into String
        String input = scanner.nextLine();
        //Create New MetricConversion Object
        MetricConversion mc = new MetricConversion();
        //Calling userInputQuestion with new object to store the user inputted question to be parsed
        mc.userInputQuestion(input);
        //Check if the parsed question is valid and print out the answer if it is valid otherwise a error statement will occur
        mc.convert();
        if (mc.getValid()) {
            //Call and print out the methods returned values for the answer to the conversion question
            System.out.println(mc.convert() + " " + mc.getImperialUnit() + " = " + mc.getMetricValue() + " " + mc.getMetricUnit());
        }
    }
}
