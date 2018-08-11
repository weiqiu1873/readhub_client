package com.example.wwq_123.readhub.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.example.wwq_123.readhub.model.Okhttp;
import com.example.wwq_123.readhub.model.bean.DataItem;
import com.example.wwq_123.readhub.model.retrofit.API;
import com.example.wwq_123.readhub.model.retrofit.APIInterface;
import com.example.wwq_123.readhub.model.retrofit.bean.Data;
import com.example.wwq_123.readhub.model.retrofit.bean.TopicData;
import com.example.wwq_123.readhub.presenter.service.BlockchainService;
import com.example.wwq_123.readhub.presenter.service.JobService;
import com.example.wwq_123.readhub.presenter.service.NewsService;
import com.example.wwq_123.readhub.presenter.service.Service;
import com.example.wwq_123.readhub.presenter.service.TechService;
import com.example.wwq_123.readhub.presenter.service.TopicService;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainPresenter {

    private static String url = "https://readhub.cn";
    private Okhttp okhttp = new Okhttp();
    private Handler handler;
    private Context context;
    private Service service;
    public MainPresenter(Context c){
        this.context = c;
    }
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

    public Service initData(int type){
        switch (type){
            case 0:
                service = new TopicService();
                break;
            case 1:
                service = new NewsService();
                service.initData();
                break;
            case 2:
                service = new TechService();
                break;
            case 3:
                service = new BlockchainService();
                break;
            case 4:
                service = new JobService();
                break;
                default:service = new Service();
                    break;
        }
        service.initData();
        //返回服务提供回调函数
        return service;
    }


    public Service updateData(){
        service.initData();//重新获取数据
        return service;
    }

    public Service addData(DataItem item){
        service.addData(item);
        return service;
    }


}
