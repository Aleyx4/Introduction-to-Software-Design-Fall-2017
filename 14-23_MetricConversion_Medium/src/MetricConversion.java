import java.util.ArrayList;

/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>This is a program that will take Metric Units and convert it
 * to US Imperial Units. The program will prompt the user to input
 * a question. The following conditions must be met for the program
 * to be able to parse the question.
 *
 * ex. How many inches are in 2 meter?
 *
 * 1) The Imperial Unit must be in the question first before the Metric Unit
 *
 * 2) The Metric Unit Number to be oonverted must be before the Metric Unit
 *
 * 3) Units must be spelled correctly
 *
 * 4) You must use a plural form of Imperial Units
 *
 * This program has the ability to convert length, volume, and mass.
 *
 * The following conversions are possible:
 *
 * - millimeters, centimeters, kilometers, meters -> inches, feet, yards, miles
 * - milliliters, kiloliters, liters -> pints, gallons
 * - milligram, kilogram, gram -> ounces, pounds</p>
 */

public class MetricConversion {

    //Length Conversions

    /**
     * Constant array of strings for Metric Unit Names for Length
     */
    final private String[] metricLengthName = {"millimeter", "centimeter", "kilometer", "meter"};
    /**
     * Constant array of doubles for Metric conversion values from base of 1 Meter to the
     * matching Imperial Unit Name in the "imperialLengthName" array.
     */
    final private Double[] metricLegnthConv = {39.3700787, 3.2808399, 1.0936133, 0.000621371192};
    /**
     * Constant array of strings for Imperial Unit Names for Length
     */
    final private String[] imperialLengthName = {"inches", "feet", "yards", "miles"};

    //Volume Conversions

    /**
     * Constant array of strings for Metric Unit Names for Volume
     */
    final private String[] metricVolumeName = {"milliliter", "kiloliter", "liter"};
    /**
     * Constant array of doubles for Metric conversion values from base of 1 Liter to the
     * matching Imperial Unit Name in the "imperialVolumeName" array.
     */
    final private Double[] metricVolumeConv = {1.75975043, 0.219968813};
    /**
     * Constant array of strings for Imperial Unit Names for Volume
     */
    final private String[] imperialVolumeName = {"pints", "gallons"};

    //Mass Conversions

    /**
     * Constant array of strings for Metric Unit Names for Mass
     */
    final private String[] metricMassName = {"milligram", "kilogram", "gram"};
    /**
     * Constant array of doubles fro Metric conversion values from base of 1 gram to the
     * matching Imperial Unit Name in the "imperialMassName" array.
     */
    final private Double[] metricMassConv = {0.0352733686, 0.00220462262};
    /**
     * Constant array of strings for Imperial Unit Names for Mass
     */
    final private String[] imperialMassName = {"ounces", "pounds"};

    //Decimal Conversions

    /**
     * Constant array of strings for Metric Decimal Placement
     */
    final private String[] metricDecimalName = {"kilo", "centi", "milli"};
    /**
     * Constant array of doubles for Metric Decimal Multiplier to convert the base
     * Metric value to which every decimal placement corresponding to the "metricDecimalName"
     * array.
     */
    final private Double[] multiplierConv = {1000.0, 0.01, 0.001};

    /**
     * Array of strings that will be used to convert the user response by splitting each
     * world into a separate strings stored into an ArrayList called question. This will
     * be divided by the space occurrences in the user response.
     */
    private ArrayList<String> question = new ArrayList<>();
    /**
     * This will store the string of the Imperial Unit found in the user response.
     */
    private String imperialUnit = null;
    /**
     * This will store the string of the Metric Unit found in the user response.
     */
    private String metricUnit = null;
    /**
     * This will store the double of the metric value to be converted found in the user response.
     */
    private Double metricValue = null;
    /**
     * This will store the double for the conversion of 1 Metric Base Unit to the Imperial Unit
     * the user response asked for.
     */
    private Double convValue = null;
    /**
     * This will store the decimal multiplier for the prefix in the metric unit found in the user response.
     */
    private Double convMultiplier = 1.0;
    /**
     * This will store the double that is the converted value from Metric to Imperial.
     * Also known as the answer to the user question.
     */
    private Double imperialValue = null;
    /**
     * This will store the Boolean variable to determine if the question the user
     * inputted is a valid question that can be parsed. Default is false.
     */
    private Boolean valid = false;

