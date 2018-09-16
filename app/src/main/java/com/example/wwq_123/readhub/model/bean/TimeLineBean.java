package com.example.wwq_123.readhub.model.bean;

import android.os.Parcel;
import android.os.Parcelable;


import com.example.wwq_123.readhub.model.jsonbean.bean.TopicTimeLine;

import java.util.List;

public class TimeLineBean implements Parcelable {
    private List<TopicTimeLine> timeLineList;

    public TimeLineBean(){}

    protected TimeLineBean(Parcel in) {
        timeLineList = in.createTypedArrayList(TopicTimeLine.CREATOR);
    }

    public static final Creator<TimeLineBean> CREATOR = new Creator<TimeLineBean>() {
        @Override
        public TimeLineBean createFromParcel(Parcel in) {
            return new TimeLineBean(in);
        }

        @Override
        public TimeLineBean[] newArray(int size) {
            return new TimeLineBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(timeLineList);
    }

    public List<TopicTimeLine> getTimeLineList() {
        return timeLineList;
    }

    public void setTimeLineList(List<TopicTimeLine> timeLineList) {
        this.timeLineList = timeLineList;
    }
}
