package com.example.wwq_123.readhub.model.net.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    private static APIInterface service;

    public static APIInterface getService(){
        if (service==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.readhub.cn/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            service = retrofit.create(APIInterface.class);
        }
        return service;
    }
}
