package com.encryptionapp.junaid.encryptionapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

class add_details {
    public add_details(final Context context, String phoneNumber) {

        final String uid=FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseFirestore Database=FirebaseFirestore.getInstance();
        Map<String,Object>user=new HashMap<>();
        user.put(phoneNumber,uid);
        Database.collection("user")
                .document("Binding")
                .set(user).addOnSuccessListener(new OnSuccessListener < Void > () {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(context, "User Registered",
                        Toast.LENGTH_SHORT).show();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "ERROR" + e.toString(),
                                Toast.LENGTH_SHORT).show();
                        Log.d("TAG", e.toString());
                    }
                });

    }
}
