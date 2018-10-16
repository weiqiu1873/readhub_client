package com.example.wwq_123.readhub.view.news.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.base.BaseFragment;
import com.example.wwq_123.readhub.eventbus.Event;
import com.example.wwq_123.readhub.model.bean.CommonDataItem;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class CommonFragment extends BaseFragment<CommonPresenter> implements CommonContract.View,SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout refreshLayout;
    private RecyclerView newsList;
    private CommonAdapter adapter;
    private int currentPosition = 0;

    public static CommonFragment newInstance(int position){
        CommonFragment fragment = new CommonFragment();
        fragment.currentPosition = position;
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news_common;
    }

    @Override
    public void initView(View view) {
        refreshLayout = view.findViewById(R.id.refresh_news_common);
        newsList = view.findViewById(R.id.news_common_list);
        newsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CommonAdapter(getActivity());
        newsList.setAdapter(adapter);
    }

    @Override
    public void initData() {
        if (presenter==null){
            presenter = new CommonPresenter(this);
        }
        presenter.getNews(currentPosition);
    }

    @Override
    public void initEvent() {
        refreshLayout.setOnRefreshListener(this);
        newsList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState==RecyclerView.SCROLL_STATE_SETTLING){
                    if (!recyclerView.canScrollVertically(1)){
                        presenter.getMoreNews(currentPosition);
                    }
                }
            }
        });
    }

    @Override
    public void showNews(List<CommonDataItem> list) {
        adapter.updateData(list);
    }

    @Override
    public void showMoreNews(List<CommonDataItem> list) {
        adapter.addData(list);
    }

    @Override
    public void showUpdateNews(List<CommonDataItem> list) {
        refreshLayout.setRefreshing(false);
        if (null==list||list.size()==0){
            Toast.makeText(getActivity(),"已是最新数据",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getActivity(),"更新成功",Toast.LENGTH_SHORT).show();
            adapter.updateData(list);
        }
    }
    @Override
    public void onRefresh() {
        presenter.updateNews(currentPosition);
        refreshLayout.setRefreshing(true);
    }

    public boolean cancleCollect(CommonDataItem item){
        int location = adapter.getViewHolderLocationForAdapter(item);
        if (location==-1){
            return false;
        }else {
            CommonViewHolder viewHolder = (CommonViewHolder) newsList.findViewHolderForAdapterPosition(location);
            viewHolder.cancleCollect();
            return true;
        }
    }
}
