package com.example.wwq_123.readhub.view.news;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.base.BaseFragment;
import com.example.wwq_123.readhub.view.news.common.CommonFragment;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends BaseFragment{

    private TabLayout news_tab_layout;
    private ViewPager news_viewpager;
    private List<CommonFragment> fragments = new ArrayList<>();
    private NewsViewPagerAdapter adapter;
    private String[] tabTitle = {"科技资讯","开发者资讯","区块链资讯"};

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView(View view) {
        news_tab_layout = view.findViewById(R.id.news_tablayout);
        news_viewpager = view.findViewById(R.id.news_viewpager);
        adapter = new NewsViewPagerAdapter(getChildFragmentManager());
        news_viewpager.setAdapter(adapter);
        news_viewpager.setCurrentItem(0);
        news_tab_layout.setupWithViewPager(news_viewpager);
    }

    @Override
    protected void initData() {
        for (int i=0;i<3;i++){
            CommonFragment fragment = CommonFragment.newInstance(i);
            fragments.add(fragment);
        }
    }

    class NewsViewPagerAdapter extends FragmentPagerAdapter {

        public NewsViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitle[position];
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return tabTitle.length;
        }
    }
}
