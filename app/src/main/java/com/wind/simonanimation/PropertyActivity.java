package com.wind.simonanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.animation.AnimationSet;
import android.widget.TextView;

/**
 * Created by zhangcong on 2017/10/13.
 */

public class PropertyActivity extends Activity{
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        textView= (TextView) findViewById(R.id.tv_text);
        Log.i(">>>>>",">>>>>");
        ValueAnimator valueAnimator=ValueAnimator.ofInt(0,100);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value= (int) animation.getAnimatedValue();
                Log.i(">>>>>",value+"");

            }
        });
        valueAnimator.start();

        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(textView,"alpha",1,0,1);
        ObjectAnimator objectAnimator1=ObjectAnimator.ofFloat(textView,"rotation",0f,360f);
        objectAnimator.setDuration(3000);
        objectAnimator.setRepeatCount(3);
        objectAnimator1.setDuration(3000);
        objectAnimator1.setRepeatCount(3);
        objectAnimator1.start();
      //  objectAnimator.start();


        ObjectAnimator objectAnimator2=ObjectAnimator.ofFloat(textView,"scaleY",1,3,1);
        objectAnimator2.setDuration(3000);
        objectAnimator2.setRepeatCount(3);
      //  objectAnimator2.start();

        float x=textView.getTranslationX();
        ObjectAnimator objectAnimator3=ObjectAnimator.ofFloat(textView,"translationX",x,-100f,x);
        objectAnimator3.setDuration(3000);
        objectAnimator3.setRepeatCount(3);
      //  objectAnimator3.start();

        AnimatorSet animatorSet= new AnimatorSet();
        animatorSet.play(objectAnimator).after(objectAnimator1).with(objectAnimator2).with(objectAnimator3);
        animatorSet.setDuration(5000);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                Log.i(">>>>>>>>","动画开始");
            }
        });
        animatorSet.start();

    }

}
