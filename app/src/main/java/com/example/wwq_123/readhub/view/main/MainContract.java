package com.example.wwq_123.readhub.view.main;

import android.graphics.Bitmap;
import com.example.wwq_123.readhub.base.BaseContract;

public interface MainContract extends BaseContract {
    interface View extends BaseContract.BaseView{
        void showNagivation(String name,boolean isListen);
        void showUserImage(Bitmap bitmap);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void setNagivation();
        void loginByQQ();
        void exit();
    }
}
