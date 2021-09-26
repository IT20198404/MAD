package com.example.juice_delivery_app;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAO_user {
    private DatabaseReference databaseReference;
    public DAO_user()
    {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(class_users.class.getSimpleName());
    }

    public Task<Void> add(class_users usr)
    {
//        if(usr == null)
        return databaseReference.push().setValue(usr);
    }
}
