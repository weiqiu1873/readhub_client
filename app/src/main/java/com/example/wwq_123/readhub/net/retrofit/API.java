package com.example.wwq_123.readhub.net.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class API {
    private static APIInterface service1;
    private static APIInterface service2;
    //https://api.readhub.cn/

    public static APIInterface getService(){
        if (service1==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.readhub.cn/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            service1 = retrofit.create(APIInterface.class);
        }
        return service1;
    }

    public static APIInterface getTitleService(){
        if (service2==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://readhub.cn/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            service2 = retrofit.create(APIInterface.class);
        }
        return service2;
    }

}
