package com.example.wwq_123.readhub.model.bean;

import java.io.Serializable;
import java.util.List;

public class TopicDataItem extends DataItem implements Serializable{
    private String url;     //id
    private String createdAt;
    private int order;
    private String publishDate;
    private String summary;
    private String title;
    private String updatedAt;
    private Object timeline;
    private List<NewsDataItem> newsArray;

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
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

    @Override
    public String getPublishDate() {
        return publishDate;
    }

    @Override
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String getSummary() {
        return summary;
    }

    @Override
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getTimeline() {
        return timeline;
    }

    public void setTimeline(Object timeline) {
        this.timeline = timeline;
    }

    public List<NewsDataItem> getNewsArray() {
        return newsArray;
    }

    public void setNewsArray(List<NewsDataItem> newsArray) {
        this.newsArray = newsArray;
    }

    @Override
    public String toString() {
        return "TopicDataItem{" +
                "url='" + url + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", order=" + order +
                ", publishDate='" + publishDate + '\'' +
                ", summary='" + summary + '\'' +
                ", title='" + title + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", timeline=" + timeline +
                ", newsArray=" + newsArray +
                '}';
    }
}
