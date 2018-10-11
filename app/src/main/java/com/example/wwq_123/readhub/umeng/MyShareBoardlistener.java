package com.example.wwq_123.readhub.umeng;

import android.app.Activity;
import android.content.Context;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.model.bean.BaseDataItem;
import com.example.wwq_123.readhub.model.bean.CommonDataItem;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;
import com.example.wwq_123.readhub.util.PermissionsUtil;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.ShareBoardConfig;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

public class MyShareBoardlistener implements ShareBoardlistener {

    private Context context;
    private BaseDataItem item;
    private MyShareAction shareAction;
    public MyShareBoardlistener(Context context, BaseDataItem item){
        this.context = context;
        this.item = item;
    }
    @Override
    public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
        if (shareAction==null){
            shareAction = MyShareAction.getAction(context,share_media);
        }
        checkPremission();
//        shareAction.setImage(R.drawable.ic_flying_pig);
        if (item instanceof TopicDataItem){
            shareAction.withText(((TopicDataItem)item).getTitle())
            .withMedia(new UMImage(context,R.drawable.ic_flying_pig));
        }else {
            shareAction.setWeb((CommonDataItem)item);
        }
    }

    //手机存储权限判断
    private void checkPremission(){
        PermissionsUtil util = PermissionsUtil.getInstance(context);
        if (!util.hasStoragePermission()){
            util.getStoragePermission();
        }
    }

}
