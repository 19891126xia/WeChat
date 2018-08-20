package com.example.lenovo.myapplication;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class FloatBottle extends Activity {
    ImageView imageView=null;
    int x=0;
    int y=0;
    boolean x_f=true;
    boolean y_f=true;
    public ViewGroup.MarginLayoutParams margin;

    final Handler mhandler = new Handler() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_float_bottle);
        imageView = (ImageView) findViewById(R.id.bottle_ballon);
        margin = new ViewGroup.MarginLayoutParams(imageView.getLayoutParams());

        mhandler.post(new Runnable() {
            @Override
            public void run()
            {
                // TODO Auto-generated method stub
                move();
                mhandler.postDelayed(this, 40);
            }
        });

    }

    public void move(){
        if(x<1){
            x_f = true;
        }else if(x>900){
            x_f = false;
        }
        if(y<1){
            y_f = true;
        }else if(y>400){
            y_f = false;
        }
        if (x_f)
            x +=1;
        else
            x-=1;
        if (y_f)
            y +=1;
        else
            y-=1;

        margin.leftMargin=x;
        margin.topMargin =y;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(margin);
        imageView.setLayoutParams(layoutParams);
    }
}
