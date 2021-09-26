package com.example.juice_delivery_app;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAO_feedback {
    private DatabaseReference databaseReference;
    public DAO_feedback()
    {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(class_feedback.class.getSimpleName());
    }

    public Task<Void> add(class_feedback feedback)
    {
//        if(usr == null)
        return databaseReference.push().setValue(feedback);
    }
}
