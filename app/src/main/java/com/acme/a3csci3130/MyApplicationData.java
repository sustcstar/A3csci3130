package com.acme.a3csci3130;

import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * This class sets up  the firebase db.
 * @author Juliano Franz.
 */
public class MyApplicationData extends Application {
    public DatabaseReference firebaseReference;
    public FirebaseDatabase firebaseDBInstance;
}
