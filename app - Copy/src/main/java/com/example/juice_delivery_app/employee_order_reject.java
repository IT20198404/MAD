package com.example.juice_delivery_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class employee_order_reject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_order_reject);

        final EditText description = findViewById(R.id.description);
       // final EditText order = findViewById(R.id.order);
        final String order = "01";
        final Spinner reason = (Spinner) findViewById(R.id.reason);


        Button btn = findViewById(R.id.submit);
        DAO_emplooye_reject_order order_reject = new DAO_emplooye_reject_order();

        btn.setOnClickListener(v->
        {
            if (description.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please Enter Description", Toast.LENGTH_SHORT).show();
            } else if (reason.getSelectedItem().toString().isEmpty()) {
                Toast.makeText(this, "Please Enter Reason For Reject", Toast.LENGTH_SHORT).show();
            } else if (order.isEmpty()) {
                Toast.makeText(this, "System Error", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), employee_dashboard.class);
                startActivity(intent);
            }else{
                class_order_reject orderReject = new class_order_reject(order, reason.getSelectedItem().toString(), description.getText().toString());
                order_reject.add(orderReject).addOnSuccessListener(suc ->
                {

                    Intent intent = new Intent(getApplicationContext(), employee_dashboard.class);
                    startActivity(intent);
                    Toast.makeText(this, "Order Success Success", Toast.LENGTH_SHORT).show();

                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }

        });
    }
}
