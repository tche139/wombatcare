package com.example.fistinbone.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by zsn on 8/31/2017.
 */

public class OurTeam extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ourteam);
        getSupportActionBar().setTitle("OurTeam");

    }
}
