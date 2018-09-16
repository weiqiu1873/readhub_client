package com.example.wwq_123.readhub;

import android.app.Application;
import android.util.Log;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.socialize.PlatformConfig;

public class UMApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数3:Push推送业务的secret
         */
//        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "dd722ae5353c0bddf8c4d7789ab207be");
//        UMConfigure.init(this,"5b9267fdf43e480b39000402","readhub"
//                ,UMConfigure.DEVICE_TYPE_PHONE, "dd722ae5353c0bddf8c4d7789ab207be");
//        PushAgent pushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口j
//        pushAgent.register(new IUmengRegisterCallback() {
//            @Override
//            public void onSuccess(String s) {
//                Log.i("my_token",s);
//            }
//            @Override
//            public void onFailure(String s, String s1) {
//                Log.i("Failure",s+"\n"+s1);
//            }
//        });
    }
    {
        PlatformConfig.setWeixin("wx31c30eb903264e47", "3606c09643a7e5311054a1202136fc68");
        PlatformConfig.setQQZone("1107757805", "ZJlY0gybmaB2MHmp");
        PlatformConfig.setSinaWeibo("","","");
    }
}
