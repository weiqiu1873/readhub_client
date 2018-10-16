package com.example.wwq_123.readhub.view.favoritejob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.model.bean.JobArrayBean;
import java.util.ArrayList;
import java.util.List;

public class FavoriteJobAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private boolean showdelete;
    private LayoutInflater inflater;
    private List<JobArrayBean> jobList = new ArrayList<>();

    public FavoriteJobAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setList(List<JobArrayBean> list){
        jobList.clear();
        jobList.addAll(list);
        notifyDataSetChanged();
    }

    public void delete(JobArrayBean bean){
        jobList.remove(bean);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_favorite_job,parent,false);
        return new FavoriteJobViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (showdelete){
            ((FavoriteJobViewHolder)holder).showDelete();
        }
        ((FavoriteJobViewHolder)holder).onBind(jobList.get(position));
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public void setShowdelete(boolean arg){
        this.showdelete = arg;
    }
}
