package com.example.wwq_123.readhub.view.job;

import com.example.wwq_123.readhub.base.BaseContract;
import com.example.wwq_123.readhub.model.bean.JobDataItem;
import java.util.List;

public interface JobContract {
    interface View extends BaseContract.BaseView{
        void showJobData(List<JobDataItem> jobDataItems);
        void showMoreJobData(List<JobDataItem> jobDataItems);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getJobData();
        void getMoreJobData();
    }
}
