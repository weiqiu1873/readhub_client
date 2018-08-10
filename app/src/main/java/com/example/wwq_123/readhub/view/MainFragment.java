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
import com.example.wwq_123.readhub.model.MyRecyclerAdapter;
import com.example.wwq_123.readhub.model.bean.DataItem;
import com.example.wwq_123.readhub.model.bean.Title;
import com.example.wwq_123.readhub.presenter.MainPresenter;

import java.io.Serializable;
import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


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

        initData();
        initView();
        initRefreshLayout();
        initRecycleView();
        return view;
    }

    private void initData() {
        //presenter.getContent(title,type);网络请求
       presenter.initData(TYPE);
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

    private void initRecycleView() {
        //接收网络数据
        presenter.setCallBack(new MainPresenter.CallBack() {
            @Override
            public void getData(List<? extends DataItem> data) {
                adapter = new MyRecyclerAdapter(getContext(),data,TYPE);
                manager = new LinearLayoutManager(getContext());
                manager.setOrientation(OrientationHelper.VERTICAL);
                recyclerView.setLayoutManager(manager);
                recyclerView.addItemDecoration(new MyItemDecoration());
                recyclerView.setAdapter(adapter);
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                // 在newState为滑到底部时
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    //加载更多数据
                    updateRecyclerView(ADD);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = manager.findLastVisibleItemPosition();
            }
        });
    }

    private void updateRecyclerView(int type) {
        adapter.updateList(type);
    }

    //下拉刷新
    @Override
    public void onRefresh() {
        // 设置可见
        refreshLayout.setRefreshing(true);
        // 重置adapter的数据源为空
        adapter.resetDatas();
        // 获取第第0条到第PAGE_COUNT（值为10）条的数据
        updateRecyclerView(UPDATE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 模拟网络加载时间，设置不可见
                refreshLayout.setRefreshing(false);
            }
        }, 1000);
    }

}
