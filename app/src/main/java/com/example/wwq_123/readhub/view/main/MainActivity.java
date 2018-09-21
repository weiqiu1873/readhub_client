package com.example.wwq_123.readhub.view.main;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.base.BaseActivity;
import com.example.wwq_123.readhub.db.PreferencesUtil;
import com.example.wwq_123.readhub.util.ImageUtil;
import com.example.wwq_123.readhub.view.collect.CollectActivity;
import com.example.wwq_123.readhub.view.custom_ui.CircleImageView;
import com.example.wwq_123.readhub.view.custom_ui.TitleBar;
import com.example.wwq_123.readhub.view.job.JobFragment;
import com.example.wwq_123.readhub.view.news.NewsFragment;
import com.example.wwq_123.readhub.view.topic.TopicFragment;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View{

    private static final String TAG = "MainActivity";
    private DrawerLayout drawerLayout;
    private TitleBar titleBar;
    private RadioGroup rg_tab;
    private RadioButton rg_tab_topic;
    private RadioButton rg_tab_news;
    private RadioButton rg_tab_job;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private NavigationView navigationView;
    private LinearLayout header_layout;
    private CircleImageView user_image;
    private TextView user_name;
    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    private TopicFragment topicFragment;
    private NewsFragment newsFragment;
    private JobFragment jobFragment;

    private MainPresenter presenter;

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
    }

    @Override
    public void initTitleBar() {
        titleBar.setTitle("Readhub");
        titleBar.setLeftImage(R.drawable.main_menu);
        titleBar.setListener((v)->{
            presenter.setNagivation();
            drawerLayout.openDrawer(Gravity.LEFT);
        });
    }

    @Override
    public void initEvent() {
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
        navigationView.setNavigationItemSelectedListener((item)->{
            switch (item.getItemId()){
                case R.id.collect:
                    Intent intent = new Intent(MainActivity.this, CollectActivity.class);
                    startActivity(intent);
                    break;
            }
            drawerLayout.closeDrawer(Gravity.LEFT);
            return true;
        });
    }


    @Override
    public void initView() {
        initFragment();
        initNavigation();
        drawerLayout = findViewById(R.id.drawer_layout);
        titleBar = findViewById(R.id.main_title);
        viewPager = findViewById(R.id.viewPager);
        rg_tab = findViewById(R.id.rg_tab);
        rg_tab_topic = findViewById(R.id.rg_tab_topic);
        rg_tab_news = findViewById(R.id.rg_tab_news);
        rg_tab_job = findViewById(R.id.rg_tab_job);
    }

    private void initNavigation() {
        navigationView = findViewById(R.id.navigation_view);
        header_layout = (LinearLayout) navigationView.getHeaderView(0);
        user_image = header_layout.findViewById(R.id.user_image);
        user_name = header_layout.findViewById(R.id.user_name);
        presenter = new MainPresenter(this,this);
    }

    @Override
    public void showNagivation(String name,boolean isListen) {
        user_name.setText(name);
        if (isListen){
            user_name.setOnClickListener((v)->{
                presenter.loginByQQ();
            });
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }


}