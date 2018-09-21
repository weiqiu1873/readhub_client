package com.example.wwq_123.readhub.view.topic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.db.TopicDB;
import com.example.wwq_123.readhub.eventbus.Event;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;
import com.example.wwq_123.readhub.view.topic.detail.TopicDetailActivity;
import com.example.wwq_123.readhub.util.TimeUtil;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

import org.greenrobot.eventbus.EventBus;

public class TopicViewHolder extends RecyclerView.ViewHolder {
    private TopicDB topicDB;
    boolean collectStatus = false;
    CardView topicCardView;
    TextView tvTopicTime;
    TextView tvTopicTitle;
    TextView tvTopicSummary;
    TextView tvNewsOne;
    TextView tvNewsTwo;
    ImageButton tvDelete;
    ImageButton tvCollect;
    ImageButton tvShare;
    private Context context;

    public TopicViewHolder(Context context,View itemView) {
        super(itemView);
        this.context = context;
        topicDB = new TopicDB(context);
        topicCardView = itemView.findViewById(R.id.topic_card_view);
        tvTopicTime = itemView.findViewById(R.id.tv_topic_time);
        tvTopicTitle = itemView.findViewById(R.id.tv_topic_title);
        tvTopicSummary = itemView.findViewById(R.id.tv_topic_summary);
        tvNewsOne = itemView.findViewById(R.id.tv_news_one);
        tvNewsTwo = itemView.findViewById(R.id.tv_news_two);
        tvDelete = itemView.findViewById(R.id.tv_topic_delete);
        tvCollect = itemView.findViewById(R.id.tv_topic_collect);
        tvShare = itemView.findViewById(R.id.tv_topic_share);
    }

    public void showDelete(){
        tvDelete.setVisibility(View.VISIBLE);
        tvCollect.setVisibility(View.GONE);
    }

    public void onBind(TopicDataItem item){
        if (item.getPublishDate()!=null){
            tvTopicTime.setText(TimeUtil.TimeDifference(item.getPublishDate()));
        }else {
            tvTopicTime.setText(TimeUtil.TimeDifference(item.getCreatedAt()));
        }
        tvTopicTitle.setText(item.getTitle());
        tvTopicSummary.setText(item.getSummary());

        topicCardView.setOnClickListener((v)-> {
            Intent intent = new Intent(context, TopicDetailActivity.class);
            intent.putExtra("url",item.getUrl());
            context.startActivity(intent);
        });
        tvDelete.setOnClickListener((v)->{
            Toast.makeText(context,"取消收藏",Toast.LENGTH_SHORT).show();
            collectStatus = false;
            topicDB.delete(item);
            Event.Topic event = new Event.Topic();
            event.item = item;
            EventBus.getDefault().post(event);
        });
        tvShare.setOnClickListener((v) ->{
            UMShareListener listener = new UMShareListener() {
                @Override
                public void onStart(SHARE_MEDIA share_media) {

                }
                @Override
                public void onResult(SHARE_MEDIA share_media) {
                    Toast.makeText(context,"成功了",Toast.LENGTH_LONG).show();
                }
                @Override
                public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                    Toast.makeText(context,"失败"+throwable.getMessage(),Toast.LENGTH_LONG).show();
                }
                @Override
                public void onCancel(SHARE_MEDIA share_media) {
                    Toast.makeText(context,"取消了",Toast.LENGTH_LONG).show();
                }
            };
            ShareBoardlistener boardlistener = ((snaPlatform,share_media)->{
                if (share_media==SHARE_MEDIA.QQ||share_media==SHARE_MEDIA.QZONE){
                    new ShareAction((Activity) context)
                            .setPlatform(share_media)
                            .setCallback(listener)
                            .withMedia(new UMImage(context,R.drawable.ic_flying_pig))
                            .share();
                }
                if (share_media==SHARE_MEDIA.WEIXIN||share_media==SHARE_MEDIA.WEIXIN_CIRCLE){
                    new ShareAction((Activity) context)
                            .setPlatform(share_media)
                            .setCallback(listener)
                            .withText(item.getTitle())
                            .withSubject("资讯:")
                            .share();
                }
            });
            new ShareAction((Activity) context)
                    .setDisplayList(SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.SINA,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN_CIRCLE)
                    .setShareboardclickCallback(boardlistener)
                    .open();
        });
        tvCollect.setOnClickListener((v) ->{
                if (collectStatus){
                    Toast.makeText(context,"取消收藏",Toast.LENGTH_SHORT).show();
//                    tvCollect.setImageResource(R.mipmap.collect);
                    collectStatus = false;
                    topicDB.delete(item);
                }else {
                    Toast.makeText(context,"收藏成功",Toast.LENGTH_SHORT).show();
//                    tvCollect.setImageResource(R.mipmap.collect_press);
                    collectStatus = true;
                    topicDB.insert(item);
                }
        });
    }


}
