package com.example.lenovo.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

public class BollonView extends View {
    private float x = 100;
    private float y = 100;
    private Paint paint;

    public BollonView(Context context) {
        super(context);
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
    }


    public RectF getRectF(){
        float left = x;
        float top = y;
        float right = left + getWidth();
        float bottom = top + getHeight();
        RectF rectF = new RectF(left, top, right, bottom);
        return rectF;
    }

    public Rect getBitmapSrcRec(){
        Rect rect = new Rect();
        rect.left = 0;
        rect.top = 0;
        rect.right = (int)getWidth();
        rect.bottom = (int)getHeight();
        return rect;
    }

    protected void onDraw(Canvas canvas){

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.bottle_balloon);
        super.onDraw(canvas);
        Rect srcRef = getBitmapSrcRec();
        RectF dstRecF = getRectF();
        //canvas.drawBitmap(this.bitmap, x, y, paint);
        canvas.drawBitmap(bitmap, srcRef, dstRecF, paint);

    }
}
