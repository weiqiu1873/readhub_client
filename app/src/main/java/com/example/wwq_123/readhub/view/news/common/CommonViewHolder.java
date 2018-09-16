package com.example.wwq_123.readhub.view.news.common;

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
import com.example.wwq_123.readhub.db.NewsDB;
import com.example.wwq_123.readhub.model.jsonbean.bean.CommonDataItem;
import com.example.wwq_123.readhub.view.WebActivity;
import com.example.wwq_123.readhub.util.TimeUtil;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;


public class CommonViewHolder extends RecyclerView.ViewHolder{
    private CardView cardView;
    private TextView news_title;
    private TextView news_summary;
    private TextView news_time;
    private TextView news_author;
    private ImageButton news_collect;
    private ImageButton news_share;
    private boolean collectStatus = false;
    private NewsDB newsDB;
    private Context context;
    public CommonViewHolder(Context context, View itemView){
        super(itemView);
        this.context = context;
        cardView = itemView.findViewById(R.id.news_common_cardview);
        news_title = itemView.findViewById(R.id.news_common_item_title);
        news_summary = itemView.findViewById(R.id.news_common_item_summary);
        news_time = itemView.findViewById(R.id.news_common_item_time);
        news_author = itemView.findViewById(R.id.news_common_item_author);
        news_collect = itemView.findViewById(R.id.news_common_item_collect);
        news_share = itemView.findViewById(R.id.news_common_item_share);
    }

    public void onBind(CommonDataItem item){
        news_title.setText(item.getTitle());
        news_summary.setText(item.getSummary());
        news_time.setText(TimeUtil.TimeDifference(item.getPublishDate()));
        news_author.setText(item.getSiteName() +"/"+item.getAuthorName());
        cardView.setOnClickListener((v)->{
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("url",item.getMobileUrl());
                context.startActivity(intent);
        });
        news_collect.setOnClickListener((v)->{
            newsDB = new NewsDB(context);
            if (collectStatus){
                Toast.makeText(context,"取消收藏",Toast.LENGTH_SHORT).show();
//                news_collect.setImageResource(R.mipmap.collect);
                collectStatus = false;
                newsDB.delete(item);
            }else {
                Toast.makeText(context,"收藏成功",Toast.LENGTH_SHORT).show();
//                news_collect.setImageResource(R.mipmap.collect_press);
                collectStatus = true;
                newsDB.insert(item);
            }
        });
        news_share.setOnClickListener((v)->{
            new ShareAction((Activity) context)
                    .withText(item.getTitle())
                    .setDisplayList(SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.SINA,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN_CIRCLE)
                    .setCallback(new UMShareListener() {
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
                    }).open();
        });
    }
}
