package com.example.wwq_123.readhub.presenter.service;

import com.example.wwq_123.readhub.model.bean.DataItem;
import com.example.wwq_123.readhub.model.retrofit.API;
import com.example.wwq_123.readhub.model.retrofit.APIInterface;
import com.example.wwq_123.readhub.model.retrofit.bean.Data;
import com.example.wwq_123.readhub.model.retrofit.bean.TechData;
import com.example.wwq_123.readhub.util.DataUtil;
import com.example.wwq_123.readhub.util.TimeUtil;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TechService extends Service{


    public void initData(){
        APIInterface service = API.getService();
        Observable<TechData> observable = service.getTechsData(null,10);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TechData>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onNext(TechData techData) {
                        DataUtil util = new DataUtil();
                        List<DataItem> list = util.extractTech(techData);
                        callBack.getData(list);
                    }
                });
    }

    @Override
    public void addData(DataItem item) {

        APIInterface service = API.getService();
        Observable<TechData> observable = service.getTechsData(TimeUtil.UTCTOTimestamp(item.getPublishDate()),10);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TechData>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onNext(TechData techData) {
                        DataUtil util = new DataUtil();
                        List<DataItem> list = util.extractTech(techData);
                        callBack.getData(list);
                    }
                });
    }

    public void setCallBack(CallBack callBack) {
        super.setCallBack(callBack);
    }
}
