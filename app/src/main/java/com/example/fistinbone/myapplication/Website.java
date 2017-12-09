package com.example.fistinbone.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by fistinbone on 8/29/2017.
 */

public class Website extends AppCompatActivity {
    Float factor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.websites);
        getSupportActionBar().setTitle("Websites");

        // The screen density expressed as dots-per-inch.
        factor = getResources().getDisplayMetrics().density;

    }

    //add links to external websites
    public void website(View v){
        String url = null;
        switch (v.getId()){
            case R.id.website1:
                url = "https://en.wikipedia.org/wiki/Wombat";
                break;
            case R.id.website2:
                url = "https://www.zoo.org.au/healesville/animals/wombat";
                break;
            case R.id.website3:
                url = "http://mangemanagement.org.au";
                break;
            case R.id.website4:
                url = "http://www.iucnredlist.org/search";
                break;
            case R.id.website5:
                url = "https://womsat.org.au/womsat/default.aspx";
                break;
            case R.id.website6:
                url = "https://www.zoo.org.au/healesville/wild-encounters/wombat-pat-and-play";
        }
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}
