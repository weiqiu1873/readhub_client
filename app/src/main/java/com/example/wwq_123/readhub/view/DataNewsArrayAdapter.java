package com.example.wwq_123.readhub.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.model.bean.NewsDataItem;

import java.util.List;

public class DataNewsArrayAdapter extends RecyclerView.Adapter {

    private List<NewsDataItem> newsArray;
    private Context context;
    private LayoutInflater inflater;

    public DataNewsArrayAdapter(Context context,List<NewsDataItem> list){
        this.newsArray = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.newsarray_recycleview_item,parent,false);
        NewViewHolder holder = new NewViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        NewViewHolder viewHolder = (NewViewHolder) holder;
        viewHolder.company.setText(newsArray.get(position).getSiteName());
        viewHolder.title.setText(newsArray.get(position).getTitle());
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        viewHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用默认浏览器打开网页
                Uri uri = Uri.parse(newsArray.get(position).getMobileUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsArray.size();
    }

    public class NewViewHolder extends RecyclerView.ViewHolder{

        private TextView company;
        private TextView title;
        public NewViewHolder(View itemView) {
            super(itemView);
            company = itemView.findViewById(R.id.new_company);
            title = itemView.findViewById(R.id.new_title);
        }
    }
}
