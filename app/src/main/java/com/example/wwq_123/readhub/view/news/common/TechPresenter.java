package com.example.wwq_123.readhub.view.news.common;

import com.example.wwq_123.readhub.base.BasePresenter;
import com.example.wwq_123.readhub.model.bean.CommonDataItem;
import com.example.wwq_123.readhub.net.retrofit.MySubscriber;
import com.example.wwq_123.readhub.util.DataUtil;
import com.example.wwq_123.readhub.util.TimeUtil;

import java.util.List;

public class TechPresenter extends BasePresenter<CommonContract.View> implements CommonContract.TechPresenter{

    private String lastCursor;
    public TechPresenter(CommonContract.View view){
        attachView(view);
    }
    @Override
    public void getTechNews() {
        addSubscription(api.getTechNews("",10)
                        .map((techData)-> DataUtil.extractTech(techData))
                , new MySubscriber<List<CommonDataItem>>(){
                    @Override
                    public void onNext(List<CommonDataItem> list) {
                        lastCursor = TimeUtil.UTCTOTimestamp(list.get(list.size()-1).getPublishDate());
                        view.showNews(list);
                    }
                });
    }

    @Override
    public void getMoreTechNews() {
        addSubscription(api.getTechNews(lastCursor,10)
                        .map((techData)-> DataUtil.extractTech(techData))
                , new MySubscriber<List<CommonDataItem>>(){
                    @Override
                    public void onNext(List<CommonDataItem> list) {
                        lastCursor = TimeUtil.UTCTOTimestamp(list.get(list.size()-1).getPublishDate());
                        view.showMoreNews(list);
                    }
                });
    }

    @Override
    public void getLatestTechNews() {
        addSubscription(api.getTechNews("",10)
                        .map((techData)-> DataUtil.extractTech(techData))
                , new MySubscriber<List<CommonDataItem>>(){
                    @Override
                    public void onNext(List<CommonDataItem> list) {
                        String cursor = TimeUtil.UTCTOTimestamp(list.get(list.size()-1).getPublishDate());
                        if (lastCursor.equals(cursor)){
                            view.showUpdateNews(null);
                        }else {
                            lastCursor = cursor;
                            view.showUpdateNews(list);
                        }
                    }
                });
    }
}
