package com.example.wwq_123.readhub.util;

import com.example.wwq_123.readhub.model.bean.ContentItem;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    public static List<ContentItem> getNews(String jsonData){
        List<ContentItem> contentItems = new ArrayList<>();

        try {
            JSONObject json = new JSONObject(jsonData);
            JSONArray jsonArray = json.getJSONArray("data");
            for (int i=0;i<jsonArray.length();i++){
                ContentItem contentItem = new ContentItem();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                contentItem.setTitle(jsonObject.getString("title"));
                contentItem.setSummary(jsonObject.getString("summary"));
                contentItem.setUrl(jsonObject.getString("url"));
                contentItem.setAuthor(jsonObject.getString("authorName"));
                contentItem.setMobileUrl(jsonObject.getString("mobileUrl"));
                contentItems.add(contentItem);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return contentItems;
    }
}
