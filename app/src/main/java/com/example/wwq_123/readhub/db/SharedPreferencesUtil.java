package com.example.wwq_123.readhub.db;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtil {
    private static SharedPreferencesUtil util;
    private static SharedPreferences.Editor editor;
    private static SharedPreferences sharedPreferences = null;

    public static SharedPreferencesUtil newInstance(Context context){
        if (util==null){
            util = new SharedPreferencesUtil();
            sharedPreferences = context.getSharedPreferences("readhub",Context.MODE_MULTI_PROCESS);
            editor = sharedPreferences.edit();
        }
        return util;
    }

    public void insert(String key,Object object){
        if (object instanceof String){
            editor.putString(key, (String) object);
        }else if (object instanceof Boolean){
            editor.putBoolean(key, (Boolean) object);
        }else if (object instanceof Integer){
            editor.putInt(key, (Integer) object);
        }else if (object instanceof Float){
            editor.putFloat(key, (Float) object);
        }else if (object instanceof Long){
            editor.putLong(key, (Long) object);
        }else{
            editor.putString(key,object.toString());
        }
        editor.commit();
    }
    public Object get(String key, Object defaultObject){
        if (defaultObject instanceof String){
            return sharedPreferences.getString(key, (String) defaultObject);
        }else if (defaultObject instanceof Boolean){
            return sharedPreferences.getBoolean(key, (Boolean) defaultObject);
        }else if (defaultObject instanceof Integer){
            return sharedPreferences.getInt(key, (Integer) defaultObject);
        }else if (defaultObject instanceof Float){
            return sharedPreferences.getFloat(key, (Float) defaultObject);
        }else if (defaultObject instanceof Long){
            return sharedPreferences.getLong(key, (Long) defaultObject);
        }else {
            return sharedPreferences.getString(key, null);
        }
    }

    public void remove(String key){
        editor.remove(key);
        editor.commit();
    }

    public void clear(){
        editor.clear();
        editor.commit();
    }

    public Boolean contain(String key) {
        return sharedPreferences.contains(key);
    }
}
