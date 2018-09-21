package com.example.wwq_123.readhub.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.wwq_123.readhub.view.main.MainActivity;

public class LoadingService extends Service {
    private static int create_i = 0;
    private static int loading_i = 0;
    private static int destroy_i = 0;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.d("loading_service","oncreate"+create_i);
        create_i++;
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("loading_service","loading data..."+loading_i);
        loading_i++;
        timeStop(5);
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    public void timeStop(int second){
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        long time = SystemClock.elapsedRealtime()+second*1000;
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getService(this,0,intent,0);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,time,pendingIntent);
    }

    @Override
    public void onDestroy() {
        Log.d("loading_service","ondestroy..."+destroy_i);
        destroy_i++;
        super.onDestroy();
    }
}
