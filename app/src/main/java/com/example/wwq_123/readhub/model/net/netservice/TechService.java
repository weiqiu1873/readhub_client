package com.example.wwq_123.readhub.model.net.netservice;

import com.example.wwq_123.readhub.model.Model;
import com.example.wwq_123.readhub.model.bean.DataItem;
import com.example.wwq_123.readhub.model.net.retrofit.API;
import com.example.wwq_123.readhub.model.net.retrofit.APIInterface;
import com.example.wwq_123.readhub.model.jsonbean.TechData;
import com.example.wwq_123.readhub.util.DataUtil;
import com.example.wwq_123.readhub.util.TimeUtil;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TechService implements Service{

    @Override
    public void getData(Model.GetDataCallBack callBack){
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
                        callBack.DataCallBack(list);
                    }
                });
    }

    @Override
    public void getMoreData(Model.GetMoreDataCallBack callBack ,DataItem item) {

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
                        callBack.DataCallBack(list);
                    }
                });
    }

}
