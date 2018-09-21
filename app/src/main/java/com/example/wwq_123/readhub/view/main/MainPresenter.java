package com.example.wwq_123.readhub.view.main;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;

import com.example.wwq_123.readhub.base.BasePresenter;
import com.example.wwq_123.readhub.db.PreferencesUtil;
import com.example.wwq_123.readhub.util.ImageUtil;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private PreferencesUtil util;
    private Context context;
    public MainPresenter(MainContract.View view,Context context){
        attachView(view);
        this.context = context;
        util = PreferencesUtil.getInstance(context);
    }

    @Override
    public void setNagivation() {
        StringBuilder name = new StringBuilder();
        boolean isListen;
        Log.d("login",util.isLogin()+"\t"+util.loginIsPass());
        if (util.isLogin()&&!util.loginIsPass()){
            //获取存在本地的数据
            name.append(util.getUserName());
            util.setLastlogin();        //更新最近登录日期
            isListen = false;
        }else {
            //未登录
            name.append("QQ登录");
            isListen = true;
        }
        view.showNagivation(name.toString(),isListen);
    }

    @Override
    public void loginByQQ() {
        UMShareAPI api = UMShareAPI.get(context);
        api.getPlatformInfo((Activity) context, SHARE_MEDIA.QQ
                , new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                        Toast.makeText(context,"onStart",Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        Toast.makeText(context,"onComplete",Toast.LENGTH_SHORT).show();
                        view.showNagivation(map.get("name"),false);
                        saveInfor(map);
                    }
                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                        Toast.makeText(context,"onError",Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {
                        Toast.makeText(context,"onCancel",Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void saveInfor(Map<String,String> map){
        util.setLogin(true);
        util.setUserId(map.get("uid"));
        util.setUserName(map.get("name"));
        util.setLastlogin();
        ImageUtil imageUtil = new ImageUtil(context);
        imageUtil.downloadImageSync(map.get("uid"),map.get("iconurl"));
    }
}
