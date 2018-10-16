package com.example.wwq_123.readhub.view.favoritejob;

import android.content.Context;
import android.widget.Toast;

import com.example.wwq_123.readhub.base.BasePresenter;
import com.example.wwq_123.readhub.db.JobArrayDB;
import com.example.wwq_123.readhub.model.bean.JobArrayBean;

import java.util.List;

public class FavoriteJobPresenter extends BasePresenter<FavoriteJobContract.View> implements FavoriteJobContract.Presenter {
    private Context context;
    private JobArrayDB jobArrayDB;
    public FavoriteJobPresenter(FavoriteJobContract.View view,Context context){
        attachView(view);
        this.context = context;
        jobArrayDB = new JobArrayDB(context);
    }

    @Override
    public void getJob() {
        List<JobArrayBean> list = jobArrayDB.getAllJob();
        if (list==null||list.size()==0){
            Toast.makeText(context,"暂无收藏喜爱的职位",Toast.LENGTH_SHORT).show();
        }else {
            view.showJob(list);
        }
    }
}
