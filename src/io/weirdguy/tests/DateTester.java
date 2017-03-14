package io.weirdguy.tests;

import io.weirdguy.practice.DateWorker;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * io.weirdguy.tests by laiko in practiceWork
 * Created on 14.03.2017
 */
public class DateTester {

    static String[] dates;
    static String[] realDays;

    @BeforeClass
    public static void initialSetUp() {

        dates = new String[]{"21 жовтень 2015", "14 березень 2017", "27 квітень 2019"};
        realDays = new String[]{"середа", "вівторок", "субота"};

    }

    @Test
    public void daysTest() {
        for(int i = 0; i < dates.length; i++) {
            assertTrue(checkDate(DateWorker.getDate(dates[i]), i));
            System.out.println("Date correct");
        }
    }

    private boolean checkDate(String date, int i) {
        if(date.equalsIgnoreCase(realDays[i])) return true;
        return false;
    }

}