    /**
     * This method is called to set the question asked by the user to be
     * parsed for the program. This will split the question into separate
     * words to be started into an ArrayList called "question".
     * @param input The string of a question being asked by the user.
     *
     *              This should follow the following examples:
     *
     *              - How many inches are in 3 meters?
     *              - How many gallons are in 2 milliliters?
     *
     *              General Format:
     *
     *              - [imperial unit] -> [value] [metric unit]
     */
    public void userInputQuestion(String input)
    {

        for(int i = 0; i < input.length(); i++)
        {
            if(input.charAt(i)==' ')
            {
                question.add(input.substring(0,i));
                input = input.substring(i+1, input.length());
                i = 0;
            }
            else if(i == input.length()-1)
            {
                question.add(input);
            }
        }
    }

    /**
     * Method used to once the question is set to parse and output the imperial value converted
     * from the users question. If return is null then the value could not be converted.
     * This function will call the method "retrieveData()" to parse the information out of the
     * user's question that is in the ArrayList.
     * @return The double for the converted value in Imperial Units the user asked for,
     */
    public Double convert() {
        retrieveData();
        return imperialValue;
    }

    /**
     * A get method for the "imperialUnit" variable.
     * @return The string of the Imperial Unit that was found in the user's question.
     */
    public String getImperialUnit() {
        return imperialUnit;
    }

    /**
     * A get method for "metricUnit" variable.
     * @return The string for the Metric Unit found in the user's question.
     */
    public String getMetricUnit() {
        //If the metric value is plural add the "s" to the metric unit.
        if(metricValue != 1)
        {
            return metricUnit + "s";
        }
        return metricUnit;
    }

    /**
     * A get method for "metricValue" variable.
     * @return The double for the metric value the user asked to convert to imperial form.
     */
    public Double getMetricValue() {
        return metricValue;
    }

    /**
     * This is a get method for "valid" variable.
     * @return Boolean value that determines if the question the user inputted is a valid question
     * that can be parsed.
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * This will call the method "unitMatching()" which will check if it is possible to
     * convert between the metric and imperial units found in the question the user inputted.
     * If it is possible it will take the values and compute the imperial value and store it
     * into the variable "imperialValue". If it is not convertible then print out a line to
     * tell the question as not valid.
     */
    private void retrieveData()
    {
        if((unitMatching(metricLengthName, imperialLengthName, metricLegnthConv))||(unitMatching(metricVolumeName, imperialVolumeName, metricVolumeConv))||unitMatching(metricMassName, imperialMassName, metricMassConv))
        {
            imperialValue = convValue*metricValue*convMultiplier;
        }
        else
        {
            System.out.println("ERROR - Question Could Not Be Parsed");
        }
    }

    /**
     * This method is used to parse the ArrayList that holds the question. This will take
     * the metric and imperial names arrays and check if any of the names match in the
     * ArrayList. If it does then they will be stored in their respective variables. The metric
     * value also will be believed to be on the left of the ArrayList where the Metric Name was
     * located. Finding the names will correspond to the metricConv array which will have the
     * conversion value for the specific base units to the imperial unit.
     *
     * The program will look in the metric unit to see if it contains a prefix and if it does
     * it will store the prefix multiplier into its corresponding variable.
     *
     * If at anytime it cannot find any of these values it will return a false value and if it
     * finds all the necessary values then it will return true.
     * @param metric The array of a specific Metric Conversion Names either Length/Mass/Volume
     * @param imperial The array of a specific Imperial Conversion Names either Length/Mass/Volume
     * @param metricConv The array of a specific Metric Bass Conversion Values to Imperial Values either Length/Mass/Volume
     * @return A boolean to see if all the required information to convert was found in the question the user inputted.
     */
    private boolean unitMatching(String[] metric, String[] imperial, Double[] metricConv)
    {
        for(int i = 0; i < question.size(); i++) {
            String word = question.get(i);
            if(imperialUnit == null)
            {
                //Look For Imperial Word in the Question
                for (int j = 0; j < imperial.length; j++) {
                    if (word.toLowerCase().contains(imperial[j])) {
                        imperialUnit = imperial[j];
                        convValue = metricConv[j];
                    }
                }
            }
            if(imperialUnit != null) {
                //Look For Metric Word in the Question
                for (int k = 0; k < metric.length; k++) {
                    if (word.toLowerCase().contains(metric[k])) {
                        metricUnit = metric[k];
                        /*
                        * Convert the String that Should be the Value into a Double
                        * which should be to the left of the Metric Unit found.
                        */
                        metricValue = Double.parseDouble(question.get(i-1));
                        /*
                        * Look For Prefix in the Metric Unit if found then get its
                        * corresponding multiplier from the array "metricConv".
                        */
                        for (int l = 0; l < 3; l++) {
                            if (word.toLowerCase().contains(metricDecimalName[l])) {
                                convMultiplier = multiplierConv[l];
                            }
                        }
                        valid = true;
                        return valid;
                    }
                }
            }
        }
        valid = false;
        return valid;
    }
}
