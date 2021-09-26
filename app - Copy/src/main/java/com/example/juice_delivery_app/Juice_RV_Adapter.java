package com.example.juice_delivery_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Juice_RV_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    ArrayList<class_juice> list = new ArrayList<class_juice>();
    public Juice_RV_Adapter(Context ctx)
    {
        this.context = ctx;
    }


    public  void setItems(ArrayList<class_juice> juice)
    {
        list.addAll(juice);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.juice_item,parent,false);
        return new RH_Juice(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RH_Juice jh = (RH_Juice) holder;
        class_juice juice =  list.get(position);
        jh.txt_name.setText(juice.getTitle());
        jh.txt_price.setText(juice.getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
