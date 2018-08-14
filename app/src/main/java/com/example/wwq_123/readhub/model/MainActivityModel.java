package com.example.wwq_123.readhub.model;

import com.example.wwq_123.readhub.util.DataUtil;


public class MainActivityModel implements Model.GetTabTitleModel{

    public MainActivityModel(){

    }
    /*
        异步获取网络数据操作
     */
    @Override
    public void getTabTitle(final Model.GetTabTitleCallBack callBack) {
        DataUtil util = new DataUtil();
        util.getTabTitle(callBack);
    }

}
