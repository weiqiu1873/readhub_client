package com.example.wwq_123.readhub.view.custom_ui;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wwq_123.readhub.R;

public class TitleBar extends LinearLayout {

    private RelativeLayout titleBar;
    private ImageButton leftBtn;
    private TextView title;

    public TitleBar(Context context) {
        this(context,null);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private void init(){
        inflate(getContext(), R.layout.layout_titlebar,this);
        titleBar = findViewById(R.id.rl_actionbar);
         title = findViewById(R.id.title);
         leftBtn = findViewById(R.id.left_button);
    }


    public void setTitle(String text){
        title.setText(text);
    }

    public void setLeftImage(int resId){
        leftBtn.setImageResource(resId);
    }

    public void setListener(OnClickListener listener){
        leftBtn.setOnClickListener(listener);
    }
}
