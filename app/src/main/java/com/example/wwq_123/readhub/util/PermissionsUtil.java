package com.example.wwq_123.readhub.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

public class PermissionsUtil {

    private Context context;
    private static PermissionsUtil util;

    private PermissionsUtil(Context context){
        this.context = context;
    }

    public static PermissionsUtil getInstance(Context context){
        if (util==null){
            util = new PermissionsUtil(context);
        }
        return util;
    }

    private static String[] PERMISSION_STORAGE =
            {"android.permission.READ_EXTERNAL_STORAGE"
            ,"android.permission.WRITE_EXTERNAL_STORAGE"};

    public boolean hasStoragePermission(){
        int readPre = context.checkCallingOrSelfPermission(PERMISSION_STORAGE[0]);
        int writePre = context.checkCallingOrSelfPermission(PERMISSION_STORAGE[1]);
        return readPre==PackageManager.PERMISSION_GRANTED&&writePre==PackageManager.PERMISSION_GRANTED;
    }

    public void getStoragePermission(){
        ActivityCompat.requestPermissions((Activity) context,PERMISSION_STORAGE,0);
    }



}
