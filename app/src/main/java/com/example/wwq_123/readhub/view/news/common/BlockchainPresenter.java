package com.example.wwq_123.readhub.view.news.common;

import com.example.wwq_123.readhub.base.BasePresenter;
import com.example.wwq_123.readhub.model.bean.CommonDataItem;
import com.example.wwq_123.readhub.net.retrofit.MySubscriber;
import com.example.wwq_123.readhub.util.DataUtil;
import com.example.wwq_123.readhub.util.TimeUtil;

import java.util.List;

public class BlockchainPresenter extends BasePresenter<CommonContract.View> implements CommonContract.BlockchainPresenter {

    private String lastCursor;
    public BlockchainPresenter(CommonContract.View view){
        attachView(view);
    }

    @Override
    public void getBlockchainNews() {
        addSubscription(api.getBlockchainNews("",10)
                        .map((blockchainData)-> DataUtil.extractBlockchain(blockchainData))
                ,new MySubscriber<List<CommonDataItem>>(){
                    @Override
                    public void onNext(List<CommonDataItem> list) {
                        lastCursor = TimeUtil.UTCTOTimestamp(list.get(list.size()-1).getPublishDate());
                        view.showNews(list);
                    }
                });
    }

    @Override
    public void getMoreBlockchainNews() {
        addSubscription(api.getBlockchainNews(lastCursor,10)
                        .map((blockchainData)-> DataUtil.extractBlockchain(blockchainData))
                ,new MySubscriber<List<CommonDataItem>>(){
                    @Override
                    public void onNext(List<CommonDataItem> list) {
                        lastCursor = TimeUtil.UTCTOTimestamp(list.get(list.size()-1).getPublishDate());
                        view.showMoreNews(list);
                    }
                });
    }

    @Override
    public void getLatestBlockchainNews() {
        addSubscription(api.getBlockchainNews("",10)
                        .map((blockchainData)-> DataUtil.extractBlockchain(blockchainData))
                ,new MySubscriber<List<CommonDataItem>>(){
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
