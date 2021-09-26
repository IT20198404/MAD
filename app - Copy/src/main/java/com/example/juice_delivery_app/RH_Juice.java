package com.example.juice_delivery_app;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RH_Juice extends RecyclerView.ViewHolder {

    public TextView txt_name,txt_price;
    public RH_Juice(@NonNull View juice_item)
    {
        super(juice_item);
        txt_name = juice_item.findViewById(R.id.txt_name);
        txt_price = juice_item.findViewById(R.id.txt_price);
    }
}
