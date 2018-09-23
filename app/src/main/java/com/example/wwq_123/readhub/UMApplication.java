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
        UMConfigure.init(this,"5b9267fdf43e480b39000402","readhub"
                ,UMConfigure.DEVICE_TYPE_PHONE, "dd722ae5353c0bddf8c4d7789ab207be");
        PushAgent pushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口j
        pushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String s) { Log.i("my_token",s); }
            @Override
            public void onFailure(String s, String s1) { Log.i("Failure",s+"\n"+s1); }
        });
    }

    {
//        debug 应用签名：f5f37e53b68020c1c70ba3dfcfbecdb6
//        PlatformConfig.setWeixin("wx6ad550145b31aa6c", "b4c198ef5eb4998763f524e05d118bc9");
//        PlatformConfig.setQQZone("101501399", "b4560147d70c5294779a77bef0205940");

//        release 应用签名：0dc9ca8c3cf976e0d980c2ecdb206b1c
        PlatformConfig.setWeixin("wx31c30eb903264e47", "3606c09643a7e5311054a1202136fc68");
        PlatformConfig.setQQZone("101507866", "d52411c6a6ee846a42bf80b785097702");
    }
}
