package com.example.wwq_123.readhub.mvc.view;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.mvc.model.bean.Title;
import com.example.wwq_123.readhub.mvc.presenter.MainActivityPresenter;

import java.util.List;


public class MainActivity extends AppCompatActivity implements Display.TabTitle,TabLayout.OnTabSelectedListener{

    private static final String TAG = "MainActivity";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyAdapter adapter;
    private MyDialog  dialog;
    private MainActivityPresenter mainPresenter = new MainActivityPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainPresenter.loadTabTitle();
        setContentView(R.layout.activity_main);
        initLoading();
        initView();
        tabLayout.addOnTabSelectedListener(this);
    }

    private void initLoading() {
       dialog = MyDialog.showDialog(MainActivity.this);
       dialog.show();
    }


    private void initView() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
    }

    @Override
    public void initTitle(List<Title> titles) {
        dialog.cancel();
        adapter = new MyAdapter(getSupportFragmentManager(),titles);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0,false);
        tabLayout.setupWithViewPager(viewPager);
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
