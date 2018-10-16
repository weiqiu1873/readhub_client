package com.example.wwq_123.readhub.umeng;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.model.bean.BaseDataItem;
import com.example.wwq_123.readhub.model.bean.CommonDataItem;
import com.example.wwq_123.readhub.model.bean.JobArrayBean;
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

    public UMWeb setWeb(TopicDataItem item){
        UMWeb web = new UMWeb("https://readhub.cn/topic/"+((TopicDataItem) item).getUrl());
        web.setTitle(item.getTitle());
        web.setDescription(item.getSummary());
        return web;
    }
    public UMWeb setWeb(CommonDataItem item){
        UMWeb web = new UMWeb(item.getMobileUrl());
        web.setTitle(item.getTitle());
        web.setDescription(item.getSummary());
        return web;
    }
    public UMWeb setWeb(JobArrayBean bean){
        UMWeb web = new UMWeb(bean.getUrl());
        web.setTitle(bean.getTitle());
        web.setDescription(bean.getCompany());
        return web;
    }
}
