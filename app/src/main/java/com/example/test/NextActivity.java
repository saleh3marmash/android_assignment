package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
    Intent myIntent;
    Button btn,answer;
    Button btnAnswer;
    int coins;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        coins=0;
        textView= (TextView) findViewById(R.id.coins);
        sharedPreferences = getSharedPreferences("mySharedPref" ,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        btn=(Button) findViewById(R.id.button2);
        answer=(Button) findViewById(R.id.option_1);
        myIntent=new Intent(NextActivity.this, MainActivity.class );
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(myIntent);
            }
        });
        answer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                coins+=10;
                editor.putInt("coins", coins);
                textView.setText(String.valueOf(coins));
                editor.apply();
            }
        });
    }
    protected void onStart() {
        super.onStart();
        Log.e("onStart","App Started");
        coins = sharedPreferences.getInt("coins", 0);
        textView.setText(String.valueOf(coins));
    }
    protected void onPause() {
        super.onPause();
        editor.putInt("coins", coins);
        editor.apply();
        Log.e("onPause","App Paused");
    }
}