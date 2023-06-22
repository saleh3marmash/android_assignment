package com.example.test;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int coins;
    Handler handler = new Handler();
    Intent myIntent,shopIntent;
    Runnable runnable;
    Button button,shop;
    TextView textView;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myIntent = new Intent(MainActivity.this, NextActivity.class);
        shopIntent = new Intent(MainActivity.this, ShopActivity.class);
        super.onCreate(savedInstanceState);
        Log.e("created","Called OnCreate");
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("mySharedPref" ,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        coins=0;
        textView= (TextView) findViewById(R.id.coins);

        button=(Button) findViewById(R.id.button);
        shop=(Button) findViewById(R.id.button_shop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(myIntent);
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(shopIntent);
            }
        });
    }
    protected void onDestroy() {
        super.onDestroy();
        editor.clear();
        editor.apply();
        Log.e("onDestroy","App Destroyed");
    }
    protected void onPause() {
        super.onPause();
        editor.putInt("coins", coins);
        editor.apply();
        Log.e("onPause","App Paused");
    }
    protected void onStop() {
        super.onStop();
        Log.e("onStop","App Stopped");
    }
    protected void onStart() {
        super.onStart();
        Log.e("onStart","App Started");
        coins = sharedPreferences.getInt("coins", 0);
        textView.setText(String.valueOf(coins));
    }
}