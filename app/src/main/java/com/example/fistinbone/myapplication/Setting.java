package com.example.fistinbone.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.fistinbone.myapplication.SQLite.FeedReaderContract.FeedEntry.GENDER;
import static com.example.fistinbone.myapplication.WomCare._gender;
import static com.example.fistinbone.myapplication.WomCare._name;

/**
 * Created by fistinbone on 8/29/2017.
 */

public class Setting extends AppCompatActivity {

    public String gender;
    public String userName;
    public TextView gender1;
    public TextView userName1;
    public ImageView photo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        getSupportActionBar().setTitle("Setting");

        gender = _gender;
        userName = _name;
        userName1 = (TextView) findViewById(R.id.textView4);
        gender1 = (TextView) findViewById(R.id.textView5);
        photo = (ImageView) findViewById(R.id.imageView23);

        //set Userinfo from the database
        userName1.setText(userName);
        gender1.setText(gender);
        //change the picture if the gender change
        if(gender != null) {
            switch (gender) {
                case ("male"):
                    photo.setImageResource(R.drawable.male);
                    break;
                case ("female"):
                    photo.setImageResource(R.drawable.female);
                    break;
            }
        }
        else{
            //default setting of the picture
            photo.setImageResource(R.drawable.female);
        }


    }

    //move to the profile layout page
    public void editProfile (View view){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    //send feedback by email
    public void sendEmail(View view){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"tche139@student.monash.edu"});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        i.putExtra(Intent.EXTRA_TEXT   , "body of email");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    //move to the team page
    public void ourTeam(View view){
        Intent intent = new Intent(this, OurTeam.class);
        startActivity(intent);
    }

    //move to the appversion page
    public void appVersion(View view){
        Intent intent = new Intent(this, AppVersion.class);
        startActivity(intent);
    }
}