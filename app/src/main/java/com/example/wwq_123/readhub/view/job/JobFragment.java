package com.example.wwq_123.readhub.view.job;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.base.BaseFragment;
import com.example.wwq_123.readhub.model.bean.JobDataItem;
import java.util.List;

public class JobFragment extends BaseFragment<JobPresenter> implements JobContract.View {

    private RecyclerView jobList;
    private JobAdaptrer adapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_job;
    }

    @Override
    public void initView(View view) {
        jobList = view.findViewById(R.id.job_list);
        adapter = new JobAdaptrer(getActivity());
        jobList.setAdapter(adapter);
        jobList.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void initData() {
        if (presenter==null){
            presenter = new JobPresenter(this,getActivity());
        }
        presenter.getJobData();
    }

    @Override
    public void initEvent() {
        jobList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState==RecyclerView.SCROLL_STATE_SETTLING){
                    if (!recyclerView.canScrollVertically(1)){
//                        presenter.getMoreJobData();
                        Toast.makeText(getActivity(),"无更多数据",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void showJobData(List<JobDataItem> jobDataItems) {
        adapter.updateJobList(jobDataItems);
    }

    @Override
    public void showMoreJobData(List<JobDataItem> jobDataItems) {
        adapter.addJobList(jobDataItems);
    }
}
