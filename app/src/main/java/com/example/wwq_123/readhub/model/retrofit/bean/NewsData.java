package com.example.wwq_123.readhub.model.retrofit.bean;

import java.util.List;

public class NewsData extends Data{


    /**
     * data : [{"id":19581842,"title":"最前线丨网易二季度营收24.6亿美元，游戏业务复苏结束净利润下滑局面","summary":"财报显示，截至2018年6月30日，网易2018年第二季度净收入为24.6亿美元（约合162.84亿元人民币），同比增长21.7% ... 基于非美国通用会计准则(Non-GAAP)，归属于网易公司股东的净利润为4.12亿美元（约合27亿元人民币），较去年同期相比上涨107%，结束了此前9个月的净利润下滑 ... 网易的业绩上涨，主要还是因其支柱业务在线游戏服务的净收入同比上涨6.7%至15亿美元","summaryAuto":"财报显示，截至2018年6月30日，网易2018年第二季度净收入为24.6亿美元（约合162.84亿元人民币），同比增长21.7% ... 基于非美国通用会计准则(Non-GAAP)，归属于网易公司股东的净利润为4.12亿美元（约合27亿元人民币），较去年同期相比上涨107%，结束了此前9个月的净利润下滑 ... 网易的业绩上涨，主要还是因其支柱业务在线游戏服务的净收入同比上涨6.7%至15亿美元（约合101亿元人民币）。","url":"http://36kr.com/p/5147302.html?ktm_source=feed","mobileUrl":"http://36kr.com/p/5147302.html?ktm_source=feed","siteName":"36氪","siteSlug":"rss_36kr","language":"zh-cn","authorName":"彭倩","publishDate":"2018-08-09T00:25:02.000Z"},{"id":19581843,"title":"Magic Leap 新品在美开售，15670 元起；SEC 就马斯克发推称考虑私有化一事发询问函；知乎完成 E 轮融资 2.7 亿美元 | 极客早知道","summary":"SEC 就马斯克发推称考虑私有化一事发询问函据报道，美国证券交易委员会（SEC）已向特斯拉询问马斯克关于将该公司私有化的推文 ... Magic Leap 在昨晚在官网上架 Magic Leap One Creator Edition（创造者版本），价格定为 2295 美元（约人民币 15670 元），即日发售，现阶段仅面向美国部分地区提供，但未来会向更多地区供货 ... 昨日，知乎 CEO 周源","summaryAuto":"SEC 就马斯克发推称考虑私有化一事发询问函据报道，美国证券交易委员会（SEC）已向特斯拉询问马斯克关于将该公司私有化的推文 ... Magic Leap 在昨晚在官网上架 Magic Leap One Creator Edition（创造者版本），价格定为 2295 美元（约人民币 15670 元），即日发售，现阶段仅面向美国部分地区提供，但未来会向更多地区供货 ... 昨日，知乎 CEO 周源在「海盐计划」发布会上，正式宣布，知乎已完成 2.7 亿美元 E 轮融资。","url":"http://www.geekpark.net/news/231807","mobileUrl":"http://www.geekpark.net/news/231807","siteName":"极客公园","siteSlug":"rss_geekpark","language":"zh-cn","authorName":null,"publishDate":"2018-08-09T00:24:49.000Z"}]
     * pageSize : 2
     * totalItems : 40263
     * totalPages : 20132
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
         * id : 19581842
         * title : 最前线丨网易二季度营收24.6亿美元，游戏业务复苏结束净利润下滑局面
         * summary : 财报显示，截至2018年6月30日，网易2018年第二季度净收入为24.6亿美元（约合162.84亿元人民币），同比增长21.7% ... 基于非美国通用会计准则(Non-GAAP)，归属于网易公司股东的净利润为4.12亿美元（约合27亿元人民币），较去年同期相比上涨107%，结束了此前9个月的净利润下滑 ... 网易的业绩上涨，主要还是因其支柱业务在线游戏服务的净收入同比上涨6.7%至15亿美元
         * summaryAuto : 财报显示，截至2018年6月30日，网易2018年第二季度净收入为24.6亿美元（约合162.84亿元人民币），同比增长21.7% ... 基于非美国通用会计准则(Non-GAAP)，归属于网易公司股东的净利润为4.12亿美元（约合27亿元人民币），较去年同期相比上涨107%，结束了此前9个月的净利润下滑 ... 网易的业绩上涨，主要还是因其支柱业务在线游戏服务的净收入同比上涨6.7%至15亿美元（约合101亿元人民币）。
         * url : http://36kr.com/p/5147302.html?ktm_source=feed
         * mobileUrl : http://36kr.com/p/5147302.html?ktm_source=feed
         * siteName : 36氪
         * siteSlug : rss_36kr
         * language : zh-cn
         * authorName : 彭倩
         * publishDate : 2018-08-09T00:25:02.000Z
         */

        private int id;
        private String title;
        private String summary;
        private String summaryAuto;
        private String url;
        private String mobileUrl;
        private String siteName;
        private String siteSlug;
        private String language;
        private String authorName;
        private String publishDate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getSummaryAuto() {
            return summaryAuto;
        }

        public void setSummaryAuto(String summaryAuto) {
            this.summaryAuto = summaryAuto;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMobileUrl() {
            return mobileUrl;
        }

        public void setMobileUrl(String mobileUrl) {
            this.mobileUrl = mobileUrl;
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

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }
    }
}
