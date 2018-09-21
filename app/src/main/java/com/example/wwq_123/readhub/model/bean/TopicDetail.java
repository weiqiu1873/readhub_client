package com.example.wwq_123.readhub.model.bean;


import java.util.List;

public class TopicDetail {

    /**
     * id : 7FYaqOZV8O4
     * entityTopics : [{"weight":0.686045050621033,"nerName":"Uber","entityId":243340,"entityName":"Uber","entityType":"company","entityUniqueId":"baike_14900884"}]
     * newsArray : [{"id":946349,"url":"http://tech.qq.com/a/20180906/035230.htm","title":"Uber CEO：计划2019年IPO 无意出售自动驾驶部门","siteName":"腾讯科技","mobileUrl":"http://tech.qq.com/a/20180906/035230.htm","autherName":"","duplicateId":1,"publishDate":"2018-09-05T23:47:06.000Z"},{"id":946350,"url":"https://www.jiemian.com/article/2448059.html","title":"Uber CEO：计划2019年IPO 无意出售自动驾驶部门","siteName":"界面","mobileUrl":"https://www.jiemian.com/article/2448059.html","autherName":"","duplicateId":2,"publishDate":"2018-09-06T00:13:43.000Z"},{"id":946353,"url":"http://www.donews.com/news/detail/1/3018703.html","title":"Uber计划明年上市 并无计划出售自动驾驶部门","siteName":"DoNews","mobileUrl":"http://www.donews.com/news/detail/1/3018703.html","autherName":"翟继茹","duplicateId":3,"publishDate":"2018-09-06T00:15:31.000Z"},{"id":946354,"url":"https://tech.sina.com.cn/i/2018-09-06/doc-ifxeuwwr4210531.shtml","title":"Uber推出新安全功能：包括自动探测车祸和隐藏号码","siteName":"新浪科技","mobileUrl":"https://tech.sina.com.cn/i/2018-09-06/doc-ifxeuwwr4210531.shtml","autherName":"","duplicateId":4,"publishDate":"2018-09-06T00:45:35.000Z"},{"id":946351,"url":"https://www.chinaventure.com.cn/cmsmodel/news/detail/331809.shtml","title":"Uber CEO：计划明年进行IPO 没有出售技术部门计划","siteName":"投中网","mobileUrl":"https://www.chinaventure.com.cn/cmsmodel/news/detail/331809.shtml","autherName":"","duplicateId":5,"publishDate":"2018-09-06T00:52:00.000Z"}]
     * createdAt : 2018-09-06T00:52:52.620Z
     * entityEventTopics : [{"entityId":"baike_14900884","entityName":"Uber","entityType":"company","eventType":2,"eventTypeLabel":"上市"}]
     * publishDate : 2018-09-06T00:58:05.201Z
     * summary : 据外媒报道，Uber首席执行官达拉·科斯罗萨西（Dara Khosrowshahi）周三表示，该公司计划于明年上市，并且没有出售自动驾驶汽车研发部门的计划 ... 科斯罗萨西表示，在3月份于亚利桑那州的坦佩市发生致命车祸后，Uber对在今年晚些时候恢复自动驾驶测试“相当乐观” ... 他称，在公司进行首次公开募股（IPO）后，先进技术集团“绝对”仍会是Uber的一部分，但将会与其他公司合作，来开发自动驾驶技术。
     * title : Uber CEO：计划2019年IPO，无意出售自动驾驶部门
     * updatedAt : 2018-09-06T01:11:25.290Z
     * timeline : {"topics":[{"id":"7FYaqOZV8O4","title":"Uber CEO：计划2019年IPO，无意出售自动驾驶部门","createdAt":"2018-09-06T00:52:52.620Z"},{"id":"4qbbjpFcw49","title":"传投资者敦促Uber出售无人驾驶汽车部门","createdAt":"2018-08-15T22:56:10.560Z"},{"id":"wTz0eEFkdQ","title":"Uber CEO：计划2019年下半年上市 之前无需保持盈利","createdAt":"2018-07-17T01:10:26.667Z"},{"id":"32qfgX7n71B","title":"Uber将与竞争对手合作 让自动驾驶汽车更安全地重返道路","createdAt":"2018-05-31T06:14:03.631Z"},{"id":"59b8X1qyjTj","title":"Uber将测试无人机送餐服务 最短只要5分钟","createdAt":"2018-05-11T06:13:34.577Z"}],"commonEntities":[]}
     * order : 63769
     * hasInstantView : true
     */

