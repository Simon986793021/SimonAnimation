package com.wind.simonanimation;

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

public class ValueAnimatorView extends View {
    public static final float RADIUS=50f;
    private Point currentPoint;
    private Paint mPaint;
    public ValueAnimatorView(Context context) {
        super(context);

    }

    public ValueAnimatorView(Context context, @Nullable AttributeSet attrs ) {
        super(context, attrs);
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#11cd6e"));
    }

    public ValueAnimatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (currentPoint==null)
        {
            currentPoint=new Point(RADIUS,RADIUS);
            drawCircle(canvas);
            startAnimation();
        }
        else{
            drawCircle(canvas);
        }
    }
    private void drawCircle(Canvas canvas)
    {
        float x=currentPoint.getX();
        float y=currentPoint.getY();
        canvas.drawCircle(x,y,RADIUS,mPaint);
    }
    private void startAnimation()
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
        valueAnimator.setDuration(5000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.start();
    }
}
