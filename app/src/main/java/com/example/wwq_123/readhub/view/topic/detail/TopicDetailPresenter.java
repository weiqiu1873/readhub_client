package com.example.wwq_123.readhub.view.topic.detail;

import com.example.wwq_123.readhub.base.BasePresenter;
import com.example.wwq_123.readhub.model.bean.TopicDetail;
import com.example.wwq_123.readhub.net.retrofit.MySubscriber;

public class TopicDetailPresenter extends BasePresenter<TopicDetailContract.View> implements TopicDetailContract.Presenter {

    public TopicDetailPresenter(TopicDetailContract.View view){
        attachView(view);
    }

    @Override
    public void getTopicDetail(String id) {
        addSubscription(api.getTopicDetail(id),new MySubscriber<TopicDetail>(){
            @Override
            public void onNext(TopicDetail topicDetail) {
                view.showTopicDetail(topicDetail);
            }
        });
    }
}
