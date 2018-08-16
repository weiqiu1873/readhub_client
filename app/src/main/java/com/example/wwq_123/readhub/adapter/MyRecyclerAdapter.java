package com.example.wwq_123.readhub.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.mvc.model.bean.DataItem;
import com.example.wwq_123.readhub.mvc.model.bean.JobDataItem;
import com.example.wwq_123.readhub.mvc.presenter.MainFragmentPresenter;
import com.example.wwq_123.readhub.mvc.view.Display;
import com.example.wwq_123.readhub.mvc.view.ShowDataActivity;


import java.util.ArrayList;
import java.util.List;


public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Display.SetMoreDisplayData {

    private int TYPE;
    private List<DataItem> data;
    private Context context;
    private LayoutInflater inflater;
    private int normalType = 0;     // 第一种ViewType，正常的item
    private int footType = 1;       // 第二种ViewType，底部的提示View

    public MyRecyclerAdapter(Context c, List<DataItem> data, int type){
        this.context = c;
        this.TYPE = type;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==footType){
            View view = inflater.inflate(R.layout.recycleview_foot_item,parent,false);
            FootHolder holder = new FootHolder(view);
            return holder;
        }else if(TYPE==4){
            View view = inflater.inflate(R.layout.recycleview_job_item,parent,false);
            JobViewHolder holder = new JobViewHolder(view);
            return holder;
        }
        else{
            View view = inflater.inflate(R.layout.recyclerview_normal_item,parent,false);
            NormalViewHolder holder = new NormalViewHolder(view);
            return holder;
        }
    }
    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof NormalViewHolder){
            NormalViewHolder holder1 = (NormalViewHolder)holder;
            holder1.title.setText(data.get(position).getTitle());
            holder1.content.setText(data.get(position).getSummary());
            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
            layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
            holder1.content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (TYPE==0){
                        //跳转到ShowDataActivity
                        Intent intent = new Intent(context, ShowDataActivity.class);
                        intent.putExtra("data",data.get(position));
                        context.startActivity(intent);
//                        EventBus.getDefault().post(data.get(position));
//                        context.startActivity(new Intent(context,ShowDataActivity.class));
                    }else {
                        //调用默认浏览器打开网页
                        Uri uri = Uri.parse(data.get(position).getMobileUrl());
                        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                        context.startActivity(intent);
                    }

                }
            });
        }else if (holder instanceof JobViewHolder){
            JobViewHolder holder1 = (JobViewHolder) holder;
            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
            layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
            holder1.title.setText(((JobDataItem)data.get(position)).getJobTitle());
        }
        else{
            FootHolder holder1 = (FootHolder) holder;
            holder1.button.setVisibility(View.VISIBLE);
            holder1.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //点击加载更多
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return data.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==getItemCount()-1){
            return footType;
        }else {
            return normalType;
        }
    }

    // 暴露接口，下拉刷新时，通过暴露方法将数据源置为空
    public void resetDatas() {
        data = new ArrayList<>();
    }

    //更新原有数据
     public void updateList() {

        notifyDataSetChanged();
     }

    //向presenter申请数据
    public void requestMoreData(){
        MainFragmentPresenter presenter = new MainFragmentPresenter(this);
        presenter.loadMoreData(TYPE,data.get(data.size()-1));
    }
    //接口方法接收数据
    @Override
    public void getMoreData(List<DataItem> list) {
        // 在原有的数据之上增加新数据
        for (DataItem item:list) {
            data.add(item);
        }
        notifyDataSetChanged();
    }

    class NormalViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView content;
        public NormalViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.item_title);
            content = v.findViewById(R.id.item_content);
        }
    }
    class JobViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        public JobViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.job_title);
        }
    }
    class FootHolder extends RecyclerView.ViewHolder{
        private Button button;
        public FootHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.refreshBtn);
        }
    }


}
