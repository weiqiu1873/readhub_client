package com.example.wwq_123.readhub.eventbus;

import com.example.wwq_123.readhub.model.bean.TopicDataItem;
import com.example.wwq_123.readhub.model.jsonbean.bean.CommonDataItem;


public class Event {

    public static class Topic{
        public TopicDataItem item;
    }
    public static class News{
        public CommonDataItem item;
    }
}
