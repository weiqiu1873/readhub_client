package com.example.wwq_123.readhub.db;

import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PreferencesUtil extends BasePreferences {

    private static PreferencesUtil util;

    private final String IS_LOGIN = "isLogin";
    private final String LAST_LOGIN = "lastLogin";
    private final String USER_ID = "uid";
    private final String USER_NAME = "name";
    private final String USER_IMAGE = "iconurl";

    private PreferencesUtil(Context context) {
        super(context);
    }

    public static PreferencesUtil getInstance(Context context){
        if (null==util){
            synchronized(PreferencesUtil.class){
                if (util==null){
                    util = new PreferencesUtil(context);
                }
            }
        }
        return util;
    }

    public void setLogin(boolean islogin){
        setBoolean(IS_LOGIN,islogin);
    }

    public boolean isLogin(){
        return getBoolean(IS_LOGIN);
    }

    public void setLastlogin(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = format.format(date);
        setString(LAST_LOGIN,currentTime);
    }

    public boolean loginIsPass(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar lastTime = Calendar.getInstance();
        Calendar currentTime = Calendar.getInstance();
        try {
            if (getString(LAST_LOGIN)==null){
                return true;
            }
            Date date = format.parse(getString(LAST_LOGIN));
            lastTime.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (currentTime.getTimeInMillis()-lastTime.getTimeInMillis()>=60*60*24*3*1000){
            return true;
        }else {
            return false;
        }
    }

    public void setUserId(String id){
        setString(USER_ID,id);
    }

    public String getId(){
        return getString(USER_ID);
    }

    public void setUserName(String name){
        setString(USER_NAME,name);
    }

    public String getUserName(){
        return getString(USER_NAME);
    }

    public void setUserImage(String imageUrl){
        setString(USER_IMAGE,imageUrl);
    }

    public String getUserImage(){
        return getString(USER_IMAGE);
    }

    public boolean loginStatus(){
        return isLogin()&&!loginIsPass()?true:false;
    }
}
