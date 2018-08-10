package com.example.wwq_123.readhub.model.bean;

import java.io.Serializable;

public class ContentItem implements Serializable{
    private String title;
    private String summary;
    private String url;
    private String author;
    private String time;
    private String mobileUrl;

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ContentItem(){}
    public ContentItem(String title, String content) {
        this.title = title;
        this.summary = content;
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

    public void setSummary(String content) {
        this.summary = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String href) {
        this.url = href;
    }

    @Override
    public String toString() {
        return "ContentItem{" +
                "title='" + title + '\'' +
                ", content='" + summary + '\'' +
                ", href='" + url + '\'' +
                '}';
    }
}
