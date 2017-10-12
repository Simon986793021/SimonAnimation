package com.wind.simonanimation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/**
 * Created by zhangcong on 2017/10/12.
 */

public class TweenActivity extends Activity{
    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        imageView= (ImageView) findViewById(R.id.iv_tween);
        Animation animation= AnimationUtils.loadAnimation(TweenActivity.this,R.anim.tween_animation);
        imageView.startAnimation(animation);
    }
}
