package com.example.wwq_123.readhub.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JobArrayBean extends BaseDataItem implements Serializable{

    private static final long serialVersionUID = -2841683698604626615L;
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
    @Id
    private String id;
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

    @Generated(hash = 760781272)
    public JobArrayBean(String id, String url, String city, String title,
            String company, boolean sponsor, String siteName, int salaryLower,
            int salaryUpper, int experienceLower, int experienceUpper) {
        this.id = id;
        this.url = url;
        this.city = city;
        this.title = title;
        this.company = company;
        this.sponsor = sponsor;
        this.siteName = siteName;
        this.salaryLower = salaryLower;
        this.salaryUpper = salaryUpper;
        this.experienceLower = experienceLower;
        this.experienceUpper = experienceUpper;
    }

    @Generated(hash = 1656417393)
    public JobArrayBean() {
    }

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

    public boolean getSponsor() {
        return this.sponsor;
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

    @Override
    public String toString() {
        return "JobArrayBean{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", city='" + city + '\'' +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", sponsor=" + sponsor +
                ", siteName='" + siteName + '\'' +
                ", salaryLower=" + salaryLower +
                ", salaryUpper=" + salaryUpper +
                ", experienceLower=" + experienceLower +
                ", experienceUpper=" + experienceUpper +
                '}';
    }
}
