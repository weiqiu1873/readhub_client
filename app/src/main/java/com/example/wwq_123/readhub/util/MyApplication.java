package com.example.wwq_123.readhub.util;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private static MyApplication application;

    public static Context getAppContext(){
        return application == null ? null : application.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
}
