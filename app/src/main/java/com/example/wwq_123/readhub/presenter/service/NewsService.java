package com.example.wwq_123.readhub.presenter.service;

import com.example.wwq_123.readhub.model.bean.DataItem;
import com.example.wwq_123.readhub.model.bean.NewsDataItem;
import com.example.wwq_123.readhub.model.retrofit.API;
import com.example.wwq_123.readhub.model.retrofit.APIInterface;
import com.example.wwq_123.readhub.model.retrofit.bean.Data;
import com.example.wwq_123.readhub.model.retrofit.bean.NewsData;
import com.example.wwq_123.readhub.util.DataUtil;
import com.example.wwq_123.readhub.util.TimeUtil;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewsService extends Service{


    public void initData(){
        APIInterface service = API.getService();
        Observable<NewsData> observable = service.getNewsData(null,10);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NewsData newsData) {
                        DataUtil util = new DataUtil();
                        List<DataItem> list = util.extractNews(newsData);
                        callBack.getData(list);
                    }
                });
    }

    @Override
    public void addData(DataItem item) {
        NewsDataItem data = (NewsDataItem) item;
        APIInterface service = API.getService();
        Observable<NewsData> observable = service.getNewsData(TimeUtil.UTCTOTimestamp(data.getPublishDate()),10);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsData>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onNext(NewsData newsData) {
                        DataUtil util = new DataUtil();
                        List<DataItem> list = util.extractNews(newsData);
                        callBack.getData(list);
                    }
                });
    }

    public void setCallBack(CallBack callBack) {
        super.setCallBack(callBack);
    }
}
