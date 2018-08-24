package com.example.wwq_123.readhub.mvc.view;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.wwq_123.readhub.R;

public class MyDialog extends Dialog {

    private Context context;
    private static MyDialog myDialog;

    public MyDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public MyDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    public static MyDialog showDialog(Context context){
        context = context;
        myDialog = new MyDialog(context, R.style.MyDialog);
        myDialog.setContentView(R.layout.dialog_layout);
        myDialog.setCanceledOnTouchOutside(false);
        return myDialog;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && myDialog!=null){
            Animation animation = AnimationUtils.loadAnimation(context,R.anim.my_anim);
        }
    }

    @Override
    public void cancel() {
        super.cancel();

    }
}
