package com.example.wwq_123.readhub.model.jsonbean;

import java.util.List;

public class TechData extends Data{

    /**
     * data : [{"id":19581808,"title":"当XSS遇上CSRF，看我打出这套组合技","summary":"今天我们来介绍一个场景，当 xss 遇上 csrf 的时候，是否能打出一套漂亮的组合技能 ... 0×03、然后开始导入 sql 语句进 zvuldrill 数据库 ... Source F:/wamp/www/ZVulDrill/sys/zvuldrill.sql。","summaryAuto":"今天我们来介绍一个场景，当 xss 遇上 csrf 的时候，是否能打出一套漂亮的组合技能 ... 0×03、然后开始导入 sql 语句进 zvuldrill 数据库 ... Source F:/wamp/www/ZVulDrill/sys/zvuldrill.sql。","url":"http://www.freebuf.com/vuls/179846.html","mobileUrl":"http://www.freebuf.com/vuls/179846.html","siteName":"FreeBuf","language":"zh-cn","authorName":"CanMeng","publishDate":"2018-08-09T00:00:10.000Z"},{"id":19581832,"title":"面向桌面开发的Windows Template Studio","summary":"在过去的二十年里，开发Windows应用程序所需的样板代码的数量急剧增加，这是由于.Net早期是源于RAD或快速应用程序开发框架 ... 微软试图通过面向UWP应用程序的Windows Template Studio来解决这个问题。","summaryAuto":"在过去的二十年里，开发Windows应用程序所需的样板代码的数量急剧增加，这是由于.Net早期是源于RAD或快速应用程序开发框架 ... 微软试图通过面向UWP应用程序的Windows Template Studio来解决这个问题。","url":"http://www.infoq.com/cn/news/2018/08/Windows-Template-Studio?utm_campaign=infoq_content&utm_source=infoq&utm_medium=feed&utm_term=global","mobileUrl":"http://www.infoq.com/cn/news/2018/08/Windows-Template-Studio?utm_campaign=infoq_content&utm_source=infoq&utm_medium=feed&utm_term=global","siteName":"InfoQ","language":"zh-cn","authorName":"Jonathan Allen","publishDate":"2018-08-09T00:00:00.000Z"}]
     * pageSize : 2
     * totalItems : 2316
     * totalPages : 1158
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
         * id : 19581808
         * title : 当XSS遇上CSRF，看我打出这套组合技
         * summary : 今天我们来介绍一个场景，当 xss 遇上 csrf 的时候，是否能打出一套漂亮的组合技能 ... 0×03、然后开始导入 sql 语句进 zvuldrill 数据库 ... Source F:/wamp/www/ZVulDrill/sys/zvuldrill.sql。
         * summaryAuto : 今天我们来介绍一个场景，当 xss 遇上 csrf 的时候，是否能打出一套漂亮的组合技能 ... 0×03、然后开始导入 sql 语句进 zvuldrill 数据库 ... Source F:/wamp/www/ZVulDrill/sys/zvuldrill.sql。
         * url : http://www.freebuf.com/vuls/179846.html
         * mobileUrl : http://www.freebuf.com/vuls/179846.html
         * siteName : FreeBuf
         * language : zh-cn
         * authorName : CanMeng
         * publishDate : 2018-08-09T00:00:10.000Z
         */

        private int id;
        private String title;
        private String summary;
        private String summaryAuto;
        private String url;
        private String mobileUrl;
        private String siteName;
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
