package com.example.wwq_123.readhub.mvc.presenter;

import com.example.wwq_123.readhub.mvc.model.bean.Title;
import com.example.wwq_123.readhub.net.retrofit.API;
import com.example.wwq_123.readhub.util.HtmlUtil;
import com.example.wwq_123.readhub.mvc.view.Display;

import java.util.List;

import rx.Subscriber;

public class MainActivityPresenter extends BasePresenter implements Presenter.LoadTabTitlePresenter {

    private Display.TabTitle view;

    public MainActivityPresenter(Display.TabTitle view){
        this.view = view;
        attachView(view);
        api = API.getTitleService();
    }

    @Override
    public void loadTabTitle() {

        addSubscription(api.getTabTitle(), new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("completed..................");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("error......."+e.getMessage());
            }

            @Override
            public void onNext(String string) {
                List<Title> titles =  HtmlUtil.getTitle(string);
                view.initTitle(titles);
            }
        });

    }

}
