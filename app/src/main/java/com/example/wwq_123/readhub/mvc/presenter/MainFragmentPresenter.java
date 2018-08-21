package com.example.wwq_123.readhub.mvc.presenter;


import com.example.wwq_123.readhub.mvc.model.bean.DataItem;
import com.example.wwq_123.readhub.mvc.model.bean.TopicDataItem;
import com.example.wwq_123.readhub.mvc.model.jsonbean.BlockchainData;
import com.example.wwq_123.readhub.mvc.model.jsonbean.Data;
import com.example.wwq_123.readhub.mvc.model.jsonbean.JobData;
import com.example.wwq_123.readhub.mvc.model.jsonbean.NewsData;
import com.example.wwq_123.readhub.mvc.model.jsonbean.TechData;
import com.example.wwq_123.readhub.mvc.model.jsonbean.TopicData;
import com.example.wwq_123.readhub.net.retrofit.API;
import com.example.wwq_123.readhub.net.retrofit.MySubscriber;
import com.example.wwq_123.readhub.util.DataUtil;
import com.example.wwq_123.readhub.util.TimeUtil;
import com.example.wwq_123.readhub.mvc.view.Display;
import com.example.wwq_123.readhub.adapter.MyRecyclerAdapter;

import java.util.List;

public class MainFragmentPresenter extends BasePresenter<Display.DisplayData> implements Presenter.LoadDataPresenter,Presenter.LoadMoreDataPresenter,Presenter.UpdateDataPresenter {

    private Display.DisplayData view;
    private MyRecyclerAdapter adapter;

    public MainFragmentPresenter(Display.DisplayData view){
        this.view = view;
        attachView(view);
        api = API.getService();
    }

    @Override
    public void loadData(int fragmentId) {
        DataUtil util = new DataUtil();
        switch (fragmentId){
            case 0:
                addSubscription(api.getTopicData(null,10)
                        ,new MySubscriber<TopicData>(){
                    @Override
                    public void onNext(TopicData topicData) {
                        List<DataItem>  list = util.extractTopic(topicData);
                        view.initData(list);
                    }
                });
                break;
            case 1:
                addSubscription(api.getNewsData(null,10)
                        ,new MySubscriber<NewsData>(){
                    @Override
                    public void onNext(NewsData newsData) {
                        List<DataItem>  list = util.extractNews(newsData);
                        view.initData(list);
                    }
                });
                break;
            case 2:
                addSubscription(api.getTechsData(null,10)
                        ,new MySubscriber<TechData>(){
                    @Override
                    public void onNext(TechData techData) {
                        List<DataItem> list = util.extractTech(techData);
                        view.initData(list);
                    }
                });
                break;
            case 3:
                addSubscription(api.getBlockchainData(null,10)
                        ,new MySubscriber<BlockchainData>(){
                    @Override
                    public void onNext(BlockchainData blockchainData) {
                        List<DataItem> list = util.extractBlockchain(blockchainData);
                        view.initData(list);
                    }
                });
                break;
            case 4:
                addSubscription(api.getJobData(null,10)
                        ,new MySubscriber<JobData>(){
                    @Override
                    public void onNext(JobData jobData) {
                        List<DataItem> list = util.extractJob(jobData);
                        view.initData(list);
                    }
                });
                break;
                default:break;
        }

    }

    @Override
    public void loadMoreData(int fragmentId,DataItem item) {
        DataUtil util = new DataUtil();
        switch (fragmentId){
            case 0:
                addSubscription(api.getTopicData(String.valueOf(((TopicDataItem) item).getOrder()),10)
                        ,new MySubscriber<TopicData>(){
                    @Override
                    public void onNext(TopicData topicData) {
                        List<DataItem>  list = util.extractTopic(topicData);
                        view.setMoreData(list);
                    }
                });
                break;
            case 1:
                addSubscription(api.getNewsData(TimeUtil.UTCTOTimestamp(item.getPublishDate()),10)
                        ,new MySubscriber<NewsData>(){
                    @Override
                    public void onNext(NewsData newsData) {
                        List<DataItem>  list = util.extractNews(newsData);
                        view.setMoreData(list);
                    }
                });
                break;
            case 2:
                addSubscription(api.getTechsData(TimeUtil.UTCTOTimestamp(item.getPublishDate()),10)
                        ,new MySubscriber<TechData>(){
                    @Override
                    public void onNext(TechData techData) {
                        List<DataItem> list = util.extractTech(techData);
                        view.setMoreData(list);
                    }
                });
                break;
            case 3:
                addSubscription(api.getBlockchainData(TimeUtil.UTCTOTimestamp(item.getPublishDate()),10)
                        ,new MySubscriber<BlockchainData>(){
                    @Override
                    public void onNext(BlockchainData blockchainData) {
                        List<DataItem> list = util.extractBlockchain(blockchainData);
                        view.setMoreData(list);
                    }
                });
                break;
            case 4:
                addSubscription(api.getJobData(TimeUtil.UTCTOTimestamp(item.getPublishDate()),10)
                        ,new MySubscriber<JobData>(){
                    @Override
                    public void onNext(JobData jobData) {
                        List<DataItem> list = util.extractJob(jobData);
                        view.setMoreData(list);
                    }
                });
                break;
            default:break;
        }
    }

    @Override
    public void updateData(int fragmentId, DataItem item) {
        DataUtil util = new DataUtil();
        switch (fragmentId){
            case 0:
                addSubscription(api.getTopicData(null,10)
                        ,new MySubscriber<TopicData>(){
                            @Override
                            public void onNext(TopicData topicData) {
                                List<DataItem>  list = util.extractTopic(topicData);
                                if (list.get(0).equals(item)){
                                    view.setUpdateData(null);
                                }else {
                                    view.setUpdateData(list);
                                }
                            }
                        });
                break;
            case 1:
                addSubscription(api.getNewsData(null,10)
                        ,new MySubscriber<NewsData>(){
                            @Override
                            public void onNext(NewsData newsData) {
                                List<DataItem>  list = util.extractNews(newsData);
                                if (list.get(0).equals(item)){
                                    view.setUpdateData(null);
                                }else {
                                    view.setUpdateData(list);
                                }
                            }
                        });
                break;
            case 2:
                addSubscription(api.getTechsData(null,10)
                        ,new MySubscriber<TechData>(){
                            @Override
                            public void onNext(TechData techData) {
                                List<DataItem> list = util.extractTech(techData);
                                if (list.get(0).equals(item)){
                                    view.setUpdateData(null);
                                }else {
                                    view.setUpdateData(list);
                                }
                            }
                        });
                break;
            case 3:
                addSubscription(api.getBlockchainData(null,10)
                        ,new MySubscriber<BlockchainData>(){
                            @Override
                            public void onNext(BlockchainData blockchainData) {
                                List<DataItem> list = util.extractBlockchain(blockchainData);
                                if (list.get(0).equals(item)){
                                    view.setUpdateData(null);
                                }else {
                                    view.setUpdateData(list);
                                }
                            }
                        });
                break;
            case 4:
                addSubscription(api.getJobData(null,10)
                        ,new MySubscriber<JobData>(){
                            @Override
                            public void onNext(JobData jobData) {
                                List<DataItem> list = util.extractJob(jobData);
                                if (list.get(0).equals(item)){
                                    view.setUpdateData(null);
                                }else {
                                    view.setUpdateData(list);
                                }
                            }
                        });
                break;
            default:break;
        }

    }
}
