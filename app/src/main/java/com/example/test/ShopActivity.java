package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {
    ArrayList<ItemsModel> items=new ArrayList<>();
    Button btn;
    Intent myIntent;
    int[] itemsImages= {R.drawable.hint,R.drawable.revive,R.drawable.remove_option};
    int coins;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        coins=0;
        textView= (TextView) findViewById(R.id.coins);
        sharedPreferences = getSharedPreferences("mySharedPref" ,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        RecyclerView recyclerView=findViewById(R.id.recycler_items);

        setupItems();

        items_RecycleViewAdapter adapter=new items_RecycleViewAdapter( this,items);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        btn=(Button) findViewById(R.id.button4);
        myIntent=new Intent(ShopActivity.this, MainActivity.class );
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(myIntent);
            }
        });
    }
    private void setupItems(){
        String[] itemNames=getResources().getStringArray(R.array.items);
        String[] itemPrices=getResources().getStringArray(R.array.prices);

                for(int i=0; i<itemNames.length; i++){
                    int price=Integer.valueOf(itemPrices[i]);
                    items.add(new ItemsModel(itemNames[i],price,itemsImages[i]));
                }
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