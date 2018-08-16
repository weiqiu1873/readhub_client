package com.example.wwq_123.readhub.net.okhttp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Okhttp {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();

    public static OkHttpClient getClient(){
        return client;
    }
    //同步获取数据
    public String synRun(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
    //异步获取数据
    public void asyRun(String url , final int type) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            Handler handler = new Handler(Looper.getMainLooper());
            @Override
            public void onFailure(Call call, IOException e) {
                Message message = handler.obtainMessage();
                message.obj = "获取失败!";
                message.what = type;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = handler.obtainMessage();
                message.obj = response.body().string();
//                System.out.println(message.obj);
                message.what = type;
                handler.sendMessage(message);
            }
        });
    }

    public String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
