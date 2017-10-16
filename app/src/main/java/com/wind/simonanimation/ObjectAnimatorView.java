package com.wind.simonanimation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhangcong on 2017/10/16.
 */

public class ObjectAnimatorView extends View {
    public static final float RADIUS=50f;
    private Point currentPoint;
    private Paint mPaint;
    private String color;
    ObjectAnimatorView objectAnimatorView;
    public String getColor()
    {
        return  color;
    }
    public void setColor(String color)
    {
        this.color=color;
        mPaint.setColor(Color.parseColor(color));
        invalidate();
    }
    public ObjectAnimatorView(Context context) {
        super(context);
    }

    public ObjectAnimatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#11cd6e"));
    }

    public ObjectAnimatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (currentPoint==null){
            currentPoint=new Point(RADIUS,RADIUS);
            drawCicle(canvas);
            startAnimation();
        }
        else {
            drawCicle(canvas);
        }
    }

    private void drawCicle(Canvas canvas) {
        float x=currentPoint.getX();
        float y=currentPoint.getY();
        canvas.drawCircle(x,y,RADIUS,mPaint);
    }
    private void  startAnimation()
    {
        Point startPoint=new Point(RADIUS,RADIUS);
        Point endPoint=new Point(getWidth()-RADIUS,getHeight()-RADIUS);
        ValueAnimator valueAnimator=ValueAnimator.ofObject(new PointEvaluator(),startPoint,endPoint);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint= (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator objectAnimator=ObjectAnimator.ofObject(this,"color",new ColorEvaluator(),"#0000ff","#ff00000");
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.play(valueAnimator).with(objectAnimator);
        animatorSet.setDuration(5000);
        animatorSet.start();
    }
}
