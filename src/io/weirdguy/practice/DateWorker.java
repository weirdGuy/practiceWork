package io.weirdguy.practice;

/**
 * io.weirdguy.practice by laiko in practiceWork
 * Created on 14.03.2017
 */
public class DateWorker {

    public static String getDate(String date) {

        String[] monthss = new String[]{"січень", "лютий", "березень", "квітень", "травень", "червень", "липень", "серпень", "вересень", "жовтень", "листопад", "грудень"};
        int[] monthNums = new int[]{0,3,3,6,1,4,6,2,5,0,3,5};
        String[] days = new String[]{"неділя", "понеділок", "вівторок", "середа", "четвер", "п'ятниця", "субота"};

        String[] dateArr = date.split(" ");
        int year = Integer.parseInt(dateArr[2].substring(2));
        int century = getCenturyNumber(Integer.parseInt(dateArr[2]));

        return days[(century + year + (year / 4) + monthNums[getMonthNumber(monthss, dateArr[1])] + Integer.parseInt(dateArr[0])) % 7];
    }

    private static int getCenturyNumber(int date) {
        if (1900 <= date && date <= 1999)
            return 0;

        if (2000 <= date && date <= 2099)
            return 6;

        return 0;
    }

    private static int getMonthNumber(String[] month, String m) {
        int mnum = 0;
        for(int i = 0; i < month.length; i++) {
            if(m.equalsIgnoreCase(month[i])) {
                mnum = i;
                break;
            }
        }
        return mnum;
    }

}
