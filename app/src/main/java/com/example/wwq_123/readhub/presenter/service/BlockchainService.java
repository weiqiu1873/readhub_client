package com.example.wwq_123.readhub.presenter.service;

import com.example.wwq_123.readhub.model.bean.DataItem;
import com.example.wwq_123.readhub.model.retrofit.API;
import com.example.wwq_123.readhub.model.retrofit.APIInterface;
import com.example.wwq_123.readhub.model.retrofit.bean.BlockchainData;
import com.example.wwq_123.readhub.model.retrofit.bean.Data;
import com.example.wwq_123.readhub.util.DataUtil;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BlockchainService extends Service{

    public void initData(){
        APIInterface service = API.getService();
        Observable<BlockchainData> observable = service.getBlockchainData(null,10);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BlockchainData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BlockchainData blockchainData) {
                        DataUtil util = new DataUtil();
                        List<? extends  DataItem> list = util.extractBlockchain(blockchainData);
                        callBack.getData(list);
                    }
                });
    }

    @Override
    public void addData(DataItem item) {

    }

    public void setCallBack(CallBack callBack) {
        super.setCallBack(callBack);
    }
}
