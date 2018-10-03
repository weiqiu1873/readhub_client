package com.example.wwq_123.readhub.view.collect;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.base.BaseActivity;
import com.example.wwq_123.readhub.eventbus.Event;
import com.example.wwq_123.readhub.model.bean.CommonDataItem;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;
import com.example.wwq_123.readhub.view.custom_ui.TitleBar;
import com.example.wwq_123.readhub.view.news.common.CommonAdapter;
import com.example.wwq_123.readhub.view.topic.TopicAdapter;
import com.example.wwq_123.readhub.view.topic.TopicContract;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class CollectActivity extends BaseActivity<CollectPresenter> implements CollectContract.View{
    private TitleBar titleBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private RecyclerView topicRecycler;
    private RecyclerView newsRecycler;
    private TopicAdapter topicAdapter;
    private CommonAdapter commonAdapter;
    private List<View> viewList = new ArrayList<>();
    private String[] tabTitle= {"热门","资讯"};

    @Override
    public int getLayoutId() {
        return R.layout.activity_collect;
    }

    @Override
    public void initView() {
        titleBar = findViewById(R.id.collect_title);
        tabLayout = findViewById(R.id.collect_tablayout);
        viewPager = findViewById(R.id.collect_viewpager);
        initRecycler();
        viewList.add(topicRecycler);
        viewList.add(newsRecycler);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new CollectPagerAdapter());
    }

    private void initRecycler() {
        topicAdapter = new TopicAdapter(this);
        commonAdapter = new CommonAdapter(this);
        topicRecycler = new RecyclerView(this);
        newsRecycler = new RecyclerView(this);
        topicRecycler.setAdapter(topicAdapter);
        newsRecycler.setAdapter(commonAdapter);
        topicRecycler.setLayoutManager(new LinearLayoutManager(this));
        newsRecycler.setLayoutManager(new LinearLayoutManager(this));
        topicAdapter.showDelete(true);
        commonAdapter.showDelete(true);
    }

    @Override
    public void initData() {
        EventBus.getDefault().register(this);
        if (presenter==null){
            presenter = new CollectPresenter(this,this);
        }
        presenter.getTopic();
    }

    @Override
    public void initTitleBar() {
        titleBar.setTitle("收藏");
        titleBar.setLeftImage(R.drawable.ic_common_back);
        titleBar.setListener((v)->onBackPressed());
    }

    @Override
    public void initEvent() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        presenter.getTopic();
                        break;
                    case 1:
                        presenter.getNews();
                        break;
                    default:break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateTopic(Event.Topic topic){
        topicAdapter.remove(topic.item);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateNews(Event.News news){
        commonAdapter.remove(news.item);
    }

    @Override
    public void showTopic(List<TopicDataItem> topicList) {
        if (topicList==null||topicList.size()==0){
            Toast.makeText(this,"收藏夹为空",Toast.LENGTH_SHORT).show();
        }else {
            topicAdapter.updateTopic(topicList);
        }

    }

    @Override
    public void showNews(List<CommonDataItem> newsList) {
        if (newsList==null||newsList.size()==0){
            Toast.makeText(this,"收藏夹为空",Toast.LENGTH_SHORT).show();
        }else {
            commonAdapter.updateData(newsList);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    class CollectPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return viewList.size();
        }
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(viewList.get(position));
        }
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            Log.d("container",container.toString());
            Log.d("viewList",viewList.toString());
            container.addView(viewList.get(position));
            return viewList.get(position);
        }
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitle[position];
        }
    }

}
