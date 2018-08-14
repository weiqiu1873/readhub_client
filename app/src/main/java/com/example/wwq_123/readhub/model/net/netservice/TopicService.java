package com.example.wwq_123.readhub.model.net.netservice;

import com.example.wwq_123.readhub.model.Model;
import com.example.wwq_123.readhub.model.bean.DataItem;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;
import com.example.wwq_123.readhub.model.net.retrofit.API;
import com.example.wwq_123.readhub.model.net.retrofit.APIInterface;
import com.example.wwq_123.readhub.model.jsonbean.TopicData;
import com.example.wwq_123.readhub.util.DataUtil;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TopicService implements Service{
    @Override
    public void getData(Model.GetDataCallBack callBack){
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
                        List<DataItem> list = util.extractTopic(topicData);
                        //回调函数返回数据
                        callBack.DataCallBack(list);
                    }
                });
    }

    @Override
    public void getMoreData(Model.GetMoreDataCallBack callBack,DataItem item) {
        TopicDataItem data = (TopicDataItem) item;
        APIInterface service = API.getService();
        Observable<TopicData> observable = service.getTopicData(String.valueOf(((TopicDataItem) item).getOrder()),10);
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
                        List<DataItem> list = util.extractTopic(topicData);
                        //回调函数返回数据
                        callBack.DataCallBack(list);
                    }
                });
    }

}
