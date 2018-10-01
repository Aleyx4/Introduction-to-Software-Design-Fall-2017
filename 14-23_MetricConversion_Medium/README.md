# 14-23_MetricConversion_Medium
# Submitted by @awong4 as part of @swd2017

[Home](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017 "Home")

### Problem Statement
Write an application that will assist users with metric conversions. The application should allow the user to specify the names of the units as a string. 

Examples:
> How many inches are in 2 meters?

> How many liters are in 10 quarts?

The application should recognize invalid conversions.

Example:
> How many feet are in 5 kilograms?

### User Documentation
The program will ask for the user to input a conversion question. The
conversion question must be formatted in the following way for it to
respond with an answer:

- Imperial Unit must be used in its plural form in the question

- Imperial Unit must seen in the question before the Metric Unit

- Metric Unit number must be to the left of the the Metric Unit

- All units must be spelled correctly

The following conversions are possible:

- millimeters, centimeters, kilometers, meters -> inches, feet, yards, miles
- milliliters, kiloliters, liters -> pints, gallons
- milligram, kilogram, gram -> ounces, pounds</p>

### Developer Documentation
An example to use the classes available is in the tester class.
`userInputQuestion()` is used to store the question asked by the user. This is a string that the user inputs. This will store the string into the program to be used.

After when `convert()` is called it will return the correct converted double in the Imperial Unit that was requested to be converted. If the converted value is invalid it will print out a statement.

You are also able to call `getValid()` to get the Boolean value to see if the question was valid. `convert()` needs to be called first to make try to convert it first.

The class will include a large amount of get methods that will retrieve any data that was parsed from the method `convert()`. These include `getImperialUnit()`, `getMetricUnit()`, and `getMetricValue()`. These will allow you to use them to output strings and such.

`retrieveData()` is used to print out an error if the question could not be parsed decided by the return value of `unitMatching()`. `unitMatching()` will parse the question and store the parsed data into its variables. It will return a Boolean variable that is to get if it is a valid question that can be converted.

### UML Diagram

![14-23_MetricConversion_Medium_UML](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/blob/master/14-23_MetricConversion_Medium/doc/14-23_MetricConversion_Medium_UML.png?raw=true)

### [JavaDocs](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/tree/master/14-23_MetricConversion_Medium/doc)

### [Source Code](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/tree/master/14-23_MetricConversion_Medium/src)
