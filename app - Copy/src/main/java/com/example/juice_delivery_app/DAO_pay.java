package com.example.juice_delivery_app;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAO_pay {
    private DatabaseReference databaseReference;
    public DAO_pay()
    {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(class_pay.class.getSimpleName());
    }

    public Task<Void> add(class_pay pay)
    {
//        if(usr == null)
        return databaseReference.push().setValue(pay);
    }
}
