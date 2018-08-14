package com.example.wwq_123.readhub.model;

import com.example.wwq_123.readhub.model.bean.DataItem;
import com.example.wwq_123.readhub.model.net.netservice.BlockchainService;
import com.example.wwq_123.readhub.model.net.netservice.JobService;
import com.example.wwq_123.readhub.model.net.netservice.NewsService;
import com.example.wwq_123.readhub.model.net.netservice.TechService;
import com.example.wwq_123.readhub.model.net.netservice.TopicService;

public class MainFragmentModel implements Model.GetDataModel {
    @Override
    public void getData(Model.GetDataCallBack callBack,int fragmentId) {
        switch (fragmentId){
            case 0:
                TopicService topicService = new TopicService();
                topicService.getData(callBack);
                break;
            case 1:
                NewsService newsService = new NewsService();
                newsService.getData(callBack);
                break;
            case 2:
                TechService techService = new TechService();
                techService.getData(callBack);
                break;
            case 3:
                BlockchainService blockchainService = new BlockchainService();
                blockchainService.getData(callBack);
                break;
            case 4:
                JobService jobService = new JobService();
                jobService.getData(callBack);
                break;
            default:break;
        }
    }

    @Override
    public void getMoreData(Model.GetMoreDataCallBack callBack, int fragmentId, DataItem item) {
        switch (fragmentId){
            case 0:
                TopicService topicService = new TopicService();
                topicService.getMoreData(callBack,item);
                break;
            case 1:
                NewsService newsService = new NewsService();
                newsService.getMoreData(callBack,item);
                break;
            case 2:
                TechService techService = new TechService();
                techService.getMoreData(callBack,item);
                break;
            case 3:
                BlockchainService blockchainService = new BlockchainService();
                blockchainService.getMoreData(callBack,item);
                break;
            case 4:
                JobService jobService = new JobService();
                jobService.getMoreData(callBack,item);
                break;
            default:break;
        }
    }
}
