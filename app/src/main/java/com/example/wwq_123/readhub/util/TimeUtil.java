package com.example.wwq_123.readhub.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

    public static String UTCTOTimestamp(String utcTime){
        String time = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            Date date = sdf.parse(utcTime);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            time = String.valueOf(calendar.getTimeInMillis());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }
}
