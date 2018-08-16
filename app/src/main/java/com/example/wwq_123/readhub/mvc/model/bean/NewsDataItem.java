package com.example.wwq_123.readhub.mvc.model.bean;

import java.io.Serializable;

public class NewsDataItem extends DataItem implements Serializable{
    private String siteSlug;

    public String getSiteSlug() {
        return siteSlug;
    }

    public void setSiteSlug(String siteSlug) {
        this.siteSlug = siteSlug;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public String getSummary() {
        return super.getSummary();
    }

    @Override
    public void setSummary(String summary) {
        super.setSummary(summary);
    }

    @Override
    public String getSummaryAuto() {
        return super.getSummaryAuto();
    }

    @Override
    public void setSummaryAuto(String summaryAuto) {
        super.setSummaryAuto(summaryAuto);
    }

    @Override
    public String getUrl() {
        return super.getUrl();
    }

    @Override
    public void setUrl(String url) {
        super.setUrl(url);
    }

    @Override
    public String getMobileUrl() {
        return super.getMobileUrl();
    }

    @Override
    public void setMobileUrl(String mobileUrl) {
        super.setMobileUrl(mobileUrl);
    }

    @Override
    public String getSiteName() {
        return super.getSiteName();
    }

    @Override
    public void setSiteName(String siteName) {
        super.setSiteName(siteName);
    }

    @Override
    public String getLanguage() {
        return super.getLanguage();
    }

    @Override
    public void setLanguage(String language) {
        super.setLanguage(language);
    }

    @Override
    public Object getAuthorName() {
        return super.getAuthorName();
    }

    @Override
    public void setAuthorName(Object authorName) {
        super.setAuthorName(authorName);
    }

    @Override
    public String getPublishDate() {
        return super.getPublishDate();
    }

    @Override
    public void setPublishDate(String publishDate) {
        super.setPublishDate(publishDate);
    }

    @Override
    public String toString() {
        return "NewsDataItem{" +
                "siteSlug='" + siteSlug + '\'' +
                '}';
    }
}
