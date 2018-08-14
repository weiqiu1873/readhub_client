package com.example.wwq_123.readhub.model;

import com.example.wwq_123.readhub.model.bean.DataItem;
import com.example.wwq_123.readhub.model.bean.Title;

import java.util.List;

public interface Model {

    public interface GetTabTitleModel{
        public abstract void getTabTitle(GetTabTitleCallBack callBack);
    }
    public interface GetDataModel{
        public abstract void getData(GetDataCallBack callBack,int fragmentId);
        public abstract void getMoreData(GetMoreDataCallBack callBack,int fragmentId,DataItem item);
    }


    //回调接口
    public interface GetTabTitleCallBack{
        public abstract void TabTitleCallBack(List<Title> titles);
    }
    public interface GetDataCallBack{
        public abstract void DataCallBack(List<DataItem> list);
    }
    public interface GetMoreDataCallBack{
        public abstract void DataCallBack(List<DataItem> list);
    }
}
