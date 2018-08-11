package com.example.wwq_123.readhub.presenter.service;

import com.example.wwq_123.readhub.model.bean.DataItem;

import java.util.List;

public class Service {
    protected CallBack callBack;

    public CallBack getCallBack() {
        return callBack;
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public void initData(){};

    public void addData(DataItem item){};

    public interface CallBack{
        public abstract void getData(List<? extends DataItem> list);
    }
}
