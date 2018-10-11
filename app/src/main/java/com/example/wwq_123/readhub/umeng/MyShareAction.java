package com.example.wwq_123.readhub.umeng;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.model.bean.BaseDataItem;
import com.example.wwq_123.readhub.model.bean.CommonDataItem;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

public class MyShareAction extends ShareAction {
    private Context context;
    public MyShareAction(Activity activity) {
        super(activity);
        this.context = activity;
    }

    public static MyShareAction getAction(Context context,SHARE_MEDIA share_media){
        MyShareAction shareAction = new MyShareAction((Activity) context);
        shareAction.setPlatform(share_media)
                .setCallback(new MyUMShareListener(context))
                .share();
        return shareAction;
    }
    public MyShareAction setImage(int drawable){
        UMImage image = new UMImage(context,drawable);
        this.withMedia(image);
        return this;
    }
    public MyShareAction setWeb(CommonDataItem item){
        UMWeb web = new UMWeb(item.getMobileUrl());
        web.setTitle(item.getTitle());
        web.setDescription(item.getSummaryAuto());
        web.setThumb(new UMImage(context,R.drawable.ic_flying_pig));
        this.withMedia(web);
        return this;
    }


}
