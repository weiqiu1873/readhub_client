package com.example.wwq_123.readhub.mvc.view;

import com.example.wwq_123.readhub.mvc.model.bean.DataItem;
import com.example.wwq_123.readhub.mvc.model.bean.Title;

import java.util.List;

public interface Display{

    public interface TabTitle{
        public abstract void initTitle(List<Title> titles);

    }

    public interface DisplayData{
        public abstract void initData(List<DataItem> list);

    }

    public interface SetMoreDisplayData{
        public abstract void getMoreData(List<DataItem> list);
    }

}
