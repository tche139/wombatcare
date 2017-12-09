package com.example.fistinbone.myapplication;

/**
 * Created by zsn on 9/4/2017.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.fistinbone.myapplication.SQLite.Update;
import com.example.fistinbone.myapplication.SQLite.UpdateProfile;

import static com.example.fistinbone.myapplication.WomCare._gender;
import static com.example.fistinbone.myapplication.WomCare._name;

public class Profile extends AppCompatActivity{

    public static final int GET_FROM_GALLERY = 3;
    public ImageView imageToUpload;
    public ImageView headPicture;
    public EditText userName2;
    private RadioGroup group;
    RadioButton maleButton;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        getSupportActionBar().setTitle("Profile");

        imageToUpload = (ImageView) findViewById(R.id.imageView17);
        headPicture = (ImageView) findViewById(R.id.imageView23);
        userName2 = (EditText) findViewById(R.id.editText);
        group = (RadioGroup) findViewById(R.id.radioGroup2);
        maleButton = (RadioButton) findViewById(R.id.maleButton);

    }

    //upload image from gallary
    public void uploadImage(View v) {
        Intent gallaryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallaryIntent, GET_FROM_GALLERY);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Detects request codes
        if (requestCode == GET_FROM_GALLERY && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            try {
                    imageToUpload.setImageURI(selectedImage);
            }
            catch (Exception e) {
                    onBackPressed();
            }
        }
    }


    public void sendUserInfo(View v){

        Intent intent = new Intent(getApplicationContext(), Setting.class);
        //get string of the username
        _name = userName2.getText().toString() ;
        //Returns the number of children in the group.
        if(group.getCheckedRadioButtonId() == -1){
            Toast.makeText(this,"please pick a gender",Toast.LENGTH_LONG).show();
        }else {
            if (maleButton.getId() == group.getCheckedRadioButtonId()){
                _gender = "male";
            }else{
                _gender = "female";
            }
            if (userName2.getText().toString().equals("")){
                Toast.makeText(this,"please pick a name",Toast.LENGTH_LONG).show();
            }else {
                UpdateProfile updateProfile = new UpdateProfile(this,_name,_gender);
                updateProfile.execute();
                startActivity(intent);
            }
        }
    }
}
