package com.example.wwq_123.readhub.model.bean;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;

import com.example.wwq_123.readhub.model.bean.converter.CommonDataItemStringConverter;
import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;
import java.util.Objects;

@Entity
public class TopicDataItem implements Parcelable{
    @Id
    private String url;
    private String createdAt;
    private int order;
    private String publishDate;
    private String summary;
    private String title;
    private String updatedAt;
    private String timeline;
    @Convert(columnType = String.class,converter = CommonDataItemStringConverter.class)
    private List<CommonDataItem> newsArray;

    protected TopicDataItem(Parcel in) {
        url = in.readString();
        createdAt = in.readString();
        order = in.readInt();
        publishDate = in.readString();
        summary = in.readString();
        title = in.readString();
        updatedAt = in.readString();
        timeline = in.readParcelable(TopicTimeLine.class.getClassLoader());
        newsArray = in.createTypedArrayList(CommonDataItem.CREATOR);
    }



    @Generated(hash = 696114999)
    public TopicDataItem(String url, String createdAt, int order, String publishDate,
            String summary, String title, String updatedAt, String timeline,
            List<CommonDataItem> newsArray) {
        this.url = url;
        this.createdAt = createdAt;
        this.order = order;
        this.publishDate = publishDate;
        this.summary = summary;
        this.title = title;
        this.updatedAt = updatedAt;
        this.timeline = timeline;
        this.newsArray = newsArray;
    }



    @Generated(hash = 2010197782)
    public TopicDataItem() {
    }


    public static final Creator<TopicDataItem> CREATOR = new Creator<TopicDataItem>() {
        @Override
        public TopicDataItem createFromParcel(Parcel in) {
            return new TopicDataItem(in);
        }

        @Override
        public TopicDataItem[] newArray(int size) {
            return new TopicDataItem[size];
        }
    };

    public String getUrl() {
        return url;
    }

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

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTimeline() {
        return timeline;
    }

    public void setTimeline(String timeline) {
        this.timeline = timeline;
    }

    public List<CommonDataItem> getNewsArray() {
        return newsArray;
    }

    public void setNewsArray(List<CommonDataItem> newsArray) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TopicDataItem that = (TopicDataItem) o;
        return order == that.order;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.createdAt);
        dest.writeTypedList(newsArray);
        dest.writeLong(this.order);
        dest.writeString(this.publishDate);
        dest.writeString(this.summary);
        dest.writeString(this.title);
        dest.writeString(this.updatedAt);
        dest.writeString(this.timeline);
    }
}
