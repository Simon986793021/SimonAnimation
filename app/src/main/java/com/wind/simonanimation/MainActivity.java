package com.wind.simonanimation;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.bt_frame);

    }
    public  void onClick(View view)
    {
        Intent intent =new Intent(MainActivity.this,FrameActivity.class);
        startActivity(intent);
    }
    public void onClickTween(View view)
    {
        Intent intent =new Intent(MainActivity.this,TweenActivity.class);
        startActivity(intent);
    }
    public void onClickProperty(View view)
    {
        Intent intent=new Intent(MainActivity.this,PropertyActivity.class);
        startActivity(intent);
    }
    public void onClickValue (View view)
    {
        Intent intent=new Intent(MainActivity.this,MyValueAnimatorActivity.class);
        startActivity(intent);
    }
}
