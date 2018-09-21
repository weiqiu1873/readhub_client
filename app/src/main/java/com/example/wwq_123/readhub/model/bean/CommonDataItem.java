package com.example.wwq_123.readhub.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/*
 ** 实体类
 * 资讯
 */
@Entity
public class CommonDataItem implements Parcelable{
    @Id
    private String id;
    private String title;
    private String summary;
    private String summaryAuto;
    private String url;
    private String mobileUrl;
    private String siteName;
    private String language;
    private String authorName;
    private String publishDate;
    private int status;

    protected CommonDataItem(Parcel in) {
        id = in.readString();
        title = in.readString();
        summary = in.readString();
        summaryAuto = in.readString();
        url = in.readString();
        mobileUrl = in.readString();
        siteName = in.readString();
        language = in.readString();
        authorName = in.readString();
        publishDate = in.readString();
        status = in.readInt();
    }

    @Generated(hash = 932351220)
    public CommonDataItem(String id, String title, String summary, String summaryAuto,
            String url, String mobileUrl, String siteName, String language, String authorName,
            String publishDate, int status) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.summaryAuto = summaryAuto;
        this.url = url;
        this.mobileUrl = mobileUrl;
        this.siteName = siteName;
        this.language = language;
        this.authorName = authorName;
        this.publishDate = publishDate;
        this.status = status;
    }

    @Generated(hash = 1311464411)
    public CommonDataItem() {
    }

    public static final Creator<CommonDataItem> CREATOR = new Creator<CommonDataItem>() {
        @Override
        public CommonDataItem createFromParcel(Parcel in) {
            return new CommonDataItem(in);
        }

        @Override
        public CommonDataItem[] newArray(int size) {
            return new CommonDataItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.summary);
        dest.writeString(this.summaryAuto);
        dest.writeString(this.url);
        dest.writeString(this.mobileUrl);
        dest.writeString(this.siteName);
        dest.writeString(this.language);
        dest.writeString(this.authorName);
        dest.writeString(this.publishDate);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public String toString() {
        return "CommonDataItem{" +
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
        CommonDataItem dataItem = (CommonDataItem) o;
        return id == dataItem.id;
    }
}
