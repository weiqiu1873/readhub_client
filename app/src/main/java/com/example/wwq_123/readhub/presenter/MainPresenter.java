package com.example.wwq_123.readhub.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.example.wwq_123.readhub.model.Okhttp;
import com.example.wwq_123.readhub.model.bean.DataItem;
import com.example.wwq_123.readhub.model.bean.Title;
import com.example.wwq_123.readhub.model.retrofit.APIInterface;
import com.example.wwq_123.readhub.model.retrofit.bean.BlockchainData;
import com.example.wwq_123.readhub.model.retrofit.bean.Data;
import com.example.wwq_123.readhub.model.retrofit.bean.JobData;
import com.example.wwq_123.readhub.model.retrofit.bean.NewsData;
import com.example.wwq_123.readhub.model.retrofit.bean.TechData;
import com.example.wwq_123.readhub.model.retrofit.bean.TopicData;
import com.example.wwq_123.readhub.util.DataUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainPresenter {

    private static String url = "https://readhub.cn";
    private Okhttp okhttp = new Okhttp();
    private Handler handler;
    private Context context;
    private CallBack callBack;
    private  Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.readhub.cn/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();
    public MainPresenter(Handler h,Context c){
        this.handler = h;
        this.context = c;
    }

    public void init(final int type){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = handler.obtainMessage();
                String url = "https://readhub.cn/";
                okhttp.asyRun(url,handler,type);
            }
        }).start();
    }

    public void initData(int type){

        APIInterface service = retrofit.create(APIInterface.class);
       if (type==0){
           Observable<TopicData> observable = service.getTopicData(null,10);
           rxjava(observable,type);
       }else if (type==1){
           Observable<NewsData> observable = service.getNewsData(null,10);
           rxjava(observable,type);
       }else if (type==2){
           Observable<TechData> observable = service.getTechsData(null,10);
           rxjava(observable,type);
       }else if (type==3){
           Observable<BlockchainData> observable = service.getBlockchainData(null,10);
           rxjava(observable,type);
       }else {
           Observable<JobData> observable = service.getJobData(null,10);
           rxjava(observable,type);
       }

    }

    public void rxjava(Observable<? extends Data> observable, final int type){
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Data>() {
                    @Override
                    public void onCompleted() {
//                        Toast.makeText(context.getApplicationContext(), "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onError(Throwable e) {
//                        Toast.makeText(context.getApplicationContext(),"获取数据失败",Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onNext(Data d) {
                        //从data中提取数据
                        DataUtil util = new DataUtil();
                        List<? extends DataItem> list = util.extractData(d,type);
                        //回调函数返回数据
                        callBack.getData(list);
                    }
                });
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public interface CallBack{
        public abstract void getData(List<? extends DataItem> list);
    }
}
