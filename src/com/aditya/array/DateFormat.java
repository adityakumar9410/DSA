package com.aditya.array;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    public static void main(String[] args) {
        try {
            Date myDate = new Date();
            System.out.println(myDate);

            SimpleDateFormat mdyFormat = new SimpleDateFormat("dd-MMM-yyyy");
           // SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Format the date to Strings
            String mdy = mdyFormat.format(myDate);
           // String dmy = dmyFormat.format(myDate);

            // Results...
            System.out.println(mdy);
           // System.out.println(dmy);
            // Parse the Strings back to dates
            // Note, the formats don't "stick" with the Date value
            System.out.println(mdyFormat.parse(mdy));
           // System.out.println(dmyFormat.parse(dmy));
        } catch (ParseException exp) {
            exp.printStackTrace();
        }
    }
}
