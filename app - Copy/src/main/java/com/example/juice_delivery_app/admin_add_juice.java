package com.example.juice_delivery_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class admin_add_juice extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_juice);

        final EditText title = findViewById(R.id.txtTile);
        final EditText price = findViewById(R.id.txtPrice);
        final Spinner type = (Spinner) findViewById(R.id.type);

        Button btnAddJuice = findViewById(R.id.btnAddJuice);
        DAO_juice juice_bar = new DAO_juice();

        btnAddJuice.setOnClickListener(v->
        {


            if(title.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Please Enter Title", Toast.LENGTH_SHORT).show();
            }
            else if(price.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Please Enter Price", Toast.LENGTH_SHORT).show();
            }
            else if(type.getSelectedItem().toString().isEmpty())
            {
                Toast.makeText(this, "Please Enter Juice Type", Toast.LENGTH_SHORT).show();
            }else {
                class_juice juice = new class_juice(title.getText().toString(), "Rs."+price.getText().toString()+".00", type.getSelectedItem().toString());

                juice_bar.add(juice).addOnSuccessListener(suc ->
                {

                    Intent intent = new Intent(getApplicationContext(), admin_dashboard.class);
                    startActivity(intent);
                    Toast.makeText(this, "Juice Item Adding Success", Toast.LENGTH_SHORT).show();

                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }


        });
    }

}