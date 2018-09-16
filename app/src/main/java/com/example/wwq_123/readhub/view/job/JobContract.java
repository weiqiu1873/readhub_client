package com.example.wwq_123.readhub.view.job;

import com.example.wwq_123.readhub.base.BaseContract;
import com.example.wwq_123.readhub.model.jsonbean.bean.JobDataItem;

import java.util.List;

public interface JobContract {
    interface View extends BaseContract.BaseView{
        void showJobData(List<JobDataItem> topicList);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getJobData();
    }
}
