package com.example.fistinbone.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.util.Date;

import static com.example.fistinbone.myapplication.WomCare._gender;
import static com.example.fistinbone.myapplication.WomCare._name;


/**
 * Created by zsn on 9/13/2017.
 */

public class Report extends AppCompatActivity implements OnMapReadyCallback {

public static String x;
    String id;

    double latitude1,longitude1;
    GoogleMap mGoogleMap;
    Bitmap bitmap;
    ImageView reportCamera;
    TextView date;
    TextView time;
    TextView longitude;
    TextView latitude;
    ScrollView profileScroll;
    private RadioGroup wGroup;

    private StorageReference mStorageRef;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);
        getSupportActionBar().setTitle("Report");


        reportCamera = (ImageView) findViewById(R.id.imageView19);
        date = (TextView) findViewById(R.id.editText4);
        time = (TextView) findViewById(R.id.editText5);
        wGroup = (RadioGroup) findViewById(R.id.radioGroup3);

        String currentDateString = DateFormat.getDateInstance().format(new Date());
        String currentTimeString = DateFormat.getTimeInstance().format(new Date());
        //create an instance of GPS tracker
        ProviderTracker gps = new ProviderTracker(this);

        date.setText(currentDateString);
        time.setText(currentTimeString);

        //check if the gps can find the location
        if (gps.canGetLocation()) {
            latitude1 = gps.getLatitude();
            longitude1 = gps.getLongitude();

        } else {
            // pop up message if the user cannot get the location
            Context context = getApplicationContext();
            CharSequence text = "Reload the page after giving App and GPS permission.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        //check if the google service is available and load the map
        if(googleServiceAvailable()) {
            initMap();
        }
        else{
            Toast.makeText(this, "No google maps layout", Toast.LENGTH_LONG).show();
        }

        //camera listener
        reportCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
    }

    //get camera picture and set to the imageview
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            bitmap = (Bitmap) data.getExtras().get("data");
            reportCamera.setImageBitmap(bitmap);
        }
        if (resultCode == RESULT_CANCELED) {
            Intent i = new Intent(this, Report.class);
            startActivity(i);
        }
    }

    public void initMap(){
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }

    public boolean googleServiceAvailable(){
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if(isAvailable == ConnectionResult.SUCCESS){
            return true;
        }
        else if (api.isUserResolvableError(isAvailable)){
            Dialog dialog = api.getErrorDialog(this, isAvailable, 0);
            dialog.show();
        }
        else{
            Toast.makeText(this, "Cant connect to play services", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap){
        mGoogleMap = googleMap;
        ProviderTracker gps = new ProviderTracker(this);
        LatLng ll = new LatLng(gps.getLatitude(), gps.getLongitude());
        googleMap.addMarker(new MarkerOptions().position(ll)
                .title("Marker"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ll, 15));
    }

    //click submit button to the thankyou page
    public void submitReport(final View v) {
        // Returns the view at the specified position in the group.
        int len = wGroup.getChildCount();
        Intent intent = new Intent(this, ThankYou.class);
        for (int i = 0; i < len; i++) {
            RadioButton radioButton = (RadioButton) wGroup.getChildAt(i);
            //check if the decision is made
            if (wGroup.getCheckedRadioButtonId() == -1) {
                Context context = getApplicationContext();
                CharSequence text = "Please choose a wombat status.";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            else {
                if(radioButton.isChecked()) {
                    String wombatStatus = radioButton.getText().toString();
                    String date = new Date().toString();
                    reportCamera.buildDrawingCache();
                    String picture = BitMapToString(reportCamera.getDrawingCache());
                    String location = "lat:" + latitude1 + ",lon:" + longitude1;
                    FireBase fireBase = new FireBase(date, picture, location, wombatStatus,_name,_gender);
                    fireBase.uploadData();
                    Toast.makeText(this, "success", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                    break;
                }
            }
        }
    }
    //bitmap to string
    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp= Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }

}

