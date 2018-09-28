package com.example.wwq_123.readhub.umeng;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.PushAgent;

public class UMeng {

    public static void setUMeng(Context context){
        UMConfigure.setLogEnabled(true);
        UMConfigure.setEncryptEnabled(true);
        MobclickAgent.setScenarioType(context, MobclickAgent.EScenarioType.E_UM_NORMAL);
        MobclickAgent.setSessionContinueMillis(1000);
        PushAgent.getInstance(context).onAppStart();
    }

    public static void checkVersion(Activity activity){
        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ,Manifest.permission.ACCESS_FINE_LOCATION
                    ,Manifest.permission.CALL_PHONE
                    ,Manifest.permission.READ_LOGS
                    ,Manifest.permission.READ_PHONE_STATE
                    ,Manifest.permission.READ_EXTERNAL_STORAGE
                    ,Manifest.permission.SET_DEBUG_APP
                    ,Manifest.permission.SYSTEM_ALERT_WINDOW
                    ,Manifest.permission.GET_ACCOUNTS
                    ,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(activity,mPermissionList,123);
        }
    }
}
