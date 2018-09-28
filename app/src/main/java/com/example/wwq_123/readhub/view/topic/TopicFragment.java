package com.example.wwq_123.readhub.view.topic;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.base.BaseFragment;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;
import com.example.wwq_123.readhub.view.custom_ui.MyLoadingView;

import java.util.List;

public class TopicFragment extends BaseFragment<TopicPresenter> implements TopicContract.View,SwipeRefreshLayout.OnRefreshListener{

    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private TopicAdapter adapter;
    private String lastOrder = "";
    private MyLoadingView loadingView;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_topic;
    }

    @Override
    public void initView(View view) {
        loadingView = new MyLoadingView(getContext());
        loadingView.start();
        initRecycleView(view);
        initRefreshLayotu(view);
    }

    private void initRefreshLayotu(View view) {
        refreshLayout = view.findViewById(R.id.refresh_topic);
        refreshLayout.setOnRefreshListener(this);
    }

    private void initRecycleView(View view) {
        recyclerView = view.findViewById(R.id.topic_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new TopicAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    presenter.getMoreTopic(lastOrder);
                }
            }
        });
    }

    @Override
    public void initData() {
        if (presenter==null){
            presenter = new TopicPresenter(this);
        }
        presenter.getTopic();
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void showTopicData( List<TopicDataItem> topicList) {
        if (loadingView.isRun()){
            loadingView.stop();
        }
        String order = String.valueOf(topicList.get(topicList.size()-1).getOrder());
        if (order.equals(lastOrder)){
            Toast.makeText(getActivity(),"已是最新数据",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getActivity(),"更新成功",Toast.LENGTH_SHORT).show();
            adapter.updateTopic(topicList);
            lastOrder = order;
        }
    }

    @Override
    public void showMoreTopicData(List<TopicDataItem> topicList) {
        adapter.addTopic(topicList);
        lastOrder = String.valueOf(topicList.get(topicList.size()-1).getOrder());
    }

    @Override
    public void onRefresh() {
        presenter.getTopic();
        refreshLayout.setRefreshing(true);
        new Handler().postDelayed(()->refreshLayout.setRefreshing(false), 1000);
    }

    @Override
    public void showSuccess() {
        Toast.makeText(getActivity(),"数据获取成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailed() {
        Toast.makeText(getActivity(),"数据获取失败",Toast.LENGTH_SHORT).show();
    }

}
