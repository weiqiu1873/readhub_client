package com.example.wwq_123.readhub.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.wwq_123.readhub.db.PreferencesUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtil {

    private PreferencesUtil util;
    private Context context;
    public static final String PATH_NAME = "/image/";
    private static final String DirectoryName = "image";

    public ImageUtil(Context context){
        this.context = context;
        util = PreferencesUtil.getInstance(context);
    }

//    保存图片到本地
    public void saveImage(String filename,Bitmap bitmap){
//        MediaStore.Images.Media.insertImage(context.getContentResolver(),bitmap,filename,null);
        String path = context.getFilesDir().getAbsolutePath();
        path = path+File.separator+DirectoryName;
        File appDir = new File(path);
        if (!appDir.exists()){
            appDir.mkdir();
        }
        File file = new File(appDir,filename);
        if (file.exists()){
            return;
        }
        try {
            FileOutputStream output = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,output);
            output.flush();
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    从本地获取图片
    public Bitmap getImage(String filename){
        String path = context.getFilesDir().getAbsolutePath();
        path = path+File.separator+DirectoryName+File.separator+filename;
        Bitmap bitmap = null;
        try {
            FileInputStream input = new FileInputStream(path);
            bitmap =  BitmapFactory.decodeStream(input);
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
