package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class splashScreen extends AppCompatActivity {
    Intent intent;
    Handler handler = new Handler();
    Animation anim;
    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        txtView=findViewById(R.id.textView);
        anim= AnimationUtils.loadAnimation(this, R.anim.my_animation);
        txtView.startAnimation(anim);
        handler.postDelayed(runnable,2000);
    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            intent = new Intent(splashScreen.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
}