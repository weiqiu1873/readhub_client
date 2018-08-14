package com.example.wwq_123.readhub.presenter;

import com.example.wwq_123.readhub.model.MainFragmentModel;
import com.example.wwq_123.readhub.model.Model;
import com.example.wwq_123.readhub.model.bean.DataItem;
import com.example.wwq_123.readhub.view.Display;
import com.example.wwq_123.readhub.adapter.MyRecyclerAdapter;

import java.util.List;

public class MainFragmentPresenter implements Presenter.LoadDataPresenter,Presenter.LoadMoreDataPresenter {

    private Display.DisplayData view;
    private MyRecyclerAdapter adapter;
    private MainFragmentModel mainFragmentModel = new MainFragmentModel();

    public MainFragmentPresenter(Display.DisplayData view){
        this.view = view;
    }
    public MainFragmentPresenter(MyRecyclerAdapter adapter){
        this.adapter = adapter;
    }

    @Override
    public void loadData(int fragmentId) {
        mainFragmentModel.getData(new Model.GetDataCallBack() {
            @Override
            public void DataCallBack(List<DataItem> list) {
                view.initData(list);
            }
        },fragmentId);
    }

    @Override
    public void loadMoreData(int fragmentId,DataItem item) {
        mainFragmentModel.getMoreData(new Model.GetMoreDataCallBack() {
            @Override
            public void DataCallBack(List<DataItem> list) {
                adapter.getMoreData(list);
            }
        },fragmentId,item);
    }
}
