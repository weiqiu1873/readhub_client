package com.example.wwq_123.readhub.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.wwq_123.readhub.model.bean.ContentItem;
import com.example.wwq_123.readhub.model.bean.Title;
import com.example.wwq_123.readhub.util.HtmlUtil;
import com.example.wwq_123.readhub.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyHandler extends Handler {
    private CallBack callBack;  //获取标题的回调函数
    private ContentCallBack conCallBack;//获取内容的回调函数
    @Override
    public void handleMessage(Message msg) {

        if (msg.what==-1){
            List<Title> list = HtmlUtil.getTitle(String.valueOf(msg.obj));
            if (callBack!=null){
                callBack.getTitle(list);
            }
        }else {
            List<ContentItem> contentItems;
            switch (msg.what){
                case 0:
                    contentItems = HtmlUtil.getHotTopic(String.valueOf(msg.obj));
                    if (conCallBack!=null){
                        conCallBack.getContent(contentItems,msg.what);
                    }
                    break;
                case 1:
                    contentItems = JsonUtil.getNews(String.valueOf(msg.obj));
                    if (conCallBack!=null){
                        conCallBack.getContent(contentItems,msg.what);
                    }
                    break;
                case 2:
                    contentItems = HtmlUtil.getTech(String.valueOf(msg.obj));
                    if (conCallBack!=null){
                        conCallBack.getContent(contentItems,msg.what);
                    }
                    break;
                case 3:
                    contentItems = HtmlUtil.getBlockchain(String.valueOf(msg.obj));
                    if (conCallBack!=null){
                        conCallBack.getContent(contentItems,msg.what);
                    }
                    break;
                case 4:
                    //contentItems = htmlUtil.getJobs();
                    break;
                default:break;
            }
        }

    }

    public interface CallBack{
        public abstract void getTitle(List<Title> titles);
    }

    public void setCallBack(CallBack cb){
        this.callBack = cb;
    };

    public interface ContentCallBack{
        public abstract void getContent(List<ContentItem> contentItems,int position);
    }
    public void setContentCallBack(ContentCallBack ccb){
        this.conCallBack = ccb;
    }
}
