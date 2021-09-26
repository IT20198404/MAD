package com.example.juice_delivery_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.juice_delivery_app.class_users.email_Global;

public class feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        final TextView txt_Name = findViewById(R.id.txtName);
        final EditText txt_Tel = findViewById(R.id.txtTel);
        final EditText edittext = findViewById(R.id.edit_text);
        final Spinner feedback_Type = (Spinner) findViewById(R.id.feedbackType);

        Button btnSubmit = findViewById(R.id.btnSubmit);
        DAO_feedback dao_feedback = new DAO_feedback();

        btnSubmit.setOnClickListener(v ->
        {
            if (txt_Name.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please Enter Full Name", Toast.LENGTH_SHORT).show();
            }else if(txt_Tel.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Please Telephone Number", Toast.LENGTH_SHORT).show();
            }else if(txt_Tel.getText().toString().length() != 10)
            {
                Toast.makeText(this, "Please Enter Valid Telephone Number", Toast.LENGTH_SHORT).show();
            }else if(!(txt_Tel.getText().toString().trim().matches("^[0-9]{10}"))){
                Toast.makeText(this, "Please Enter Valid Telephone Number", Toast.LENGTH_SHORT).show();
            } else {
                class_feedback feedback = new class_feedback(email_Global, txt_Name.getText().toString(), txt_Tel.getText().toString(), edittext.getText().toString(), feedback_Type.getSelectedItem().toString());

                dao_feedback.add(feedback).addOnSuccessListener(suc ->
                {
                    Intent intent = new Intent(getApplicationContext(), user_dashboard.class);
                    startActivity(intent);
                    Toast.makeText(this, "Feedback Saving Success", Toast.LENGTH_SHORT).show();

                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }


        });
    }
}
