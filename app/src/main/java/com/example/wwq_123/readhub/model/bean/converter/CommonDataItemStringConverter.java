package com.example.wwq_123.readhub.model.bean.converter;

import com.example.wwq_123.readhub.model.jsonbean.bean.CommonDataItem;
import org.greenrobot.greendao.converter.PropertyConverter;
import java.util.List;

public class CommonDataItemStringConverter implements PropertyConverter<List<CommonDataItem>,String> {

    @Override
    public List<CommonDataItem> convertToEntityProperty(String databaseValue) {
        return null;
    }

    @Override
    public String convertToDatabaseValue(List<CommonDataItem> entityProperty) {
        return "";
    }

}
