package com.example.fistinbone.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by zsn on 9/15/2017.
 */

public class ThankYou extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thankyou);
    }

    //back to the main page
    public void goBack(View v){
        Intent i =new Intent(this, WomCare.class);
        startActivity(i);
    }

}
