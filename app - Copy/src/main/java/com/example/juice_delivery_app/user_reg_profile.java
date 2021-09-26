package com.example.juice_delivery_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.juice_delivery_app.class_users.email_Global;

public class user_reg_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_reg_profile);

        final EditText name = findViewById(R.id.name);
        final EditText address = findViewById(R.id.address);
        final EditText tel = findViewById(R.id.tel);
        final DatePicker bod = (DatePicker) findViewById(R.id.datePicker1);
        final EditText age = findViewById(R.id.age);
        final EditText nic = findViewById(R.id.NIC);


        Button btn = findViewById(R.id.save);
        DAO_user_profile profile_DAo = new DAO_user_profile();


        btn.setOnClickListener(v->
        {


            if(name.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Please Enter Name", Toast.LENGTH_SHORT).show();
            } else if(address.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Please Enter Address", Toast.LENGTH_SHORT).show();
            }else if(tel.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Please Telephone Number", Toast.LENGTH_SHORT).show();
            }else if(tel.getText().toString().length() != 10)
            {
                Toast.makeText(this, "Please Enter Valid Telephone Number", Toast.LENGTH_SHORT).show();
            }else if(!(nic.getText().toString().trim().matches("^[0-9]{9}[vVxX]$")))
            {
                Toast.makeText(this, "Please Enter Valid NIC", Toast.LENGTH_SHORT).show();
            }else {
                class_user_profle profile = new class_user_profle(name.getText().toString(), address.getText().toString(), tel.getText().toString(), bod.getYear()+"-"+ bod.getMonth()+"-"+ bod.getDayOfMonth(), age.getText().toString(), nic.getText().toString(), email_Global );

                profile_DAo.add(profile).addOnSuccessListener(suc ->
                {

                    Intent intent = new Intent(getApplicationContext(), admin_dashboard.class);
                    startActivity(intent);
                    Toast.makeText(this, "Profile Added", Toast.LENGTH_SHORT).show();

                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }


        });
    }

}