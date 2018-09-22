package com.example.wwq_123.readhub.view.custom_ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

@SuppressLint("AppCompatCustomView")
public class CircleImageView extends ImageView {

    private float wight;
    private float height;
    private float radius;
    private Paint paint;
    private Matrix matrix;      //初始化缩放矩阵

    public CircleImageView(Context context) {
        this(context,null);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
        matrix = new Matrix();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CircleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        paint = new Paint();
        paint.setAntiAlias(true);
        matrix = new Matrix();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec),measureHeight(heightMeasureSpec));
        radius = Math.min(wight,height)/2;
    }

    private int measureWidth(int measureSpec){
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode==MeasureSpec.EXACTLY){
            result = specSize;
        }else {
            DisplayMetrics dm = getResources().getDisplayMetrics();
           int windowSize = dm.widthPixels;
           result = windowSize/5;
           if (specMode==MeasureSpec.AT_MOST){
               result = Math.min(result,specSize);
           }
        }
        wight = result;
        return result;
    }
    private int measureHeight(int measureSpec){
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode==MeasureSpec.EXACTLY){
            result = specSize;
        }else {
            DisplayMetrics dm = getResources().getDisplayMetrics();
            int windowHeight = dm.heightPixels;
            result = windowHeight/7;
            if (specMode==MeasureSpec.AT_MOST){
                result = Math.min(result,specSize);
            }
        }
        height = result;
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setShader(initBitmapShader());    //将着色器设置给画笔
        canvas.drawCircle(wight/2,height/2,radius,paint);
    }
    private BitmapShader initBitmapShader(){
        BitmapDrawable drawable = (BitmapDrawable) getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
        float scale = Math.max(wight/bitmap.getWidth(),height/bitmap.getHeight());
        matrix.setScale(scale,scale);
        shader.setLocalMatrix(matrix);
        return shader;
    }
}
