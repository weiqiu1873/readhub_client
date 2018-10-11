package com.example.wwq_123.readhub.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.example.wwq_123.readhub.umeng.UMeng;
import com.umeng.analytics.MobclickAgent;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseContract.BaseView {

    protected T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initTitleBar();
        initData();
        initEvent();
        UMeng.setUMeng(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.detachView();
        }
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
        UMeng.checkVersion(this);
    }

    public abstract void initView();

    public abstract void initTitleBar();

    @Override
    public void showSuccess() {

    }

    @Override
    public void showFailed() {

    }

}
