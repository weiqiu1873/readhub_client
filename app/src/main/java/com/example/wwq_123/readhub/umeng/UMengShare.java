package com.example.wwq_123.readhub.umeng;

import android.app.Activity;
import android.content.Context;

import com.example.wwq_123.readhub.model.bean.BaseDataItem;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.bean.SHARE_MEDIA;

public class UMengShare {

    private Context context;
    public UMengShare(Context context){
        this.context = context;
    }

    public void share(BaseDataItem item){
        new ShareAction((Activity) context)
                .setDisplayList(SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN_CIRCLE)
                .setShareboardclickCallback(new MyShareBoardlistener(context,item))
                .open();
    }
}
