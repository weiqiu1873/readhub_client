package com.example.wwq_123.readhub.db;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Date;

public class BasePreferences {

    private static SharedPreferences sharedPreferences;
    private static String fileName = "readhub";

    protected BasePreferences(Context context){
        sharedPreferences = context.getSharedPreferences(fileName,Context.MODE_PRIVATE);
    }

    public void setString(String key,String value){
        sharedPreferences.edit().putString(key,value).commit();
    }
    public String getString(String key){
        return sharedPreferences.getString(key,null);
    }

    public void setBoolean(String key,boolean value){
        sharedPreferences.edit().putBoolean(key,value).commit();
    }
    public boolean getBoolean(String key){
        return sharedPreferences.getBoolean(key,false);
    }

}
