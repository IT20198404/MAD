package com.example.juice_delivery_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class login extends AppCompatActivity {

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText emailEntered = findViewById(R.id.etemail);
        final EditText passwordEntered = findViewById(R.id.mypass);
        Button btn = findViewById(R.id.btnlogin);
        DAO_user user_dao = new DAO_user();

        auth = FirebaseAuth.getInstance();

        btn.setOnClickListener(v->
        {

                String email = emailEntered.getText().toString().trim();
                String password =passwordEntered.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter email!!",
                            Toast.LENGTH_LONG)
                            .show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter password!!",
                            Toast.LENGTH_LONG)
                            .show();
                    return;
                }
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(
                                new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(
                                            @NonNull Task<AuthResult> task)
                                    {
                                        if (!task.isSuccessful()) {
                                            Toast.makeText(getApplicationContext(),
                                                    "Login successful!!",
                                                    Toast.LENGTH_LONG)
                                                    .show();


                                            // if sign-in is successful
                                            // intent to home active
                                            Intent intent
                                                    = new Intent(login.this,
                                                    MainActivity.class);
                                            startActivity(intent);
                                        }

                                        else {

                                            // sign-in failed

                                            Toast.makeText(getApplicationContext(),
                                                    "Login failed!!",
                                                    Toast.LENGTH_LONG)
                                                    .show();
                                        }
                                    }
                        });

        });


//        btn.setOnClickListener(v->
//        {
//            String email = emailEntered.getText().toString().trim();
//            String password =passwordEntered.getText().toString().trim();
//
//            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
//
//
//            if(emailEntered.getText().toString().isEmpty())
//            {
//                Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
//            }else if(!emailEntered.getText().toString().matches(emailPattern) && emailEntered.getText().toString().length() < 0){
//                Toast.makeText(this, "Please Enter Valid Email", Toast.LENGTH_SHORT).show();
//            } else if(passwordEntered.getText().toString().isEmpty())
//            {
//                Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
//            }else{
//                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
//                if(task.isSuccessful())
//                {
//                    startActivity(new Intent(login.this, MainActivity.class));
//                }
//                else
//                {
//                    Toast.makeText(login.this,
//                            "Please Check Your login Credentials",
//                            Toast.LENGTH_SHORT).show();
//                }
//
//                });
//            }
//
//        });
    }


    public void createAccount(View view) {
        Intent i = new Intent(getApplicationContext(), registration.class);
        startActivity(i);
    }
}