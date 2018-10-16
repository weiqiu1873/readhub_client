package com.example.wwq_123.readhub.model.bean;

import java.io.Serializable;
import java.util.List;

public class JobDataItem implements Serializable{

    private long id;
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
    private List<JobArrayBean> jobsArray;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<JobArrayBean> getJobsArray() {
        return jobsArray;
    }

    public void setJobsArray(List<JobArrayBean> jobsArray) {
        this.jobsArray = jobsArray;
    }

    public static class CityBean implements Serializable{
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

    public static class SourceBean implements Serializable{
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
