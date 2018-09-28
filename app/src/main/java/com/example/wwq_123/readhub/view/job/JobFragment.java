package com.example.wwq_123.readhub.view.job;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

    }

    @Override
    public void showJobData(List<JobDataItem> topicList) {
        adapter.updateJobList(topicList);
    }
}
