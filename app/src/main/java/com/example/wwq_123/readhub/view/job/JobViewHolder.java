package com.example.wwq_123.readhub.view.job;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.model.bean.JobDataItem;
import com.example.wwq_123.readhub.view.job.detail.JobDetailActivity;

public class JobViewHolder extends RecyclerView.ViewHolder {

    private CardView job_cardview;
    private TextView job_title;
    private TextView job_summary;
    private Context context;

    public JobViewHolder(View itemView,Context context) {
        super(itemView);
        this.context = context;
        job_cardview = itemView.findViewById(R.id.job_cardview);
        job_title = itemView.findViewById(R.id.job_item_title);
        job_summary = itemView.findViewById(R.id.job_item_summary);
    }

    public void onBind(JobDataItem item){
        job_title.setText(item.getJobTitle());
        StringBuilder builder = new StringBuilder();
        String summmary2 = "北京、上海、深圳"
                +"等地共更新了"+item.getJobCount()+"个职位，待遇集中在"
                +item.getSalaryLower()+"-"+item.getSalaryUpper()+"k,一般要求"
                +item.getExperienceLower()+"-"+item.getExperienceUpper()+"年经验";
        job_summary.setText(summmary2);

        job_cardview.setOnClickListener((v)->{
            Intent intent  = new Intent(context, JobDetailActivity.class);
            intent.putExtra("job",item);
            context.startActivity(intent);
        });
    }
}
