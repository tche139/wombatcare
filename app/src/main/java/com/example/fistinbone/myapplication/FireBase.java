package com.example.fistinbone.myapplication;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

/**
 * Created by fistinbone on 9/17/2017.
 */
class FireBase{
    String date;
    String picture;
    String location;
    String wombatStatus;
    String user;
    String gender;

    Boolean uploaded = false;
    FireBase(String date,String picture,String location, String wombatStatus, String user, String gender){
        this.date = date;
        this.picture = picture;
        this.location = location;
        this.wombatStatus = wombatStatus;
        this.user = user;
        this.gender = gender;
    }

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference root = database.getReference();

    //set up the eventlistener
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if (!uploaded) {
                int index = 0;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    index++;
                }
                //get the data sent
                DatabaseReference childRef = database.getReference(Integer.toString(index)).child("found date");
                childRef.setValue(date);
                childRef = database.getReference(Integer.toString(index)).child("picture(bitmap)");
                childRef.setValue(picture);
                childRef = database.getReference(Integer.toString(index)).child("user");
                childRef.setValue(user);
                childRef = database.getReference(Integer.toString(index)).child("gender");
                childRef.setValue(gender);
                childRef = database.getReference(Integer.toString(index)).child("location");
                childRef.setValue(location);
                childRef = database.getReference(Integer.toString(index)).child("wombatStatus");
                childRef.setValue(wombatStatus);
                uploaded = !uploaded;
            }
        }
        @Override
        //if the data sending cancelled, report
        public void onCancelled(DatabaseError error) {
            Log.w(TAG, "Failed to read value.", error.toException());
        }
    };





    public void removeData(){
        root.removeValue();

    }

    //upload data
    public void uploadData(){
        root.addValueEventListener(valueEventListener);

    }




}
