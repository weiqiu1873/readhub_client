package com.example.wwq_123.readhub.model.net.netservice;

import com.example.wwq_123.readhub.model.Model;
import com.example.wwq_123.readhub.model.bean.DataItem;
import com.example.wwq_123.readhub.model.bean.JobDataItem;
import com.example.wwq_123.readhub.model.net.retrofit.API;
import com.example.wwq_123.readhub.model.net.retrofit.APIInterface;
import com.example.wwq_123.readhub.model.jsonbean.JobData;
import com.example.wwq_123.readhub.util.DataUtil;
import com.example.wwq_123.readhub.util.TimeUtil;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class JobService implements Service{

    @Override
    public void getData(Model.GetDataCallBack callBack){
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
                        callBack.DataCallBack(list);
                    }
                });
    }

    @Override
    public void getMoreData(Model.GetMoreDataCallBack callBack ,DataItem item) {
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
                        callBack.DataCallBack(list);
                    }
                });
    }

}
