package com.example.wwq_123.readhub.view;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.base.BaseActivity;
import com.example.wwq_123.readhub.view.job.JobFragment;
import com.example.wwq_123.readhub.view.news.NewsFragment;
import com.example.wwq_123.readhub.view.topic.TopicFragment;
import com.example.wwq_123.readhub.service.LoadingService;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    private DrawerLayout drawerLayout;
    private TextView title;
    private RadioGroup rg_tab;
    private RadioButton rg_tab_topic;
    private RadioButton rg_tab_news;
    private RadioButton rg_tab_job;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private Button drawerBtn,service;
    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    private TopicFragment topicFragment;
    private NewsFragment newsFragment;
    private JobFragment jobFragment;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    private void initFragment() {
        topicFragment = new TopicFragment();
        newsFragment = new NewsFragment();
        jobFragment = new JobFragment();
        fragments.add(topicFragment);
        fragments.add(newsFragment);
        fragments.add(jobFragment);
        titles.add("热门");
        titles.add("资讯");
        titles.add("招聘");
    }

    @Override
    public void initData() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(2);
        rg_tab_topic.setChecked(true);
        initListener();
    }

    private void initListener() {
        rg_tab.setOnCheckedChangeListener((group,checkedId)->{
            int position = 0;
            switch (checkedId){
                case R.id.rg_tab_topic:
                    position = 0;
                    break;
                case R.id.rg_tab_news:
                    position = 1;
                    break;
                case R.id.rg_tab_job:
                    position = 2;
                    break;
                default:break;
            }
            viewPager.setCurrentItem(position);
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        rg_tab_topic.setChecked(true);
                        break;
                    case 1:
                        rg_tab_news.setChecked(true);
                        break;
                    case 2:
                        rg_tab_job.setChecked(true);
                        break;
                        default:break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) { }
        });
    }

    @Override
    public void initView() {
        initFragment();
        drawerLayout = findViewById(R.id.drawer_layout);
        title = findViewById(R.id.title_text);
        viewPager = findViewById(R.id.viewPager);
        rg_tab = findViewById(R.id.rg_tab);
        rg_tab_topic = findViewById(R.id.rg_tab_topic);
        rg_tab_news = findViewById(R.id.rg_tab_news);
        rg_tab_job = findViewById(R.id.rg_tab_job);
        service = findViewById(R.id.service);
        drawerBtn = findViewById(R.id.drawerBtn);
        service.setOnClickListener(this);
        drawerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.service:
                Intent intent = new Intent(this, LoadingService.class);
                startService(intent);
                Toast.makeText(MainActivity.this,"click",Toast.LENGTH_SHORT).show();
                break;
            case R.id.drawerBtn:
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
                default:break;
        }
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{

        public ViewPagerAdapter(FragmentManager fm) { super(fm); }

        @Override
        public Fragment getItem(int position) { return fragments.get(position); }

        @Override
        public int getCount() { return fragments.size(); }
    }

    private long exitTime = 0;
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)){
            drawerLayout.closeDrawer(Gravity.LEFT);
        }else {
            if ((System.currentTimeMillis() - exitTime) > 1000) {
                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
        }
    }

}
