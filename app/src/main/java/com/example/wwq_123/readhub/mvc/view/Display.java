package com.example.wwq_123.readhub.mvc.view;

import com.example.wwq_123.readhub.mvc.model.bean.DataItem;
import com.example.wwq_123.readhub.mvc.model.bean.Title;

import java.util.List;

public interface Display{

    interface TabTitle{
        void initTitle(List<Title> titles);
    }

    interface DisplayData{
        void initData(List<DataItem> list);
        void setMoreData(List<DataItem> list);
        void setUpdateData(List<DataItem> list);
    }

}
