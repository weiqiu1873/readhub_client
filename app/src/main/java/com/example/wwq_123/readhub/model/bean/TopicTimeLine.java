package com.example.wwq_123.readhub.model.jsonbean.bean;

import android.os.Parcel;
import android.os.Parcelable;


public class TopicTimeLine implements Parcelable{
    private String id;
    private String title;
    private String createAt;

    public TopicTimeLine(){}

    protected TopicTimeLine(Parcel in) {
        id = in.readString();
        title = in.readString();
        createAt = in.readString();
    }

    public static final Creator<TopicTimeLine> CREATOR = new Creator<TopicTimeLine>() {
        @Override
        public TopicTimeLine createFromParcel(Parcel in) {
            return new TopicTimeLine(in);
        }

        @Override
        public TopicTimeLine[] newArray(int size) {
            return new TopicTimeLine[size];
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
        dest.writeString(this.createAt);
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

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
