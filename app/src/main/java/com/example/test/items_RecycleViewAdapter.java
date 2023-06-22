package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class items_RecycleViewAdapter extends RecyclerView.Adapter<items_RecycleViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<ItemsModel> items;
    public items_RecycleViewAdapter(Context context, ArrayList<ItemsModel> items){
        this.context=context;
        this.items=items;

    }
    @NonNull
    @Override
    public items_RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.recycler_view_raw,parent,false);
        return new items_RecycleViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull items_RecycleViewAdapter.MyViewHolder holder, int position) {
        holder.name.setText(items.get(position).getItemName());
        holder.price.setText(String.valueOf(items.get(position).getPrice()));
        holder.imageView.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,price;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.item_image);
            price=itemView.findViewById(R.id.item_price);
            name=itemView.findViewById(R.id.item_name);
        }
    }
}
