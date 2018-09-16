package com.example.wwq_123.readhub.view.news.common;

import com.example.wwq_123.readhub.base.BaseContract;
import com.example.wwq_123.readhub.model.jsonbean.bean.CommonDataItem;

import java.util.List;

public class CommonContract {
    interface View extends BaseContract.BaseView{
        void showTechNews(List<CommonDataItem> list);
        void showDeveloperNews(List<CommonDataItem> list);
        void showBlockchainNews(List<CommonDataItem> list);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getTechNews();
        void getDevelopNews();
        void getBlockchainNews();
    }
}
