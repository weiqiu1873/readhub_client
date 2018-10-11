package com.example.wwq_123.readhub.base;


public interface BaseContract {

    interface BasePresenter <T extends BaseView>{
        void attachView(T view);
        void detachView();
    }

    interface BaseView{
        int getLayoutId();
        void initData();
        void initEvent();
        void showSuccess();
        void showFailed();
    }
}
