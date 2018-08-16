package com.example.wwq_123.readhub.mvc.model.jsonbean;


import java.util.List;

public class JobData extends Data{

    /**
     * data : [{"id":12601,"uuid":"c9ac69109b2b11e8b8d9","jobTitle":"平面设计","jobCount":118,"companyCount":116,"salaryLower":4,"salaryUpper":8,"experienceLower":3,"experienceUpper":5,"cities":{"北京":21,"深圳":17,"上海":11},"sources":{"脉脉":4,"内推网":1,"拉勾网":51,"BOSS 直聘":61,"阿里巴巴":1},"jobsArray":[{"id":2152164,"url":"https://www.zhipin.com/job_detail/c726135ef446e5c81XB53tq_FVE~.html","city":"上海","title":"平面/手绘创意设计师","company":"牧野国际教育","sponsor":false,"siteName":"BOSS 直聘","salaryLower":7,"salaryUpper":10,"experienceLower":1,"experienceUpper":3},{"id":2148524,"url":"https://www.zhipin.com/job_detail/5cd61304f1533bf21XB53tu-EFM~.html","city":"深圳","title":"资深平面设计师","company":"友谊书城","sponsor":false,"siteName":"BOSS 直聘","salaryLower":7,"salaryUpper":14,"experienceLower":1,"experienceUpper":3},{"id":2156081,"url":"https://www.zhipin.com/job_detail/f473794b61e531aa1XB50tq1E1o~.html","city":"南京","title":"平面设计主管/资深平面设计师 /平面设计","company":"金鹰国际健康中心","sponsor":false,"siteName":"BOSS 直聘","salaryLower":5,"salaryUpper":10,"experienceLower":3,"experienceUpper":5},{"id":2153494,"url":"https://www.zhipin.com/job_detail/93332c59e5b1e6e11XB53Nq7GFo~.html","city":"长春","title":"平面设计师","company":"军振实业","sponsor":false,"siteName":"BOSS 直聘","salaryLower":3,"salaryUpper":5,"experienceLower":1,"experienceUpper":3}],"publishDate":"2018-08-07T16:04:00.000Z","createdAt":"2018-08-08T16:58:00.671Z"},{"id":12600,"uuid":"c6b6726e9b2b11e8b8d9","jobTitle":"内容运营","jobCount":115,"companyCount":109,"salaryLower":8,"salaryUpper":12,"experienceLower":1,"experienceUpper":3,"cities":{"北京":38,"上海":16,"深圳":14},"sources":{"脉脉":1,"内推网":3,"拉勾网":88,"BOSS 直聘":21,"阿里巴巴":2},"jobsArray":[{"id":2155287,"url":"http://www.neitui.me/j/850519","city":"深圳","title":"存储备份工程师","company":"神州信息","sponsor":false,"siteName":"内推网","salaryLower":10,"salaryUpper":12,"experienceLower":1,"experienceUpper":3},{"id":2153773,"url":"https://job.alibaba.com/zhaopin/position_detail.htm?positionId=56278","city":"杭州","title":"新零售服务体验-内容运营专家-天猫出海","company":"阿里巴巴","sponsor":false,"siteName":"阿里巴巴","salaryLower":-1,"salaryUpper":-1,"experienceLower":5,"experienceUpper":-1},{"id":2152134,"url":"https://www.zhipin.com/job_detail/63d16b8201f710ad1XB53N65GVQ~.html","city":"北京","title":"幼儿产品运营","company":"科学队长","sponsor":false,"siteName":"BOSS 直聘","salaryLower":8,"salaryUpper":12,"experienceLower":1,"experienceUpper":3},{"id":2157493,"url":"https://www.lagou.com/jobs/4974239.html","city":"北京","title":"内容运营","company":"启名方科技（北京）有限公司","sponsor":false,"siteName":"拉勾网","salaryLower":10,"salaryUpper":15,"experienceLower":3,"experienceUpper":5}],"publishDate":"2018-08-07T16:03:50.000Z","createdAt":"2018-08-08T16:58:00.452Z"}]
     * pageSize : 2
     * totalItems : 809
     * totalPages : 405
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
         * id : 12601
         * uuid : c9ac69109b2b11e8b8d9
         * jobTitle : 平面设计
         * jobCount : 118
         * companyCount : 116
         * salaryLower : 4
         * salaryUpper : 8
         * experienceLower : 3
         * experienceUpper : 5
         * cities : {"北京":21,"深圳":17,"上海":11}
         * sources : {"脉脉":4,"内推网":1,"拉勾网":51,"BOSS 直聘":61,"阿里巴巴":1}
         * jobsArray : [{"id":2152164,"url":"https://www.zhipin.com/job_detail/c726135ef446e5c81XB53tq_FVE~.html","city":"上海","title":"平面/手绘创意设计师","company":"牧野国际教育","sponsor":false,"siteName":"BOSS 直聘","salaryLower":7,"salaryUpper":10,"experienceLower":1,"experienceUpper":3},{"id":2148524,"url":"https://www.zhipin.com/job_detail/5cd61304f1533bf21XB53tu-EFM~.html","city":"深圳","title":"资深平面设计师","company":"友谊书城","sponsor":false,"siteName":"BOSS 直聘","salaryLower":7,"salaryUpper":14,"experienceLower":1,"experienceUpper":3},{"id":2156081,"url":"https://www.zhipin.com/job_detail/f473794b61e531aa1XB50tq1E1o~.html","city":"南京","title":"平面设计主管/资深平面设计师 /平面设计","company":"金鹰国际健康中心","sponsor":false,"siteName":"BOSS 直聘","salaryLower":5,"salaryUpper":10,"experienceLower":3,"experienceUpper":5},{"id":2153494,"url":"https://www.zhipin.com/job_detail/93332c59e5b1e6e11XB53Nq7GFo~.html","city":"长春","title":"平面设计师","company":"军振实业","sponsor":false,"siteName":"BOSS 直聘","salaryLower":3,"salaryUpper":5,"experienceLower":1,"experienceUpper":3}]
         * publishDate : 2018-08-07T16:04:00.000Z
         * createdAt : 2018-08-08T16:58:00.671Z
         */

