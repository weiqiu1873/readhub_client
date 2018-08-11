package com.example.wwq_123.readhub.presenter.service;

import com.example.wwq_123.readhub.model.bean.DataItem;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;
import com.example.wwq_123.readhub.model.retrofit.API;
import com.example.wwq_123.readhub.model.retrofit.APIInterface;
import com.example.wwq_123.readhub.model.retrofit.bean.TopicData;
import com.example.wwq_123.readhub.util.DataUtil;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TopicService extends Service{

    public void initData(){

        APIInterface service = API.getService();
        Observable<TopicData> observable = service.getTopicData(null,10);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TopicData>() {
                    @Override
                    public void onCompleted() {
//                        Toast.makeText(context.getApplicationContext(), "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onError(Throwable e) {
//                        Toast.makeText(context.getApplicationContext(),"获取数据失败",Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onNext(TopicData topicData) {
                        //从data中提取数据
                        DataUtil util = new DataUtil();
                        List<? extends  DataItem> list = util.extractTopic(topicData);
                        //回调函数返回数据
                        callBack.getData(list);
                    }
                });
    }

    @Override
    public void addData(DataItem item) {

    }

    @Override
    public void setCallBack(CallBack callBack) {
        super.setCallBack(callBack);
    }
}
