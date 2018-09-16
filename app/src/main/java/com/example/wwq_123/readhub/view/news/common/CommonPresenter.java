package com.example.wwq_123.readhub.view.news.common;

import com.example.wwq_123.readhub.base.BasePresenter;
import com.example.wwq_123.readhub.model.jsonbean.bean.CommonDataItem;
import com.example.wwq_123.readhub.net.retrofit.MySubscriber;
import com.example.wwq_123.readhub.util.DataUtil;

import java.util.List;

public class CommonPresenter extends BasePresenter<CommonContract.View> implements CommonContract.Presenter {

    public CommonPresenter(CommonContract.View view){
        attachView(view);
    }

    @Override
    public void getTechNews() {
        addSubscription(api.getTechNews("",10)
                .map((techData)->DataUtil.extractTech(techData))
                , new MySubscriber<List<CommonDataItem>>(){
                    @Override
                    public void onNext(List<CommonDataItem> list) {
                        view.showTechNews(list);
                    }
                });
    }

    @Override
    public void getDevelopNews() {
        addSubscription(api.getDeveloperNews("",10)
                .map((developerData)->DataUtil.extractDeveloper(developerData)),
                new MySubscriber<List<CommonDataItem>>(){
                    @Override
                    public void onNext(List<CommonDataItem> list) {
                        view.showDeveloperNews(list);
                    }
                });
    }

    @Override
    public void getBlockchainNews() {
        addSubscription(api.getBlockchainNews("",10)
                .map((blockchainData)->DataUtil.extractBlockchain(blockchainData))
                ,new MySubscriber<List<CommonDataItem>>(){
                    @Override
                    public void onNext(List<CommonDataItem> list) {
                        view.showBlockchainNews(list);
                    }
                });
    }

}
