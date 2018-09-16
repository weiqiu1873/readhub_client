package com.example.wwq_123.readhub.view.job.detail;

import com.example.wwq_123.readhub.base.BaseContract;
import com.example.wwq_123.readhub.model.jsonbean.Chart;

public interface JobDetailContract extends BaseContract {
    public interface View extends BaseContract.BaseView{
        void showChart(Chart chart);
    }
    public interface Presenter extends BaseContract.BasePresenter<View>{
        void getChart(String id);
    }
}
