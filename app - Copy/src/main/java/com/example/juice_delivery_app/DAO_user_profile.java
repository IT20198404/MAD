package com.example.juice_delivery_app;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAO_user_profile {
    private DatabaseReference databaseReference;
    public DAO_user_profile()
    {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(class_user_profle.class.getSimpleName());
    }

    public Task<Void> add(class_user_profle profile)
    {
        return databaseReference.push().setValue(profile);
    }
}

