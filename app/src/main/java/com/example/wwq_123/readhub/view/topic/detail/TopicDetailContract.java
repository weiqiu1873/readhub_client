package com.example.wwq_123.readhub.view.topic.detail;

import com.example.wwq_123.readhub.base.BaseContract;
import com.example.wwq_123.readhub.model.bean.TopicDetail;

public interface TopicDetailContract extends BaseContract {
    interface View extends BaseContract.BaseView{
        void showTopicDetail(TopicDetail detail);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getTopicDetail(String id);
    }
}
