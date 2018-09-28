package com.example.wwq_123.readhub.view.news.common;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.base.BaseFragment;
import com.example.wwq_123.readhub.model.bean.CommonDataItem;
import java.util.List;

public class CommonFragment extends BaseFragment<CommonPresenter> implements CommonContract.View,SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout news_common_refresh;
    private RecyclerView news_common_list;
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
        news_common_refresh = view.findViewById(R.id.refresh_news_common);
        news_common_list = view.findViewById(R.id.news_common_list);
        news_common_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CommonAdapter(getActivity());
        news_common_list.setAdapter(adapter);
    }

    @Override
    public void initData() {
        if (presenter==null){
            presenter = new CommonPresenter(this);
        }
        switch (currentPosition){
            case 0:
                presenter.getTechNews();
                break;
            case 1:
                presenter.getDevelopNews();
                break;
            case 2:
                presenter.getBlockchainNews();
                break;
            default:break;
        }
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void showTechNews(List<CommonDataItem> list) {
        adapter.updateData(list);
    }

    @Override
    public void showDeveloperNews(List<CommonDataItem> list) {
        adapter.updateData(list);
    }

    @Override
    public void showBlockchainNews(List<CommonDataItem> list) {
        adapter.updateData(list);
    }

    @Override
    public void onRefresh() {
        switch (currentPosition){
            case 0:
                presenter.getTechNews();
                break;
            case 1:
                presenter.getDevelopNews();
                break;
            case 2:
                presenter.getBlockchainNews();
                break;
            default:break;
        }
        news_common_refresh.setRefreshing(true);
        new Handler().postDelayed(()->news_common_refresh.setRefreshing(false),1000);
    }
}