        private int id;
        private String uuid;
        private String jobTitle;
        private int jobCount;
        private int companyCount;
        private int salaryLower;
        private int salaryUpper;
        private int experienceLower;
        private int experienceUpper;
        private CitiesBean cities;
        private SourcesBean sources;
        private String publishDate;
        private String createdAt;
        private List<JobsArrayBean> jobsArray;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public int getJobCount() {
            return jobCount;
        }

        public void setJobCount(int jobCount) {
            this.jobCount = jobCount;
        }

        public int getCompanyCount() {
            return companyCount;
        }

        public void setCompanyCount(int companyCount) {
            this.companyCount = companyCount;
        }

        public int getSalaryLower() {
            return salaryLower;
        }

        public void setSalaryLower(int salaryLower) {
            this.salaryLower = salaryLower;
        }

        public int getSalaryUpper() {
            return salaryUpper;
        }

        public void setSalaryUpper(int salaryUpper) {
            this.salaryUpper = salaryUpper;
        }

        public int getExperienceLower() {
            return experienceLower;
        }

        public void setExperienceLower(int experienceLower) {
            this.experienceLower = experienceLower;
        }

        public int getExperienceUpper() {
            return experienceUpper;
        }

        public void setExperienceUpper(int experienceUpper) {
            this.experienceUpper = experienceUpper;
        }

        public CitiesBean getCities() {
            return cities;
        }

        public void setCities(CitiesBean cities) {
            this.cities = cities;
        }

        public SourcesBean getSources() {
            return sources;
        }

        public void setSources(SourcesBean sources) {
            this.sources = sources;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public List<JobsArrayBean> getJobsArray() {
            return jobsArray;
        }

        public void setJobsArray(List<JobsArrayBean> jobsArray) {
            this.jobsArray = jobsArray;
        }

        public static class CitiesBean {
            /**
             * 北京 : 21
             * 深圳 : 17
             * 上海 : 11
             */
            private String city;
            private int number;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }
        }

        public static class SourcesBean {
            /**
             * 脉脉 : 4
             * 内推网 : 1
             * 拉勾网 : 51
             * BOSS 直聘 : 61
             * 阿里巴巴 : 1
             */

            private String company;
            private int number;

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }
        }

        public static class JobsArrayBean {
            /**
             * id : 2152164
             * url : https://www.zhipin.com/job_detail/c726135ef446e5c81XB53tq_FVE~.html
             * city : 上海
             * title : 平面/手绘创意设计师
             * company : 牧野国际教育
             * sponsor : false
             * siteName : BOSS 直聘
             * salaryLower : 7
             * salaryUpper : 10
             * experienceLower : 1
             * experienceUpper : 3
             */

            private int id;
            private String url;
            private String city;
            private String title;
            private String company;
            private boolean sponsor;
            private String siteName;
            private int salaryLower;
            private int salaryUpper;
            private int experienceLower;
            private int experienceUpper;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public boolean isSponsor() {
                return sponsor;
            }

            public void setSponsor(boolean sponsor) {
                this.sponsor = sponsor;
            }

            public String getSiteName() {
                return siteName;
            }

            public void setSiteName(String siteName) {
                this.siteName = siteName;
            }

            public int getSalaryLower() {
                return salaryLower;
            }

            public void setSalaryLower(int salaryLower) {
                this.salaryLower = salaryLower;
            }

            public int getSalaryUpper() {
                return salaryUpper;
            }

            public void setSalaryUpper(int salaryUpper) {
                this.salaryUpper = salaryUpper;
            }

            public int getExperienceLower() {
                return experienceLower;
            }

            public void setExperienceLower(int experienceLower) {
                this.experienceLower = experienceLower;
            }

            public int getExperienceUpper() {
                return experienceUpper;
            }

            public void setExperienceUpper(int experienceUpper) {
                this.experienceUpper = experienceUpper;
            }
        }
    }
}
