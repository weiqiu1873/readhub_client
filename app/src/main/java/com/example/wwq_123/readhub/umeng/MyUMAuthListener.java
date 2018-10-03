package com.example.wwq_123.readhub.umeng;

import android.content.Context;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class MyUMAuthListener implements UMAuthListener {

    private Context context;
    public MyUMAuthListener(Context context){
        this.context = context;
    }

    @Override
    public void onStart(SHARE_MEDIA share_media) {
//        Toast.makeText(context,"onStart",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
        Toast.makeText(context,"onComplete",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
        Toast.makeText(context,"onError",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancel(SHARE_MEDIA share_media, int i) {
        Toast.makeText(context,"onCancel",Toast.LENGTH_SHORT).show();
    }
}
