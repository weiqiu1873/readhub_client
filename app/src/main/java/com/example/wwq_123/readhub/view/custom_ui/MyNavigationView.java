package com.example.wwq_123.readhub.view.custom_ui;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyNavigationView extends NavigationView{



    public MyNavigationView(Context context) {
        super(context);
    }

    public MyNavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int lastX = 0,lastY = 0;
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x-lastX;
                int offsetY = y-lastY;
                layout(getLeft()+offsetX,getTop()+offsetY,getRight()+offsetX,getBottom()+offsetY);
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_UP:

                break;
                default:break;
        }

        return true;
    }
}
