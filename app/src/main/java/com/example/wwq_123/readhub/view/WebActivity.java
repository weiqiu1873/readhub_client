package com.example.wwq_123.readhub.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.base.BaseActivity;
import com.just.agentweb.AgentWeb;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.PushAgent;

public class WebActivity extends BaseActivity {

    private FrameLayout web_frame;
    private AgentWeb agentWeb;
    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UMConfigure.setLogEnabled(true);
        UMConfigure.setEncryptEnabled(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        MobclickAgent.setSessionContinueMillis(1000);
        PushAgent.getInstance(this).onAppStart();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    public void initView() {
        web_frame = findViewById(R.id.web_frame);
    }

    @Override
    public void initData() {
        url = getIntent().getStringExtra("url");
        agentWeb = AgentWeb.with(this)
                .setAgentWebParent(web_frame,new FrameLayout.LayoutParams(-1,-1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(url);

    }

    @Override
    public void initTitleBar() {

    }

    @Override
    public void initEvent() {

    }

}
