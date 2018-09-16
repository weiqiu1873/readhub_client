package com.example.wwq_123.readhub.view.topic.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.base.BaseActivity;
import com.example.wwq_123.readhub.model.jsonbean.bean.CommonDataItem;
import com.example.wwq_123.readhub.model.jsonbean.bean.TopicDetail;
import com.example.wwq_123.readhub.view.news.common.CommonViewHolder;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.PushAgent;

import java.util.ArrayList;
import java.util.List;

public class TopicDetailActivity extends BaseActivity implements TopicDetailContract.View {
    private ScrollView scrollView;
    private ImageButton backBtn;
    private TextView title,summary,relatedText;
    private ViewPager news_viewpager;
    private RecyclerView related_list;
    private TopicDetailPresenter presenter;
    private List<CommonDataItem> newsArray = new ArrayList<>();
    private List<TopicDetail.TimelineBean.TopicsBean> timeline = new ArrayList<>();
    private List<View> newsView = new ArrayList<>();
    private String url;
    private NewsViewPagerAdapter newsAdapter;
    private TimeLineAdapter timeLineAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UMConfigure.setLogEnabled(true);
        UMConfigure.setEncryptEnabled(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        MobclickAgent.setSessionContinueMillis(1000);
        PushAgent.getInstance(this).onAppStart();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_topic_detail;
    }

    @Override
    public void initView() {
        backBtn = findViewById(R.id.topic_detail_back_btn);
        scrollView = findViewById(R.id.topic_detail_scrollview);
        title = findViewById(R.id.topic_detail_title);
        summary = findViewById(R.id.topic_detail_summary);
        news_viewpager = findViewById(R.id.topic_detail_news_view_pager);
        relatedText = findViewById(R.id.topic_detail_related_text);
        related_list = findViewById(R.id.topic_detail_related_news_list);

        initEvent();

        newsAdapter = new NewsViewPagerAdapter();
        news_viewpager.setAdapter(newsAdapter);

        timeLineAdapter = new TimeLineAdapter();
        related_list.setAdapter(timeLineAdapter);
        related_list.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initEvent() {
        backBtn.setOnClickListener((v)-> onBackPressed());
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        if (presenter==null){
            presenter = new TopicDetailPresenter(this);
        }
        presenter.getTopicDetail(url);
    }

    @Override
    public void showTopicDetail(TopicDetail detail) {
        title.setText(detail.getTitle());
        summary.setText(detail.getSummary());
        showNewsArray(detail.getNewsArray());
        if (detail.getTimeline()!=null){
            showTimeLine(detail.getTimeline().getTopics());
        }else {
            related_list.setVisibility(View.GONE);
            relatedText.setVisibility(View.GONE);
        }
    }

    private void showTimeLine(List<TopicDetail.TimelineBean.TopicsBean> topicsList) {
        if (topicsList!=null&&topicsList.size()>0){
            timeline.addAll(topicsList);
        }
        timeLineAdapter.notifyDataSetChanged();
    }

    private void showNewsArray(List<CommonDataItem> dataList) {
        if (dataList!=null&&dataList.size()>0){
            newsArray.addAll(dataList);
            for (int i = 0,count = dataList.size();i<count;i++){
                View view = LayoutInflater.from(this).inflate(R.layout.item_common,null);
                newsView.add(view);
            }
        }else {
            news_viewpager.setVisibility(View.GONE);
        }
        newsAdapter.notifyDataSetChanged();
    }


    class NewsViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return newsView.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(newsView.get(position));
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            CommonViewHolder holder = new CommonViewHolder(TopicDetailActivity.this,newsView.get(position));
            holder.onBind(newsArray.get(position));
            container.addView(newsView.get(position));
            return newsView.get(position);
        }
    }

    class TimeLineAdapter extends RecyclerView.Adapter{

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(TopicDetailActivity.this).inflate(R.layout.item_timeline,parent,false);
            return new TimeLineViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ((TimeLineViewHolder)holder).onBind(timeline.get(position));
        }

        @Override
        public int getItemCount() {
            return timeline.size();
        }
    }

    private class TimeLineViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        public TimeLineViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.timeline_item_title);
        }
        public void onBind(TopicDetail.TimelineBean.TopicsBean bean){
            title.setText(bean.getTitle());
        }
    }
}
