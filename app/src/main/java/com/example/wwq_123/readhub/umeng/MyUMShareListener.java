package com.example.wwq_123.readhub.umeng;

import android.content.Context;
import android.widget.Toast;

import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

public class MyUMShareListener implements UMShareListener {
    private Context context;
    public MyUMShareListener(Context context){
        this.context = context;
    }
    @Override
    public void onStart(SHARE_MEDIA share_media) {

    }

    @Override
    public void onResult(SHARE_MEDIA share_media) {
        Toast.makeText(context,"分享成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
        Toast.makeText(context,"分享失败"+throwable.getMessage(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCancel(SHARE_MEDIA share_media) {
        Toast.makeText(context,"取消分享",Toast.LENGTH_LONG).show();
    }
}
