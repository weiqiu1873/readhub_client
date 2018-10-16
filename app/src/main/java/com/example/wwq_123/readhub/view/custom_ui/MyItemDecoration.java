package com.example.wwq_123.readhub.view.custom_ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MyItemDecoration extends RecyclerView.ItemDecoration {
    private int left = 0 ,top = 0 ,right = 0 ,bottom = 0;
    /*
     * @param outRect 边界
     * @param view recyclerView ItemView
     * @param parent recyclerView
     * @param state recycler 内部数据管理
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(left,top,right,bottom);
    }
    public MyItemDecoration setLeft(int left){
        this.left = left;
        return this;
    }

    public MyItemDecoration setTop(int top) {
        this.top = top;
        return this;
    }

    public MyItemDecoration setRight(int right) {
        this.right = right;
        return this;
    }

    public MyItemDecoration setBottom(int bottom) {
        this.bottom = bottom;
        return this;
    }
}
