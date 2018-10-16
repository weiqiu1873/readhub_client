package com.example.wwq_123.readhub.view.favoritejob;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.db.JobArrayDB;
import com.example.wwq_123.readhub.db.PreferencesUtil;
import com.example.wwq_123.readhub.eventbus.Event;
import com.example.wwq_123.readhub.model.bean.JobArrayBean;
import com.example.wwq_123.readhub.umeng.UMengShare;
import com.example.wwq_123.readhub.view.WebActivity;

import org.greenrobot.eventbus.EventBus;

public class FavoriteJobViewHolder extends RecyclerView.ViewHolder {
    private TextView ja_title,ja_company,ja_salary,ja_experience,ja_city,ja_site;
    private ImageButton ja_collect,ja_delete,ja_share;
    private PreferencesUtil util;
    private boolean collectStatus = false;
    Context context;
    JobArrayDB jobArrayDB;

    public FavoriteJobViewHolder(View itemView,Context context) {
        super(itemView);
        this.context = context;
        jobArrayDB = new JobArrayDB(context);
        ja_title = itemView.findViewById(R.id.jobArray_item_title);
        ja_company = itemView.findViewById(R.id.jobArray_item_company);
        ja_salary = itemView.findViewById(R.id.jobArray_item_salary);
        ja_experience = itemView.findViewById(R.id.jobArray_item_experience);
        ja_city = itemView.findViewById(R.id.jobArray_item_city);
        ja_site = itemView.findViewById(R.id.jobArray_item_site);
        ja_collect = itemView.findViewById(R.id.jobArray_item_collect);
        ja_delete = itemView.findViewById(R.id.jobArray_item_delete);
        ja_share = itemView.findViewById(R.id.jobArray_item_share);
        setShareLocation(R.id.jobArray_item_collect);
        util = PreferencesUtil.getInstance(context);
    }

    public void onBind(JobArrayBean bean){
        ja_title.setText(bean.getTitle());
        ja_company.setText(bean.getCompany());
        if (bean.getSalaryLower()==-1){
            ja_salary.setText("面议");
        }else {
            ja_salary.setText(bean.getSalaryLower()+"-"+bean.getSalaryUpper()+"k");
        }
        if (bean.getExperienceLower()==-1){
            ja_experience.setText("经验不限");
        }else {
            ja_experience.setText(bean.getExperienceLower()+"-"+bean.getExperienceUpper()+"年");
        }
        ja_city.setText(bean.getCity());
        ja_site.setText(bean.getSiteName());
        ja_title.setOnClickListener((view)->{
            Intent intent  = new Intent(context,WebActivity.class);
            intent.putExtra("url",bean.getUrl());
            context.startActivity(intent);
        });
        ja_collect.setOnClickListener((view)->{
            if (!util.loginStatus()){
                Toast.makeText(context,"请先登录",Toast.LENGTH_SHORT).show();
            }else {
                if (collectStatus) {
                    Toast.makeText(context, "取消收藏", Toast.LENGTH_SHORT).show();
                    ja_collect.setImageResource(R.drawable.ic_uncollect);
                    collectStatus = false;
                    jobArrayDB.delete(bean);
                } else {
                    Toast.makeText(context, "收藏成功", Toast.LENGTH_SHORT).show();
                    ja_collect.setImageResource(R.drawable.ic_collect);
                    collectStatus = true;
                    jobArrayDB.insert(bean);
                }
            }
        });
        ja_delete.setOnClickListener((view)->{
            Toast.makeText(context,"取消收藏",Toast.LENGTH_SHORT).show();
            collectStatus = false;
            jobArrayDB.delete(bean);
            Event.Job job = new Event.Job();
            job.bean = bean;
            EventBus.getDefault().post(job);
        });
        ja_share.setOnClickListener((view)->{
            new UMengShare(context).share(bean);
        });
    }

    public void showDelete(){
        ja_delete.setVisibility(View.VISIBLE);
        ja_collect.setVisibility(View.GONE);
        setShareLocation(R.id.jobArray_item_delete);
    }

    public void setShareLocation(int id){
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) ja_share.getLayoutParams();
        params.addRule(RelativeLayout.LEFT_OF,id);
    }
}
