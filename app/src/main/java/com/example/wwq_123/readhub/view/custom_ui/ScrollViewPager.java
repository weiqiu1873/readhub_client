package com.example.wwq_123.readhub.view.custom_ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ScrollViewPager extends ViewPager {

    boolean canScroll = false;

    public ScrollViewPager(@NonNull Context context) {
        super(context);
    }

    public ScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean isCanScroll() {
        return canScroll;
    }

    public void setCanScroll(boolean canScroll) {
        this.canScroll = canScroll;
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        if (canScroll) {
            return super.onTouchEvent(arg0);
        } else {
            return false;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (canScroll) {
            return super.onInterceptTouchEvent(arg0);
        } else {
            return false;
        }
    }
}
