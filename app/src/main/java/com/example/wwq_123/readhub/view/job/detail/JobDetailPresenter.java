package com.example.wwq_123.readhub.view.job.detail;

import com.example.wwq_123.readhub.base.BasePresenter;
import com.example.wwq_123.readhub.model.jsonbean.Chart;
import com.example.wwq_123.readhub.net.retrofit.MySubscriber;

public class JobDetailPresenter extends BasePresenter<JobDetailContract.View> implements JobDetailContract.Presenter {

    public JobDetailPresenter(JobDetailContract.View view){
        attachView(view);
    }
    @Override
    public void getChart(String id) {
        addSubscription(api.getChart(id)
                ,new MySubscriber<Chart>(){
            @Override
            public void onNext(Chart chart) {
                view.showChart(chart);
            }
        });
    }
}
