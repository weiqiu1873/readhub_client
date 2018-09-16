package com.example.wwq_123.readhub.view.topic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;

import java.util.ArrayList;
import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<TopicDataItem> topicList = new ArrayList<>();
    private boolean showDelete;

    public TopicAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_topic,parent,false);
        return new TopicViewHolder(context,view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (showDelete){
            ((TopicViewHolder)holder).showDelete();
        }
        ((TopicViewHolder)holder).onBind(topicList.get(position));
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    public void updateTopic(List<TopicDataItem> topicDataItems){
        topicList.clear();
        topicList.addAll(topicDataItems);
        notifyDataSetChanged();
    }
    public void addTopic(List<TopicDataItem> topicDataItems){
        topicList.addAll(topicDataItems);
        notifyDataSetChanged();
    }

    public void showDelete(boolean arg){
        showDelete = arg;
    }

    public void remove(TopicDataItem topic){
        topicList.remove(topic);
        notifyDataSetChanged();
    }
}
