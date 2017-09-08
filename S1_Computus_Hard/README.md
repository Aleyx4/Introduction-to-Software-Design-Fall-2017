# S1_Computus_Hard

[Home](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017- "Home")

### Problem Statement
This program is to determine the date of Easter when the user inputs in a particular year.  The following is an example of the program display:
>Enter A Year: 2008

>Easter Occurs On: Match 23, 2008

The program should be able to use the [Meeus/Jones/Butcher Gregorian Algorithm](https://en.wikipedia.org/wiki/Computus#Anonymous_Gregorian_algorithm) to determine the date of Easter. The program will then also calculate the frequency of when Easter occurs every cycle of 5,700,000 years. The following is an example of what it should display:
>March 22 - 27550

>March 23 - 54150

>...

>April 25 - 42000

Also, an automated testing suite from JUnit 4 will be used to test the program with a list of 20 or more known Easter dates from a reliable source.

### User Documentation
The user will be prompted to enter a year of their desire. The program will then calculate the date of when Easter will occur in the specified year and display it. Afterwards, the program will start calculating the frequency from the start of the specified year to the end of the cycle (5,700,000 Years). It will then display the frequency of when Easter occurs on each date. The program will then ask the user if it would like to enter another year or quit the program.

### Developer Documentation
The program has a global integer variable for the year to be used to calculate the date of Easter. The year 1818 is the default value set if not set to anything to prevent errors if any method is called. To set the year you are able to call `setYear()`. To check if it has been set or to see what year is in the global variable you may call `getYear()` which will return an integer.

This program is able to calculate and provide the month and the day of Easter with the provided year using the following methods:

#### `calculateMonthValue()`

This will calculate the month number and return the integer with the corresponding values to these months:

>3 = March

>4 = April

Other values of months are not needed as Easter does not occur in any other months besides March and April.

#### `getMonthName()`

This will calculate the month and convert it to a String of the name of the month. Either March or April will be returned since only those two months are where Easter will occur.

#### `calculateDayValue()`

This will calculate and return the day of the month that Easter will occur on as an integer.

#### `occurrenceDateDisplay()`

This is a function that will take the year and calculate the dates of when Easter occurs in a full cycle (5,700,000 Years). This will then tally up the number of times Easter occurs on the same date. It will then print out the occurrences in the following format:

>March 22 - 27550

>March 23 - 54150

>...

>April 25 - 42000

Overall with the functions provided you are able to format the date to your desire. 

>Ex.

>MM/DD/YYYY

>Month DD, YYYY 

>DD Month YYYY

>YYYY-MM-DD

### JUnit4 Testing

In **ComputusJUnit4Test** it tested twenty different years to see if the program would return the correct dates of Easter. Calling each of the methods to return either the correct day, month and year. The following source was used to determine the correct dates of Easter: https://www.census.gov/srd/www/genhol/easter500.html

### [JavaDocs](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017-/tree/master/S1_Computus_Hard/JavaDoc)

### [Source Code](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017-/tree/master/S1_Computus_Hard/src/com/homework/S1_Computus_Hard)
