package com.example.wwq_123.readhub.base;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.wwq_123.readhub.R;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.PushAgent;
import com.umeng.socialize.UMShareAPI;

import static anet.channel.util.Utils.context;

public abstract class BaseActivity<T extends BaseContract.BasePresenter> extends AppCompatActivity implements BaseContract.BaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initTitleBar();
        initData();
        initEvent();
        UMConfigure.setLogEnabled(true);
        UMConfigure.setEncryptEnabled(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        MobclickAgent.setSessionContinueMillis(1000);
        PushAgent.getInstance(this).onAppStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
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
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }
    }

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initData();

    public abstract void initTitleBar();

    public abstract void initEvent();

    @Override
    public void showSuccess() {

    }

    @Override
    public void showFailed() {

    }

    @Override
    public void showNoNet() {

    }
}
