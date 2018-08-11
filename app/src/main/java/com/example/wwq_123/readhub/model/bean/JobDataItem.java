package com.example.wwq_123.readhub.model.bean;

import java.util.List;

public class JobDataItem extends DataItem{
    private int id;
    private String uuid;
    private String jobTitle;
    private int jobCount;
    private int companyCount;
    private int salaryLower;
    private int salaryUpper;
    private int experienceLower;
    private int experienceUpper;
    private List<CityBean> cities;
    private List<SourceBean> sources;
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

    public List<CityBean> getCities() {
        return cities;
    }

    public void setCities(List<CityBean> cities) {
        this.cities = cities;
    }

    public List<SourceBean> getSources() {
        return sources;
    }

    public void setSources(List<SourceBean> sources) {
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

    public static class CityBean {
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

    public static class SourceBean {
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

    @Override
    public String toString() {
        return "JobDataItem{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobCount=" + jobCount +
                ", companyCount=" + companyCount +
                ", salaryLower=" + salaryLower +
                ", salaryUpper=" + salaryUpper +
                ", experienceLower=" + experienceLower +
                ", experienceUpper=" + experienceUpper +
                ", cities=" + cities +
                ", sources=" + sources +
                ", publishDate='" + publishDate + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", jobsArray=" + jobsArray +
                '}';
    }
}
