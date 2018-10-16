package com.example.wwq_123.readhub.view.job;

import android.content.Context;
import android.util.Log;

import com.example.wwq_123.readhub.base.BasePresenter;
import com.example.wwq_123.readhub.model.bean.JobDataItem;
import com.example.wwq_123.readhub.net.retrofit.MySubscriber;
import com.example.wwq_123.readhub.util.DataUtil;
import com.example.wwq_123.readhub.util.TimeUtil;

import java.util.List;

public class JobPresenter extends BasePresenter<JobContract.View> implements JobContract.Presenter {

    private String lastCursor = "";
    public JobPresenter(JobContract.View view,Context context){
        attachView(view);
    }

    @Override
    public void getJobData() {
        addSubscription(api.getJobData("",30)
                        .map((jobData)->DataUtil.extractJob(jobData))
                ,new MySubscriber<List<JobDataItem>>(){
                    @Override
                    public void onNext(List<JobDataItem> jobDataItems) {
                        lastCursor = TimeUtil.UTCTOTimestamp(jobDataItems.get(jobDataItems.size()-1).getPublishDate());
                        view.showJobData(jobDataItems);
                    }
                });
    }

    @Override
    public void getMoreJobData() {
        addSubscription(api.getJobData(lastCursor,10)
                .map((jobData -> DataUtil.extractJob(jobData)))
                ,new MySubscriber<List<JobDataItem>>(){
                    @Override
                    public void onNext(List<JobDataItem> jobDataItems) {
                        lastCursor = TimeUtil.UTCTOTimestamp(jobDataItems.get(jobDataItems.size()-1).getPublishDate());
                        view.showMoreJobData(jobDataItems);
                    }
                });
    }
}
