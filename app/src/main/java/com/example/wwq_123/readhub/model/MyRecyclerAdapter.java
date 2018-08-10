package com.example.wwq_123.readhub.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.model.bean.DataItem;
import com.example.wwq_123.readhub.model.bean.JobDataItem;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ADD = 1;
    private static final int UPDATE = 0;
    private int type;
    private List<? extends DataItem> data;
    private Context context;
    private LayoutInflater inflater;
    private int normalType = 0;     // 第一种ViewType，正常的item
    private int footType = 1;       // 第二种ViewType，底部的提示View

    public MyRecyclerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public MyRecyclerAdapter(Context c, List<? extends DataItem> data,int type){
        this.context = c;
        this.type = type;
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
        }else if(type==4){
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
                    Toast.makeText(context,data.get(position).getUrl(),Toast.LENGTH_SHORT);
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
                    System.out.println("button...........add");
//                    updateList(ADD);
                }
            });
        }

    }


    // 暴露接口，下拉刷新时，通过暴露方法将数据源置为空
    public void resetDatas() {
        data = new ArrayList<>();
    }

    // 暴露接口，更新数据源
     public void updateList(int type) {
//        if (type==ADD){
//            // 在原有的数据之上增加新数据
//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl("https://api.readhub.cn/")
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                    .build();
//            APIInterface service = retrofit.create(APIInterface.class);
//            Observable<Data> observable = service.getTopicData(null,10);
//            observable.subscribeOn(Schedulers.io())
//              .observeOn(AndroidSchedulers.mainThread())
//               .subscribe(new Observer<Data>() {
//                @Override
//                public void onCompleted() {
//                    Toast.makeText(context, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onError(Throwable e) {
//                    Toast.makeText(context,"获取数据失败",Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onNext(Data data) {
//
//
//                }
//            });
//        }else {
//            //更新原有数据
//
//        }
//        notifyDataSetChanged();
     }

    @Override
    public int getItemCount() {
        return data.size()+1;
    }
    // 自定义方法，获取列表中数据源的最后一个位置，比getItemCount少1，因为不计上footView
    public int getRealLastPosition() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position==getItemCount()-1){
            return footType;
        }else {
            return normalType;
        }
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