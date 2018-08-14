package com.example.wwq_123.readhub.presenter;

import com.example.wwq_123.readhub.model.MainActivityModel;
import com.example.wwq_123.readhub.model.Model;
import com.example.wwq_123.readhub.model.bean.Title;
import com.example.wwq_123.readhub.view.Display;

import java.util.List;

public class MainActivityPresenter implements Presenter.LoadTabTitlePresenter {

    private Display.TabTitle view;
    private MainActivityModel mainModel = new MainActivityModel();

    public MainActivityPresenter(Display.TabTitle view){
        this.view = view;
    }


    @Override
    public void loadTabTitle() {
        mainModel.getTabTitle(new Model.GetTabTitleCallBack() {
            @Override
            public void TabTitleCallBack(List<Title> titles) {
                view.initTitle(titles);
            }
        });
    }
}
