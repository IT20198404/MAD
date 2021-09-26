package com.example.juice_delivery_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class admin_dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
    }

    public void feedback(View view) {
        Intent i = new Intent(getApplicationContext(), login.class);
        startActivity(i);
    }
    public void employee(View view) {
        Intent i = new Intent(getApplicationContext(), login.class);
        startActivity(i);
    }

    public void driver(View view) {
        Intent i = new Intent(getApplicationContext(), login.class);
        startActivity(i);
    }

    public void juice(View view) {
        Intent i = new Intent(getApplicationContext(), login.class);
        startActivity(i);
    }
}