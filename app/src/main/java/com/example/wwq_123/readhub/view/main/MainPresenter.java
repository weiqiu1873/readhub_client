package com.example.wwq_123.readhub.view.main;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.wwq_123.readhub.base.BasePresenter;
import com.example.wwq_123.readhub.db.PreferencesUtil;
import com.example.wwq_123.readhub.umeng.MyUMAuthListener;
import com.example.wwq_123.readhub.util.ImageUtil;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;
import java.util.concurrent.ExecutionException;

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
        String imageName;
        if (util.loginStatus()){
            //获取存在本地的数据
            util.setLastlogin();
            name.append(util.getUserName());
            imageName = util.getUserImage();
            ImageUtil imageUtil = new ImageUtil(context);
            view.showUserImage(imageUtil.getImage(imageName));
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
                , new MyUMAuthListener(context){
                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        Toast.makeText(context,"登录成功",Toast.LENGTH_SHORT).show();
                        view.showNagivation(map.get("name"),false);
                        saveInfor(map);
                    }
                });
    }

    @Override
    public void exit() {
        util.setLogin(false);
    }

    private void saveInfor(Map<String,String> map){
        util.setLogin(true);
        util.setUserId(map.get("uid"));
        util.setUserName(map.get("name"));
        util.setUserImage(map.get("uid")+".jpg");
        util.setLastlogin();
        new ImageAsynTask().execute(map.get("iconurl"),map.get("uid"));
    }

    class ImageAsynTask extends AsyncTask<String,Void,Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {
            String url = strings[0];
            Bitmap bitmap = null;
            try {
                bitmap = Glide.with(context)
                        .load(url)
                        .asBitmap()
                        .into(200,200)
                        .get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            ImageUtil util = new ImageUtil(context);
            util.saveImage(strings[1]+".jpg",bitmap);
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            view.showUserImage(bitmap);
        }
    }
}
