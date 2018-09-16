package com.example.wwq_123.readhub.view.job;

import android.content.Context;
import com.example.wwq_123.readhub.base.BasePresenter;
import com.example.wwq_123.readhub.model.jsonbean.bean.JobDataItem;
import com.example.wwq_123.readhub.net.retrofit.MySubscriber;
import com.example.wwq_123.readhub.util.DataUtil;

import java.util.List;

public class JobPresenter extends BasePresenter<JobContract.View> implements JobContract.Presenter {

    public JobPresenter(JobContract.View view,Context context){
        attachView(view);
    }

    @Override
    public void getJobData() {
        addSubscription(api.getJobData("",10)
                        .map((jobData)->DataUtil.extractJob(jobData))
                ,new MySubscriber<List<JobDataItem>>(){
                    @Override
                    public void onNext(List<JobDataItem> jobDataItems) {
                        view.showJobData(jobDataItems);
                    }
                });
    }
}
