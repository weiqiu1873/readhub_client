package com.example.wwq_123.readhub.net.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class API {

    public static final String BASE_URL = "https://api.readhub.cn/";
    private static APIInterface service;

    public static APIInterface getService(){
        if (service==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            service = retrofit.create(APIInterface.class);
        }
        return service;
    }

}
