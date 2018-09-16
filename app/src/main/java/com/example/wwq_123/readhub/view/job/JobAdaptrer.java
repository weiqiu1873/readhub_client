package com.example.wwq_123.readhub.view.job;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.model.jsonbean.bean.JobDataItem;

import java.util.ArrayList;
import java.util.List;

public class JobAdaptrer extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<JobDataItem> jobList = new ArrayList<>();
    private LayoutInflater inflater;
    private Context context;
    public JobAdaptrer(Context context){
        inflater = LayoutInflater.from(context);
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_job,parent,false);
        return new JobViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((JobViewHolder)holder).onBind(jobList.get(position));
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public void updateJobList(List<JobDataItem> jobDataItems){
        jobList.clear();
        jobList.addAll(jobDataItems);
        notifyDataSetChanged();
    }
}
