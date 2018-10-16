package com.example.wwq_123.readhub.eventbus;

import com.example.wwq_123.readhub.model.bean.CommonDataItem;
import com.example.wwq_123.readhub.model.bean.JobArrayBean;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;


public class Event {

    public static class Topic{
        public TopicDataItem item;
    }
    public static class News{
        public CommonDataItem item;
    }
    public static class Job{
        public JobArrayBean bean;
    }
}
