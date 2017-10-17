package com.wind.simonanimation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;

/**
 * Created by zhangcong on 2017/10/12.
 */

public class FrameActivity extends Activity{
    private ImageView imageView;
    private int[] imgs = new int[]{R.drawable.animation1, R.drawable.animation2, R.drawable.animation3, R.drawable.animation4};

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        imageView= (ImageView) findViewById(R.id.iv_frame);

       // startWithCode();
        startWithXml();


    }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public void startWithXml()
        {
                AnimationDrawable animationDrawable= (AnimationDrawable) getResources().getDrawable(R.drawable.frame_animation);
                imageView.setBackground(animationDrawable);
                animationDrawable.setOneShot(true);
                animationDrawable.start();
        }
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void startWithCode()
        {
            AnimationDrawable animationDrawable=new AnimationDrawable();
            for (int i=0;i<imgs.length;i++)
            {
                Drawable drawable=getResources().getDrawable(imgs[i],null);
                animationDrawable.addFrame(drawable,200);
            }
            imageView.setBackground(animationDrawable);
            animationDrawable.setOneShot(true);
            animationDrawable.start();
        }
}
