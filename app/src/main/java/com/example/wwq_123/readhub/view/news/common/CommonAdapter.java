package com.example.wwq_123.readhub.view.news.common;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.model.jsonbean.bean.CommonDataItem;


import java.util.ArrayList;
import java.util.List;

public class CommonAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<CommonDataItem> dataItems = new ArrayList<>();

    public CommonAdapter(Context context){ this.context = context; }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_common,parent,false);
        return new CommonViewHolder(context,view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((CommonViewHolder)holder).onBind(dataItems.get(position));
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public void updateData(List<? extends CommonDataItem> list){
        dataItems.clear();
        dataItems.addAll(list);
        notifyDataSetChanged();
    }
    public void addData(List<? extends CommonDataItem> list){
        dataItems.addAll(list);
        notifyDataSetChanged();
    }
}
