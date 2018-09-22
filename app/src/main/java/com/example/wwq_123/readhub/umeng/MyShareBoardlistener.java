package com.example.wwq_123.readhub.umeng;

import android.app.Activity;
import android.content.Context;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.model.bean.BaseDataItem;
import com.example.wwq_123.readhub.model.bean.CommonDataItem;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

public class MyShareBoardlistener implements ShareBoardlistener {

    private Context context;
    private BaseDataItem item;
    public MyShareBoardlistener(Context context, BaseDataItem item){
        this.context = context;
        this.item = item;
    }
    @Override
    public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
        ShareAction shareAction = new MyShareAction((Activity) context).getAction(share_media);

        if (share_media==SHARE_MEDIA.QQ||share_media==SHARE_MEDIA.QZONE){
            shareAction.withMedia(new UMImage(context, R.drawable.ic_flying_pig));
        }
        if (share_media==SHARE_MEDIA.WEIXIN||share_media==SHARE_MEDIA.WEIXIN_CIRCLE){
            if (item instanceof TopicDataItem){
                TopicDataItem topic = (TopicDataItem) item;
                shareAction.withText(topic.getTitle());
            }else {
                CommonDataItem common = (CommonDataItem) item;
                shareAction.withText(common.getTitle());
            }

        }
    }
}