    private String id;
    private String createdAt;
    private String publishDate;
    private String summary;
    private String title;
    private String updatedAt;
    private TimelineBean timeline;
    private int order;
    private boolean hasInstantView;
    private List<EntityTopicsBean> entityTopics;
    private List<CommonDataItem> newsArray;
    private List<EntityEventTopicsBean> entityEventTopics;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TimelineBean getTimeline() {
        return timeline;
    }

    public void setTimeline(TimelineBean timeline) {
        this.timeline = timeline;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isHasInstantView() {
        return hasInstantView;
    }

    public void setHasInstantView(boolean hasInstantView) {
        this.hasInstantView = hasInstantView;
    }

    public List<EntityTopicsBean> getEntityTopics() {
        return entityTopics;
    }

    public void setEntityTopics(List<EntityTopicsBean> entityTopics) {
        this.entityTopics = entityTopics;
    }

    public List<CommonDataItem> getNewsArray() {
        return newsArray;
    }

    public void setNewsArray(List<CommonDataItem> newsArray) {
        this.newsArray = newsArray;
    }

    public List<EntityEventTopicsBean> getEntityEventTopics() {
        return entityEventTopics;
    }

    public void setEntityEventTopics(List<EntityEventTopicsBean> entityEventTopics) {
        this.entityEventTopics = entityEventTopics;
    }

    public static class TimelineBean {
        private List<TopicsBean> topics;

        public List<TopicsBean> getTopics() {
            return topics;
        }

        public void setTopics(List<TopicsBean> topics) {
            this.topics = topics;
        }

        public static class TopicsBean {
            /**
             * id : 7FYaqOZV8O4
             * title : Uber CEO：计划2019年IPO，无意出售自动驾驶部门
             * createdAt : 2018-09-06T00:52:52.620Z
             */

            private String id;
            private String title;
            private String createdAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            @Override
            public String toString() {
                return "TopicsBean{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", createdAt='" + createdAt + '\'' +
                        '}';
            }
        }
    }

    public static class EntityTopicsBean {
        /**
         * weight : 0.686045050621033
         * nerName : Uber
         * entityId : 243340
         * entityName : Uber
         * entityType : company
         * entityUniqueId : baike_14900884
         */

        private double weight;
        private String nerName;
        private String entityId;
        private String entityName;
        private String entityType;
        private String entityUniqueId;

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public String getNerName() {
            return nerName;
        }

        public void setNerName(String nerName) {
            this.nerName = nerName;
        }

        public String getEntityId() {
            return entityId;
        }

        public void setEntityId(String entityId) {
            this.entityId = entityId;
        }

        public String getEntityName() {
            return entityName;
        }

        public void setEntityName(String entityName) {
            this.entityName = entityName;
        }

        public String getEntityType() {
            return entityType;
        }

        public void setEntityType(String entityType) {
            this.entityType = entityType;
        }

        public String getEntityUniqueId() {
            return entityUniqueId;
        }

        public void setEntityUniqueId(String entityUniqueId) {
            this.entityUniqueId = entityUniqueId;
        }
    }

    public static class EntityEventTopicsBean {
        /**
         * entityId : baike_14900884
         * entityName : Uber
         * entityType : company
         * eventType : 2
         * eventTypeLabel : 上市
         */

        private String entityId;
        private String entityName;
        private String entityType;
        private int eventType;
        private String eventTypeLabel;

        public String getEntityId() {
            return entityId;
        }

        public void setEntityId(String entityId) {
            this.entityId = entityId;
        }

        public String getEntityName() {
            return entityName;
        }

        public void setEntityName(String entityName) {
            this.entityName = entityName;
        }

        public String getEntityType() {
            return entityType;
        }

        public void setEntityType(String entityType) {
            this.entityType = entityType;
        }

        public int getEventType() {
            return eventType;
        }

        public void setEventType(int eventType) {
            this.eventType = eventType;
        }

        public String getEventTypeLabel() {
            return eventTypeLabel;
        }

        public void setEventTypeLabel(String eventTypeLabel) {
            this.eventTypeLabel = eventTypeLabel;
        }
    }

    @Override
    public String toString() {
        return "TopicDetail{" +
                "id='" + id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", summary='" + summary + '\'' +
                ", title='" + title + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", timeline=" + timeline +
                ", order=" + order +
                ", hasInstantView=" + hasInstantView +
                ", entityTopics=" + entityTopics +
                ", newsArray=" + newsArray +
                ", entityEventTopics=" + entityEventTopics +
                '}';
    }
}
