package com.example.wwq_123.readhub.presenter.service;

import com.example.wwq_123.readhub.model.bean.DataItem;
import com.example.wwq_123.readhub.model.bean.JobDataItem;
import com.example.wwq_123.readhub.model.retrofit.API;
import com.example.wwq_123.readhub.model.retrofit.APIInterface;
import com.example.wwq_123.readhub.model.retrofit.bean.Data;
import com.example.wwq_123.readhub.model.retrofit.bean.JobData;
import com.example.wwq_123.readhub.util.DataUtil;
import com.example.wwq_123.readhub.util.TimeUtil;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class JobService extends Service{


    public void initData(){
        APIInterface service = API.getService();
        Observable<JobData> observable = service.getJobData(null,20);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JobData>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onNext(JobData jobData) {
                        DataUtil util = new DataUtil();
                        List<DataItem> list = util.extractJob(jobData);
                        callBack.getData(list);
                    }
                });
    }

    @Override
    public void addData(DataItem item) {
        JobDataItem data = (JobDataItem) item;
        APIInterface service = API.getService();
        System.out.println(item.toString());
        Observable<JobData> observable = service.getJobData(TimeUtil.UTCTOTimestamp(data.getPublishDate()),10);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JobData>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onNext(JobData jobData) {
                        DataUtil util = new DataUtil();
                        List<DataItem> list = util.extractJob(jobData);
                        callBack.getData(list);
                    }
                });
    }

    public void setCallBack(CallBack callBack) {
        super.setCallBack(callBack);
    }
}
