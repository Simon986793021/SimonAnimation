package com.wind.simonanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
