package com.example.wwq_123.readhub.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import com.bumptech.glide.Glide;
import com.example.wwq_123.readhub.db.PreferencesUtil;

import java.util.concurrent.ExecutionException;

public class ImageUtil {

    private PreferencesUtil util;
    private Context context;
    public ImageUtil(Context context){
        this.context = context;
        util = PreferencesUtil.getInstance(context);
    }
    //同步下载图片
    public void downloadImageSync(String id,String url){
        new Thread(()->{
            Bitmap bitmap = null;
            try {
                bitmap = Glide.with(context).load(url).asBitmap().into(200,200).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            saveImage(id+"jpg",bitmap);
        }).start();

    }
//    保存图片到本地
    public void saveImage(String filename,Bitmap bitmap){
        MediaStore.Images.Media.insertImage(context.getContentResolver(),bitmap,filename,null);
    }
//    从本地获取图片
    public void getImage(){

    }

}
