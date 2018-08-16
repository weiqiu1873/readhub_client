package com.example.wwq_123.readhub.net.retrofit;

import android.util.Log;

import rx.Subscriber;

public class MySubscriber<T> extends Subscriber<T>{

    @Override
    public void onCompleted() {
//        Toast.makeText(MyApplication.getAppContext(),"Loading success",Toast.LENGTH_SHORT);
    }

    @Override
    public void onError(Throwable e) {
//        Toast.makeText(MyApplication.getAppContext(),"Loading failure",Toast.LENGTH_SHORT);
        Log.e("Cause of failure:",e.getMessage());
    }

    @Override
    public void onNext(T t) {

    }
}
