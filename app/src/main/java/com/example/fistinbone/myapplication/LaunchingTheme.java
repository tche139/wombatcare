package com.example.fistinbone.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by fistinbone on 8/18/2017.
 */

public class LaunchingTheme extends AppCompatActivity {
    private static int WAIT_FOR = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.LaunchingTheme);

        //launch wombat animation
        handler.sendEmptyMessage(WAIT_FOR);
        Intent intent = new Intent(this, WombatMovie.class);
        startActivity(intent);
        finish();
    }

    //
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            if (msg.what == WAIT_FOR){
                try{
                    //the length of time to sleep in milliseconds
                    Thread.sleep(2000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    };

}
