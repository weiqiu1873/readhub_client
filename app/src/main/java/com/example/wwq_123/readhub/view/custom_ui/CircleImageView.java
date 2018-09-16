package com.example.wwq_123.readhub.view.custom_ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        wight = getMeasuredWidth();
        height = getMeasuredHeight();
        radius = Math.min(wight,height)/2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setShader(initBitmapShader());    //将着色器设置给画笔
        canvas.drawCircle(wight/2,height/2,radius,paint);
    }
    private BitmapShader initBitmapShader(){
        Bitmap bitmap = ((BitmapDrawable)getDrawable()).getBitmap();
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
        float scale = Math.max(wight/bitmap.getWidth(),height/bitmap.getHeight());
        matrix.setScale(scale,scale);
        shader.setLocalMatrix(matrix);
        return shader;
    }
}
