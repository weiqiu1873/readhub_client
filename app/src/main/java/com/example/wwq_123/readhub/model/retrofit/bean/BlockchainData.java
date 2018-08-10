package com.example.wwq_123.readhub.model.retrofit.bean;


import java.util.List;

public class BlockchainData extends Data{

    /**
     * data : [{"id":19581850,"title":"武汉市合作创建检察区块链联合实验室","summary":"各单位代表到区块链联合实验室进行实地考察，为联合办公场所建设及项目研发建言献策 ... 该实验室将以检察区块链研究为主要方向，探索区块链技术在检察机关的应用。","summaryAuto":"各单位代表到区块链联合实验室进行实地考察，为联合办公场所建设及项目研发建言献策 ... 该实验室将以检察区块链研究为主要方向，探索区块链技术在检察机关的应用。","url":"http://www.bishijie.com/home/newsflashpc/detail?id=88630","mobileUrl":"http://www.bishijie.com/home/newsflashpc/detail?id=88630","siteName":"币世界","language":"zh-cn","authorName":null,"publishDate":"2018-08-09T00:25:46.000Z"},{"id":19581851,"title":"菲律宾正在建设亚洲\u201c加密谷\u201d","summary":"据bitcoin消息，菲律宾卡加延经济区管理局（CEZA）与Northern Star Gaming&Resorts ... Inc合作开发了一个名为Crypto Valley of Asia（CVA）的加密和金融科技中心 ... CEZA管理员兼首席执行官Raul L. Lambino在官方新闻声明中评论：\u201c这个基础设施将吸引更多外国投资者和全球金融科技公司到CEZA和菲律宾。","summaryAuto":"据bitcoin消息，菲律宾卡加延经济区管理局（CEZA）与Northern Star Gaming&Resorts ... Inc合作开发了一个名为Crypto Valley of Asia（CVA）的加密和金融科技中心 ... CEZA管理员兼首席执行官Raul L. Lambino在官方新闻声明中评论：\u201c这个基础设施将吸引更多外国投资者和全球金融科技公司到CEZA和菲律宾。","url":"http://www.bishijie.com/home/newsflashpc/detail?id=88628","mobileUrl":"http://www.bishijie.com/home/newsflashpc/detail?id=88628","siteName":"币世界","language":"zh-cn","authorName":null,"publishDate":"2018-08-09T00:24:16.000Z"}]
     * pageSize : 2
     * totalItems : 5880
     * totalPages : 2940
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
         * id : 19581850
         * title : 武汉市合作创建检察区块链联合实验室
         * summary : 各单位代表到区块链联合实验室进行实地考察，为联合办公场所建设及项目研发建言献策 ... 该实验室将以检察区块链研究为主要方向，探索区块链技术在检察机关的应用。
         * summaryAuto : 各单位代表到区块链联合实验室进行实地考察，为联合办公场所建设及项目研发建言献策 ... 该实验室将以检察区块链研究为主要方向，探索区块链技术在检察机关的应用。
         * url : http://www.bishijie.com/home/newsflashpc/detail?id=88630
         * mobileUrl : http://www.bishijie.com/home/newsflashpc/detail?id=88630
         * siteName : 币世界
         * language : zh-cn
         * authorName : null
         * publishDate : 2018-08-09T00:25:46.000Z
         */

        private int id;
        private String title;
        private String summary;
        private String summaryAuto;
        private String url;
        private String mobileUrl;
        private String siteName;
        private String language;
        private Object authorName;
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

        public Object getAuthorName() {
            return authorName;
        }

        public void setAuthorName(Object authorName) {
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
