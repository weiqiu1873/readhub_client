package com.example.wwq_123.readhub.model.bean.converter;

import com.example.wwq_123.readhub.model.bean.TimeLineBean;
import org.greenrobot.greendao.converter.PropertyConverter;

public class TimeLineStringConverter implements PropertyConverter<TimeLineBean,String> {
    @Override
    public TimeLineBean convertToEntityProperty(String databaseValue) {
        return null;
    }

    @Override
    public String convertToDatabaseValue(TimeLineBean entityProperty) {
        return null;
    }
}
