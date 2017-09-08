package com.homework.S1_Computus_Hard;

import org.junit.Assert;
import org.junit.Test;
import org.hamcrest.CoreMatchers;
/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 *
 * <p>Used to test the functions of Computus to see if it is outputting
 * the correct dates of Easter. This validates twenty random dates of
 * Easter from: https://www.census.gov/srd/www/genhol/easter500.html</p>
**/
public class ComputusJUnit4Test {
    @Test
    public void testComputus() throws Exception
    {
        Computus testComputus = new Computus();

        /*
        * Data Source (https://www.census.gov/srd/www/genhol/easter500.html)
        *
        * This is three arrays created with the listed data of twenty days
        * of Easter from a range of Years corresponding to the months and
        * days from each slot of the array.
        * */
        int[] years = {1600, 1704, 1898, 1996, 2001, 2014, 2017, 1610, 1698, 1630, 2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025, 2026, 2027};
        String[] months = {"April", "March", "April", "April", "April", "April", "April", "April", "March", "March", "April", "April", "April", "April", "April", "April", "March", "April", "April", "March"};
        int[] days = {2, 23, 10, 7, 15, 20, 16, 11, 30, 31, 1, 21, 12, 4 , 17, 9 , 31, 20, 5, 28};

        int resultyear, resultday;
        String resultmonth;
        /*
        * Date Testing For Loop
        *
        * This will go through each of the following years and run the methods to see
        * if it outputs the correct dates and months that were expected from the arrays of
        * corresponding dates, months, and years.
        *
        */
        for(int i = 0; i < 20; i++)
        {
            testComputus.setYear(years[i]);
            resultyear = testComputus.getYear();
            Assert.assertThat(resultyear, CoreMatchers.is(years[i]));

            resultmonth = testComputus.getMonthName();
            Assert.assertThat(resultmonth, CoreMatchers.is(months[i]));

            resultday = testComputus.calculateDayValue();
            Assert.assertThat(resultday, CoreMatchers.is(days[i]));
        }
    }
}
