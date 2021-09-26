package com.example.juice_delivery_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class registration extends AppCompatActivity {

    private Context mContext;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final EditText email = findViewById(R.id.etemail);
        final EditText password = findViewById(R.id.mypass);
        final EditText rPass = findViewById(R.id.myrepass);
        final Spinner usrType = (Spinner) findViewById(R.id.spinner1);


        Button btn = findViewById(R.id.btnReg);
        DAO_user user_dao = new DAO_user();
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        btn.setOnClickListener(v->
        {

            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

            if(email.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
            }else if(!email.getText().toString().matches(emailPattern) && email.getText().toString().length() < 0){
                Toast.makeText(this, "Please Enter Valid Email", Toast.LENGTH_SHORT).show();
            } else if(password.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
            }else if(usrType.getSelectedItem().toString().isEmpty())
            {
                Toast.makeText(this, "Please Enter User Type", Toast.LENGTH_SHORT).show();
            }else if(!password.getText().toString().equals(rPass.getText().toString()))
            {
                Toast.makeText(this, "Password And Confirm Password Is Not Matching", Toast.LENGTH_SHORT).show();
            }else {
                class_users usr = new class_users(email.getText().toString(), password.getText().toString(), usrType.getSelectedItem().toString());

                user_dao.add(usr).addOnSuccessListener(suc ->
                {
                    String c="Customer";
                    if(usrType.getSelectedItem().toString().toLowerCase().trim().equals(c.toLowerCase().trim()))
                    {
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("UserName", email.getText().toString());
                        editor.commit();

                        Intent intent = new Intent(getApplicationContext(), user_reg_profile.class);
                        startActivity(intent);
                        Toast.makeText(this, "Registration Success", Toast.LENGTH_SHORT).show();


                    }else {
                        Intent intent = new Intent(getApplicationContext(), login.class);
                        startActivity(intent);
                        Toast.makeText(this, "Registration Not Success", Toast.LENGTH_SHORT).show();
                    }

                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }


        });
    }


    public void login(View view) {
        Intent i = new Intent(getApplicationContext(), login.class);
        startActivity(i);
    }
}