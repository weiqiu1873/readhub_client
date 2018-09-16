package com.example.wwq_123.readhub.base;

import com.example.wwq_123.readhub.net.retrofit.API;
import com.example.wwq_123.readhub.net.retrofit.APIInterface;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BasePresenter<V extends BaseContract.BaseView> implements BaseContract.BasePresenter<V> {

    protected V view;
    protected APIInterface api = API.getService();
    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (view!=null){
            view = null;
        }
    }

    public <T> void addSubscription(Observable<T> observable, Subscriber<T> subscriber){
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
