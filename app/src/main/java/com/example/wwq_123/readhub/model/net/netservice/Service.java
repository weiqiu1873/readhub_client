package com.example.wwq_123.readhub.model.net.netservice;


import com.example.wwq_123.readhub.model.Model;
import com.example.wwq_123.readhub.model.bean.DataItem;

public interface Service {

    public void getData(Model.GetDataCallBack callBack);

    public void getMoreData(Model.GetMoreDataCallBack callBack, DataItem item);

}
