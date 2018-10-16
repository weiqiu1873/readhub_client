package com.example.wwq_123.readhub.view.favoritejob;

import com.example.wwq_123.readhub.base.BaseContract;
import com.example.wwq_123.readhub.model.bean.JobArrayBean;

import java.util.List;

public class FavoriteJobContract implements BaseContract {
    interface View extends BaseContract.BaseView{
        void showJob(List<JobArrayBean> list);
    }
    interface Presenter extends  BaseContract.BasePresenter<View>{
        void getJob();
    }
}
