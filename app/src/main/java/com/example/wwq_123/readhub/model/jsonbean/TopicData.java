package com.example.wwq_123.readhub.model.jsonbean;


import java.util.List;

public class TopicData extends Data{


    /**
     * data : [{"id":"1sizAvg8GCf","createdAt":"2018-08-08T07:31:03.679Z","newsArray":[{"id":19578500,"url":"https://tech.sina.com.cn/mobile/n/n/2018-08-08/doc-ihhkuskt7617752.shtml","title":"谷歌Pixel 3 XL配置揭晓：骁龙845+4GB内存","groupId":1,"siteName":"新浪","siteSlug":"rss_sina","mobileUrl":"https://tech.sina.com.cn/mobile/n/n/2018-08-08/doc-ihhkuskt7617752.shtml","authorName":"","duplicateId":1,"publishDate":"2018-08-08T06:05:17.000Z"},{"id":19580363,"url":"\n\t\thttps://www.pingwest.com/w/175764\n\t\t","title":"谷歌Pixel 3 XL配置揭晓：骁龙845+4GB内存","groupId":1,"siteName":"品玩","siteSlug":"rss_pingwest","mobileUrl":"\n\t\thttps://www.pingwest.com/w/175764\n\t\t","authorName":" 杜雪 ","duplicateId":1,"publishDate":"2018-08-08T15:01:46.000Z"}],"order":59610,"publishDate":"2018-08-08T13:35:38.082Z","summary":"鲁大师官方微博公布了Pixel 3 XL的跑分成绩，数据显示Pixel 3 XL成绩为212778分，在鲁大师的跑分数据库中位于较高水准 ... 鲁大师数据库并未提到Pixel 3 XL的相机数据，而相机一直都是Pixel系列手机的强项，关注度非常高 ... 过去Pixel 手机也都并不是以设计取胜，或许作为谷歌的\u201c亲儿子\u201d，他们的系统升级速度足够快就足够了。","title":"谷歌Pixel 3 XL配置揭晓：骁龙845+4GB内存","updatedAt":"2018-08-08T18:30:18.990Z","timeline":null,"extra":{"instantView":true}},{"id":"1jWgwd7nMxx","createdAt":"2018-08-08T07:25:23.622Z","newsArray":[{"id":19578530,"url":"https://tech.sina.com.cn/it/2018-08-08/doc-ihhkuskt7870821.shtml","title":"东芝最新财季净利润创历史记录：出售芯片业务获利多","groupId":1,"siteName":"新浪","siteSlug":"rss_sina","mobileUrl":"https://tech.sina.com.cn/it/2018-08-08/doc-ihhkuskt7870821.shtml","authorName":"","duplicateId":1,"publishDate":"2018-08-08T06:34:46.000Z"},{"id":19578589,"url":"\n\t\thttps://www.pingwest.com/w/175738\n\t\t","title":"东芝一季度净利润达91.6亿美元，创历史纪录","groupId":2,"siteName":"品玩","siteSlug":"rss_pingwest","mobileUrl":"\n\t\thttps://www.pingwest.com/w/175738\n\t\t","authorName":" 李晓贤 ","duplicateId":2,"publishDate":"2018-08-08T06:51:55.000Z"}],"order":59606,"publishDate":"2018-08-08T07:25:23.657Z","summary":"东芝周三公布其2018财年第一财季财报。财报显示，今年4-6月，东芝净销售额达8423亿日元，实现净利润1.02万亿日元（约合91.6亿美元），同比增长120.7%，创下历史纪录，去年同期为503.3亿日元，原因是该公司通过出售全球第二大NAND芯片业务给贝恩资本领导的财团，获利9660亿日元 ... 就旗下没有了宝贵的闪存芯片业务之后其未来的增长源将来自哪里，东芝并没有说明 ... 此外，东芝还根据此前承诺，宣布了一项63亿美元股票回购计划，该计划将在6月进行，金额高于预期。\n\n","title":"东芝一季度净利润达91.6亿美元，创历史纪录","updatedAt":"2018-08-08T07:34:51.250Z","timeline":null,"extra":{"instantView":true}}]
     * pageSize : 10
     * totalItems : 20795
     * totalPages : 2080
     */

