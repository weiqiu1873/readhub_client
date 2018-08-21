package com.example.wwq_123.readhub.mvc.model.bean;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.Serializable;
import java.util.Objects;

/*
 ** 实体类
 * 开发者
 * 区块链
 */
public class DataItem implements Serializable{
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
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

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

    @Override
    public String toString() {
        return "DataItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", summaryAuto='" + summaryAuto + '\'' +
                ", url='" + url + '\'' +
                ", mobileUrl='" + mobileUrl + '\'' +
                ", siteName='" + siteName + '\'' +
                ", language='" + language + '\'' +
                ", authorName=" + authorName +
                ", publishDate='" + publishDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataItem dataItem = (DataItem) o;
        return id == dataItem.id;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
