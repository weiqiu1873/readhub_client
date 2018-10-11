package com.example.wwq_123.readhub.view.topic;

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
    private MyLoadingView loadingView;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_topic;
    }

    @Override
    public void initView(View view) {
        loadingView = new MyLoadingView(getContext());
        loadingView.start();
        refreshLayout = view.findViewById(R.id.refresh_topic);
        recyclerView = view.findViewById(R.id.topic_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new TopicAdapter(getActivity());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initData() {
        if (presenter==null){
            presenter = new TopicPresenter(this);
        }
        presenter.getTopic();
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void initEvent() {
        refreshLayout.setOnRefreshListener(this);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    presenter.getMoreTopic();
                }
            }
        });
    }

    @Override
    public void showTopicData( List<TopicDataItem> topicList) {
        if (loadingView.isRun()){
            loadingView.stop();
        }
        adapter.updateTopic(topicList);
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showMoreTopicData(List<TopicDataItem> topicList) {
        adapter.addTopic(topicList);
    }

    @Override
    public void showLatestTopicData(List<TopicDataItem> topicList) {
        refreshLayout.setRefreshing(false);
        if (null==topicList||topicList.size()==0){
            Toast.makeText(getActivity(),"已是最新数据",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getActivity(),"更新成功",Toast.LENGTH_SHORT).show();
            adapter.updateTopic(topicList);
        }
    }

    @Override
    public void onRefresh() {
        presenter.getLatestTopic();
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void showFailed() {
        Toast.makeText(getActivity(),"数据获取失败",Toast.LENGTH_SHORT).show();
    }

}
