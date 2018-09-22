package com.example.wwq_123.readhub.umeng;

import android.app.Activity;
import android.content.Context;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.bean.SHARE_MEDIA;

public class MyShareAction extends ShareAction {
    private Context context;
    public MyShareAction(Activity activity) {
        super(activity);
        this.context = activity;
    }

    public ShareAction getAction(SHARE_MEDIA share_media){
        ShareAction shareAction = new ShareAction((Activity) context);
        shareAction.setPlatform(share_media)
                .setCallback(new MyUMShareListener(context))
                .share();
        return shareAction;
    }
}
