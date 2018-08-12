package com.example.wwq_123.readhub.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.model.MyHandler;
import com.example.wwq_123.readhub.model.MyItemDecoration;
import com.example.wwq_123.readhub.model.bean.DataItem;
import com.example.wwq_123.readhub.model.bean.Title;
import com.example.wwq_123.readhub.presenter.MainPresenter;
import com.example.wwq_123.readhub.presenter.service.Service;

import java.io.Serializable;
import java.util.List;

public class MainFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    private static final int ADD = 1;
    private static final int UPDATE = 0;

    private int TYPE;
    private RecyclerView recyclerView;
    private View view;
    private int lastVisibleItem = 0;
    private LinearLayoutManager manager;
    private SwipeRefreshLayout refreshLayout;
    private MyRecyclerAdapter adapter;
    private MyHandler handler = new MyHandler();
    private MainPresenter presenter = new MainPresenter(handler,getContext());
    public static MainFragment newInstance(Title title,int type){
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type",type);
        bundle.putSerializable("title",title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main,container,false);
        Bundle bundle = getArguments();
        Title title = (Title) bundle.get("title");
        TYPE = bundle.getInt("type");
        Service service = presenter.initData(TYPE);     //向网络请求数据，返回服务调用回调方法
        initView();
        initRefreshLayout();
        initRecycleView(service);

        return view;
    }

    private void initView() {
        refreshLayout = view.findViewById(R.id.refreshLayout);
        recyclerView = view.findViewById(R.id.list);
    }

    private void initRefreshLayout() {
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light,
                android.R.color.holo_orange_light, android.R.color.holo_green_light);
        refreshLayout.setOnRefreshListener(this);
    }

    private void initRecycleView(Service service) {
        //接收网络数据
        service.setCallBack(new Service.CallBack() {
            @Override
            public void getData(List<DataItem> list) {
                adapter = new MyRecyclerAdapter(getContext(),list,TYPE);
                manager = new LinearLayoutManager(getContext());
                manager.setOrientation(OrientationHelper.VERTICAL);
                recyclerView.setLayoutManager(manager);
                recyclerView.addItemDecoration(new MyItemDecoration());
                recyclerView.setAdapter(adapter);
            }
        });

        //设置滚动事件
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                // 在newState为滑到底部时
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    //加载更多数据
                    adapter.getMoreData();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = manager.findLastVisibleItemPosition();
            }
        });
    }

    //下拉刷新
    @Override
    public void onRefresh() {
        // 设置可见
        refreshLayout.setRefreshing(true);
        // 重置adapter的数据源为空
        adapter.resetDatas();
        // 更新数据
        adapter.updateList();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 模拟网络加载时间，设置不可见
                refreshLayout.setRefreshing(false);
            }
        }, 1000);
    }

}
