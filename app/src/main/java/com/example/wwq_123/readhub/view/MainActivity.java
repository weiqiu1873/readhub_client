package com.example.wwq_123.readhub.view;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wwq_123.readhub.model.MyHandler;
import com.example.wwq_123.readhub.model.Okhttp;
import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.model.bean.ContentItem;
import com.example.wwq_123.readhub.model.bean.Title;
import com.example.wwq_123.readhub.presenter.MainPresenter;
import com.example.wwq_123.readhub.util.HtmlUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    private static final String TAG = "MainActivity";
    private static final int TYPE = -1;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyHandler handler = new MyHandler();
    private MainPresenter presenter = new MainPresenter(handler,this);
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.init(TYPE);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        tabLayout.setOnTabSelectedListener(this);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {

        handler.setCallBack(new MyHandler.CallBack() {
            @Override
            public void getTitle(List<Title> titles) {
                //设置viewpager的适配器
                adapter = new MyAdapter(getSupportFragmentManager(),titles);
                viewPager.setAdapter(adapter);
                viewPager.setCurrentItem(0,false);
                tabLayout.setupWithViewPager(viewPager);
            }
        });

    }

    private void initView() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
    }

    class MyAdapter extends FragmentPagerAdapter{

        private List<Title> titleList;

        public MyAdapter(FragmentManager fm,List<Title> list) {
            super(fm);
            this.titleList = list;

        }
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position).getName();
        }

        @Override
        public Fragment getItem(int position) {
            MainFragment fragment = MainFragment.newInstance(titleList.get(position),position);
            return fragment;
        }

        @Override
        public int getCount() {
            return titleList.size();
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        //viewPager.setCurrentItem(tab.getPosition(),true);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

}
