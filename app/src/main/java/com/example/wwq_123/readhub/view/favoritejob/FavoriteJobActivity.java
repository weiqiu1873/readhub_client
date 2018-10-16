package com.example.wwq_123.readhub.view.favoritejob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.base.BaseActivity;
import com.example.wwq_123.readhub.eventbus.Event;
import com.example.wwq_123.readhub.model.bean.JobArrayBean;
import com.example.wwq_123.readhub.view.custom_ui.MyItemDecoration;
import com.example.wwq_123.readhub.view.custom_ui.TitleBar;
import com.example.wwq_123.readhub.view.job.detail.JobDetailActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class FavoriteJobActivity extends BaseActivity<FavoriteJobPresenter> implements FavoriteJobContract.View{

    private TitleBar titleBar;
    private RecyclerView jobList;
    private FavoriteJobAdapter adapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_favorite_job;
    }

    @Override
    public void initView() {
        titleBar = findViewById(R.id.favorite_job_title);
        jobList = findViewById(R.id.favorite_job_list);
        initRecycleView();

    }

    private void initRecycleView() {
        adapter = new FavoriteJobAdapter(this);
        adapter.setShowdelete(true);
        jobList.setAdapter(adapter);
        jobList.setLayoutManager(new LinearLayoutManager(this));
        MyItemDecoration itemDecoration = new MyItemDecoration().setTop(10).setBottom(10);
        jobList.addItemDecoration(itemDecoration);
    }

    @Override
    public void initTitleBar() {
        titleBar.setTitle("喜爱职位");
        titleBar.setLeftImage(R.drawable.ic_common_back);
        titleBar.setListener((v)->onBackPressed());
    }

    @Override
    public void initData() {
        if (presenter==null){
            presenter = new FavoriteJobPresenter(this,this);
        }
        presenter.getJob();
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void showJob(List<JobArrayBean> list) {
        adapter.setList(list);
    }

    @Subscribe
    public void cancleCollect(Event.Job job){
        adapter.delete(job.bean);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
