package com.example.wwq_123.readhub.view.custom_ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class MyLoadingView extends View{

    private ObjectAnimator animator;
    private boolean isRun;
    private float radius;
    private float width;
    private float height;
    private float circleX;
    private float circleY;
    private Paint paint;
    private RectF rectF;
    private float startAngle = 0;
    private float sweepAngle = 90;
    public MyLoadingView(Context context) {
        this(context,null);
    }

    public MyLoadingView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public MyLoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);

        animator = ObjectAnimator.ofFloat(this,"rotation",0,360);
        animator.setDuration(3000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.setRepeatMode(ObjectAnimator.RESTART);
    }

    public void initCricle(){
        circleX = width/2;
        circleY = height/2;
        radius = width<height?width/2:height/2;
        rectF = new RectF(circleX-radius,circleY-radius
                ,circleX+radius,circleY+radius);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        initCricle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.GRAY);
        canvas.drawCircle(circleX,circleY,radius,paint);
        paint.setColor(Color.WHITE);
        canvas.drawArc(rectF,startAngle,sweepAngle,true,paint);
        super.onDraw(canvas);
    }

    public void start(){
        isRun = true;
        animator.start();
    }
    public void stop(){
        isRun = false;
        animator.end();
    }

    public Boolean isRun(){
        return isRun;
    }

}
