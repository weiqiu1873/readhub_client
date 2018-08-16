package com.example.wwq_123.readhub.mvc.presenter;

import com.example.wwq_123.readhub.net.retrofit.APIInterface;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class BasePresenter<V> {
    private V view;

    protected APIInterface api;
    private CompositeSubscription subscription;

    public void attachView(V view){
        this.view = view;
    }

    public void detachView(){
        this.view = null;
        onUnsubscribe();
    }

    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (subscription!=null&& subscription.hasSubscriptions()){
            subscription.unsubscribe();
        }
    }

    public <T> void addSubscription(Observable<T> observable, Subscriber<T> subscriber) {
        if (subscription == null) {
            subscription = new CompositeSubscription();
        }
        subscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));

    }

}
