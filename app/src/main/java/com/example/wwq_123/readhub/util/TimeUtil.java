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
    //将UTC时间转换成北京时间
    public static Date UTCToCTC(String utc) throws ParseException {
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        date = format.parse(utc);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR,calendar.get(Calendar.HOUR)+8);
        return calendar.getTime();
    }
    //获取发布时间(utc)与现在时间的时间差
    public static String TimeDifference(String utcTime) {
        Date utc = null;
        try {
            utc = UTCToCTC(utcTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date now = new Date();      //获取现在时间
        long secondDifference = now.getTime()-utc.getTime();
        if (secondDifference>=3600000){
            //时间差大于1小时
            return  secondDifference/3600000+"小时前";
        }else {
            //时间差小于1小时
            int minute = (int) (secondDifference/60000);
            return  minute==0 ? String.valueOf(1) :minute+"分钟前";
        }

    }
}
