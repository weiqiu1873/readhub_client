package com.example.wwq_123.readhub.view.news.common;

import com.example.wwq_123.readhub.base.BaseContract;
import com.example.wwq_123.readhub.model.bean.CommonDataItem;
import java.util.List;

public class CommonContract {
    interface View extends BaseContract.BaseView{
        void showNews(List<CommonDataItem> list);
        void showMoreNews(List<CommonDataItem> list);
        void showUpdateNews(List<CommonDataItem> list);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getNews(int position);
        void getMoreNews(int position);
        void updateNews(int position);
    }
    interface TechPresenter extends BaseContract.BasePresenter<View>{
        void getTechNews();
        void getMoreTechNews();
        void getLatestTechNews();
    }
    interface DeveloperPresenter extends BaseContract.BasePresenter<View>{
        void getDevelopNews();
        void getMoreDevelopNews();
        void getLatestDevelopNews();
    }
    interface BlockchainPresenter extends BaseContract.BasePresenter<View>{
        void getBlockchainNews();
        void getMoreBlockchainNews();
        void getLatestBlockchainNews();
    }
}
