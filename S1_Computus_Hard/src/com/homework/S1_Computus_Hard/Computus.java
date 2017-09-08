package com.homework.S1_Computus_Hard;
/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 *
 * <p>Computus is built to compute the day and month of Easter with a given
 * year. The methods bellow allow calculation and the ability to format
 * the given date the way you want it.</p>
**/
public class Computus {
    /*
    * Initialized Integer Values
    *
    * year - is the year that will be used to calculate the day of Easter
    * h, k, and l - are the variables used to calculate the day and month of Easter
    */
    private int year = 1818;
    private int h,k,l;
    /*
    * Initialized String Array
    *
    * MONTHNAMES is a constant array of only two months that
    * Easter will ever occur. getMonthNames() use this
    * with a given month value to determine which month it is
    * corresponding to.
    */
    private static final String[] MONTHNAMES = {"March", "April"};
    /**
    * This method is to return the year value that
    * is in this class. Default value is 1818. Unless
    * year gets set.
    *
    * @return the year in an integer form
    **/
    public int getYear()
    {
        return year;
    }
    /**
    * This method is used to set a year value that will be
    * used to calculate the day when Easter will occur.
    *
    * @param year year to be used to calculate the date of Easter
    **/
    public void setYear(int year)
    {
        this.year = year;
    }
    /*
    * This method is a private method that will calculate the
    * values needed to determine the month and date values. This
    * will be called when you need to calculate the day and month
    * in these methods: calculateMonthValue(), calculateDayValue(),
    * and occurrenceDateDisplay()
    *
    * Note: Variables h,k, and l are global but private to be reused to calculate
    * the day and month. The rest are values that are only used to calculate
    * h, k, and l.
    */
    private void calculateVariables()
    {
        int a,b,c,d,e,f,g,i,j;
        a = (year % 19);
        b = (year / 100);
        c = (year % 100);
        d = (b / 4);
        e = (b % 4);
        f = ((b + 8) / 25);
        g = ((b - f + 1) / 3);
        h = (((19 * a) + b - d - g + 15) % 30);
        i = (c / 4);
        j = (c % 4);
        k = ((32 + (2 * e) + (2 * i) - h - j) % 7);
        l = ((a + (11 * h) + (22 * k)) / 451);
    }
    /**
    * This method will calculate the month value that
    * Easter is on. This will give the value
    * of 1 though 12 respective to the months.
    *
    * @return the month in integer form ex. 3
    **/
    public int calculateMonthValue()
    {
        calculateVariables();
        return ((h + k - (7 * l) + 114) / 31);
    }
    /**
    * This method will calculate the day value. It will
    * give the value of 1 though 31 respective of the days
    * in the corresponding month Easter is on.
    *
    * @return the day in integer form ex. 24
    **/
    public int calculateDayValue()
    {
        calculateVariables();
        return (((h + k - (7 * l) + 114) % 31) + 1);
    }
    /**
    * This method will convert the number that corresponds to
    * the correct month and return it as a String. This will
    * only display two different months that Easter occurs on.
    *
    * @return the month in String form ex. March
    **/
    public String getMonthName()
    {
        int monthvalue = ((calculateMonthValue()) - 3);
        if((monthvalue < 2) && (monthvalue >= 0))
        {
            return MONTHNAMES[monthvalue];
        }
        else
        {
            System.out.println("ERROR - The month value is NOT between 1 and 12!");
            return null;
        }
    }
    /**
    * This method will count the number of times Easter occurs
    * on each day within a cycle of 5,700,000 years starting
    * from the inputted year. It will print out the data collected.
    **/
    public void occurrenceDateDisplay()
    {
        int[][] occurrencecounter = new int[2][31];
        for(int count = 0; count < 2; count++)
        {
            for(int count2 = 0; count2 < 31; count2++)
            {
                occurrencecounter[count][count2] = 0;
            }
        }
        int tempyear = getYear();
        for(int count = 0; count < 5700000; count++)
        {
            year++;
            int tempmonth = calculateMonthValue();
            int tempday = calculateDayValue();
            occurrencecounter[tempmonth-3][tempday-1]++;
        }
        setYear(tempyear);
        System.out.println("--Frequency of When Easter Occurs in a Cycle of 5,7000,000 Years Starting at the Year " + year + "--");
        for(int count = 21; count < 31; count++)
        {
            System.out.println("March " + (count+1) + " - " + occurrencecounter[0][count]);
        }
        for(int count = 0; count < 25; count++)
        {
            System.out.println("April " + (count+1) + " - " + occurrencecounter[1][count]);
        }
        System.out.println();
    }
}
