package com.example.juice_delivery_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class user_finish_order extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_finish_order);

        final EditText name = findViewById(R.id.name);
        final EditText address = findViewById(R.id.address);
        final EditText tel = findViewById(R.id.tel);



        Button btn = findViewById(R.id.confirm);
        DAO_order_confrim order_confrim = new DAO_order_confrim();

        btn.setOnClickListener(v->
        {
            int random_int = (int)Math.floor(Math.random()*(10000-0+1)+0);
            String orderId =String.valueOf(random_int);

            if(name.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Please Enter Full Name", Toast.LENGTH_SHORT).show();
            }else if(tel.getText().toString().length() != 10)
            {
                Toast.makeText(this, "Please Enter Telephone Number", Toast.LENGTH_SHORT).show();
            } else if(address.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Please Enter Address", Toast.LENGTH_SHORT).show();
            } else {
                class_order_confirm order_c = new class_order_confirm(name.getText().toString(), tel.getText().toString(), address.getText().toString(), orderId, "Item one");

                order_confrim.add(order_c).addOnSuccessListener(suc ->
                {

                        Intent intent = new Intent(getApplicationContext(), user_dashboard.class);
                        startActivity(intent);
                        Toast.makeText(this, "Order Placed", Toast.LENGTH_SHORT).show();


                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }


        });
    }

}