    private int pageSize;
    private int totalItems;
    private int totalPages;
    private List<DataBean> data;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1sizAvg8GCf
         * createdAt : 2018-08-08T07:31:03.679Z
         * newsArray : [{"id":19578500,"url":"https://tech.sina.com.cn/mobile/n/n/2018-08-08/doc-ihhkuskt7617752.shtml","title":"谷歌Pixel 3 XL配置揭晓：骁龙845+4GB内存","groupId":1,"siteName":"新浪","siteSlug":"rss_sina","mobileUrl":"https://tech.sina.com.cn/mobile/n/n/2018-08-08/doc-ihhkuskt7617752.shtml","authorName":"","duplicateId":1,"publishDate":"2018-08-08T06:05:17.000Z"},{"id":19580363,"url":"\n\t\thttps://www.pingwest.com/w/175764\n\t\t","title":"谷歌Pixel 3 XL配置揭晓：骁龙845+4GB内存","groupId":1,"siteName":"品玩","siteSlug":"rss_pingwest","mobileUrl":"\n\t\thttps://www.pingwest.com/w/175764\n\t\t","authorName":" 杜雪 ","duplicateId":1,"publishDate":"2018-08-08T15:01:46.000Z"}]
         * order : 59610
         * publishDate : 2018-08-08T13:35:38.082Z
         * summary : 鲁大师官方微博公布了Pixel 3 XL的跑分成绩，数据显示Pixel 3 XL成绩为212778分，在鲁大师的跑分数据库中位于较高水准 ... 鲁大师数据库并未提到Pixel 3 XL的相机数据，而相机一直都是Pixel系列手机的强项，关注度非常高 ... 过去Pixel 手机也都并不是以设计取胜，或许作为谷歌的“亲儿子”，他们的系统升级速度足够快就足够了。
         * title : 谷歌Pixel 3 XL配置揭晓：骁龙845+4GB内存
         * updatedAt : 2018-08-08T18:30:18.990Z
         * timeline : null
         * extra : {"instantView":true}
         */

        private String id;
        private String createdAt;
        private int order;
        private String publishDate;
        private String summary;
        private String title;
        private String updatedAt;
        private String timeline;
        private ExtraBean extra;
        private List<NewsArrayBean> newsArray;

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

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
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

        public String getTimeline() {
            return timeline;
        }

        public void setTimeline(String timeline) {
            this.timeline = timeline;
        }

        public ExtraBean getExtra() {
            return extra;
        }

        public void setExtra(ExtraBean extra) {
            this.extra = extra;
        }

        public List<NewsArrayBean> getNewsArray() {
            return newsArray;
        }

        public void setNewsArray(List<NewsArrayBean> newsArray) {
            this.newsArray = newsArray;
        }

        public static class ExtraBean {
            /**
             * instantView : true
             */

            private boolean instantView;

            public boolean isInstantView() {
                return instantView;
            }

            public void setInstantView(boolean instantView) {
                this.instantView = instantView;
            }
        }

        public static class NewsArrayBean {
            /**
             * id : 19578500
             * url : https://tech.sina.com.cn/mobile/n/n/2018-08-08/doc-ihhkuskt7617752.shtml
             * title : 谷歌Pixel 3 XL配置揭晓：骁龙845+4GB内存
             * groupId : 1
             * siteName : 新浪
             * siteSlug : rss_sina
             * mobileUrl : https://tech.sina.com.cn/mobile/n/n/2018-08-08/doc-ihhkuskt7617752.shtml
             * authorName :
             * duplicateId : 1
             * publishDate : 2018-08-08T06:05:17.000Z
             */

            private String id;
            private String url;
            private String title;
            private int groupId;
            private String siteName;
            private String siteSlug;
            private String mobileUrl;
            private String authorName;
            private int duplicateId;
            private String publishDate;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getGroupId() {
                return groupId;
            }

            public void setGroupId(int groupId) {
                this.groupId = groupId;
            }

            public String getSiteName() {
                return siteName;
            }

            public void setSiteName(String siteName) {
                this.siteName = siteName;
            }

            public String getSiteSlug() {
                return siteSlug;
            }

            public void setSiteSlug(String siteSlug) {
                this.siteSlug = siteSlug;
            }

            public String getMobileUrl() {
                return mobileUrl;
            }

            public void setMobileUrl(String mobileUrl) {
                this.mobileUrl = mobileUrl;
            }

            public String getAuthorName() {
                return authorName;
            }

            public void setAuthorName(String authorName) {
                this.authorName = authorName;
            }

            public int getDuplicateId() {
                return duplicateId;
            }

            public void setDuplicateId(int duplicateId) {
                this.duplicateId = duplicateId;
            }

            public String getPublishDate() {
                return publishDate;
            }

            public void setPublishDate(String publishDate) {
                this.publishDate = publishDate;
            }
        }
    }
}
